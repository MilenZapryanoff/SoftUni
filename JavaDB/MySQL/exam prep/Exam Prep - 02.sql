CREATE DATABASE online_store;
use online_store;

#1
CREATE TABLE brands (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(40) UNIQUE NOT NULL);

CREATE TABLE categories (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(40) UNIQUE NOT NULL);

CREATE TABLE reviews (
id INT AUTO_INCREMENT PRIMARY KEY,
content TEXT,
rating DECIMAL(10,2) NOT NULL,
picture_url VARCHAR(80) NOT NULL,
published_at DATETIME);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    price DECIMAL(19 , 2 ) NOT NULL,
    quantity_in_stock INT,
    description TEXT,
    brand_id INT NOT NULL,
    category_id INT NOT NULL,
    review_id INT,
    CONSTRAINT fk_products_brands FOREIGN KEY (brand_id)
        REFERENCES brands (id),
    CONSTRAINT fk_products_categories FOREIGN KEY (category_id)
        REFERENCES categories (id),
    CONSTRAINT fk_products_reviews FOREIGN KEY (review_id)
        REFERENCES reviews (id)
);

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    phone VARCHAR(30) UNIQUE NOT NULL,
    address VARCHAR(60) NOT NULL,
    discount_card BIT(1) NOT NULL DEFAULT 0
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_datetime DATETIME NOT NULL,
    customer_id INT, 
    CONSTRAINT fk_orders_customers FOREIGN KEY (customer_id)
        REFERENCES customers (id)
);

CREATE TABLE orders_products (
order_id INT,
product_id INT,
 CONSTRAINT fk_orders_products_order FOREIGN KEY (order_id)
        REFERENCES orders (id),
 CONSTRAINT fk_orders_products_products FOREIGN KEY (product_id)
        REFERENCES products (id)
);

#2

INSERT INTO reviews (content, picture_url, published_at, rating)
SELECT SUBSTRING(p.description, 1,15), reverse(p.name), '2010-10-10', p.price / 8
from products p
where p.id >= 5;

#3

UPDATE products 
SET 
    quantity_in_stock = quantity_in_stock - 5
WHERE
    quantity_in_stock BETWEEN 60 AND 70;
	
#4

DELETE FROM customers 
WHERE
    id NOT IN (SELECT customer_id FROM orders);

#5

SELECT 
    *
FROM
    categories
ORDER BY 2 DESC;

#6

SELECT 
    id, brand_id, name, quantity_in_stock
FROM
    products
WHERE
    price > 1000 AND quantity_in_stock < 30
ORDER BY 4 , 2;

#7

SELECT 
    id, content, rating, picture_url, published_at
FROM
    reviews
WHERE
    content LIKE 'My%'
        AND LENGTH(content) > 61
ORDER BY 3 DESC;

#8

SELECT 
    CONCAT(c.first_name, ' ', c.last_name),
    c.address,
    o.order_datetime
FROM
    customers c,
    orders o
WHERE
    o.customer_id = c.id
        AND o.order_datetime < '2019-01-01'
ORDER BY 1 DESC;

#9

SELECT 
    COUNT(p.id), 
    c.name, 
    SUM(p.quantity_in_stock)
FROM
    categories c,
    products p
WHERE
    p.category_id = c.id
GROUP BY 2
ORDER BY 1 DESC , 3 ASC
LIMIT 5;

#10

DELIMITER $$
CREATE FUNCTION udf_customer_products_count(`name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (select count(op.product_id) 
from customers c,
     orders o,
     orders_products op
where o.customer_id = c.id
and o.id = op.order_id
and first_name = `name`); 
END$$ 

DELIMITER ;
SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as `total_products` FROM customers c
WHERE c.first_name = 'Shirley';

#11

DELIMITER $$
CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN

UPDATE products as p,
	   categories as c,
       reviews as r
       SET p.price = p.price * 0.70
    WHERE p.category_id = c.id
        AND p.review_id = r.id
        AND r.rating < 4
        AND c.name = `category_name`;

-- 2nd version
-- UPDATE products SET price = price * 0.70
-- WHERE id IN (SELECT id FROM (SELECT p.id 
-- 		from products as p,
--            categories as c,
--            reviews as r
--        WHERE p.category_id = c.id
--        AND p.review_id = r.id
--        AND r.rating < 4
--        AND c.name = `category_name`) as t);

END$$

DELIMITER ; 
CALL udp_reduce_price('Phones and tablets');