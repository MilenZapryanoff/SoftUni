CREATE database restaurant_db;
USE restaurant_db;

#1 Table Design 

CREATE TABLE products (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) UNIQUE NOT NULL,
type VARCHAR(30) NOT NULL,
price DECIMAL(10,2) NOT NULL
);

CREATE TABLE waiters (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(50),
phone VARCHAR(50),
salary DECIMAL (10,2)
);

CREATE TABLE clients (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
birthdate DATE NOT NULL,
card VARCHAR(50),
review TEXT
);

CREATE TABLE tables (
id INT AUTO_INCREMENT PRIMARY KEY,
floor INT NOT NULL,
reserved TINYINT(1),
capacity INT NOT NULL
);

CREATE TABLE orders (
id INT AUTO_INCREMENT PRIMARY KEY,
table_id INT NOT NULL,
waiter_id INT NOT NULL,
order_time TIME NOT NULL,
payed_status TINYINT(1),
CONSTRAINT fk_orders_table FOREIGN KEY (table_id) 
REFERENCES tables (id),
CONSTRAINT fk_orders_waiter FOREIGN KEY (waiter_id) 
REFERENCES waiters (id)
);

CREATE TABLE orders_clients (
order_id INT,
client_id INT,
CONSTRAINT fk_order FOREIGN KEY (order_id) 
REFERENCES orders (id),
CONSTRAINT fk_clients FOREIGN KEY (client_id) 
REFERENCES clients (id)
);

CREATE TABLE orders_products (
order_id INT,
product_id INT,
CONSTRAINT fk_orders FOREIGN KEY (order_id) 
REFERENCES orders (id),
CONSTRAINT fk_products FOREIGN KEY (product_id) 
REFERENCES products (id)
);

#2 Insert 

INSERT INTO products (name, type, price)
SELECT CONCAT(w.last_name, ' specialty'), 'Cocktail',  ceil(salary * 0.01)
from waiters w
where w.id > 6;
 
#3 Update 

UPDATE orders 
SET 
    table_id = table_id - 1
WHERE
    id BETWEEN 12 AND 23;

#4 Delete 

DELETE FROM waiters 
WHERE
    id NOT IN (SELECT 
        waiter_id
    FROM
        orders);
        
#5 Clients 

SELECT * FROM clients
Order by 4 DESC, 1 DESC;

#6 Birthdate 

SELECT 
    first_name, last_name, birthdate, review
FROM
    clients
WHERE
    card IS NULL
        AND birthdate BETWEEN '1978-01-01' AND '1992-12-31'
ORDER BY 2 DESC , id ASC
LIMIT 5;

#7 Accounts 

SELECT 
    CONCAT(last_name,
            first_name,
            LENGTH(first_name),
            'Restaurant') AS username,
    REVERSE(SUBSTR(email, 2, 12))
FROM
    waiters
WHERE
    salary IS NOT NULL
ORDER BY 2 DESC;

#8 Top from menu 

SELECT 
    p.id, 
    p.name, 
    COUNT(op.product_id) AS count
FROM
    orders_products op,
    products p
WHERE
    op.product_id = p.id
GROUP BY 1
HAVING `count` >= 5
ORDER BY 3 DESC , 2 ASC;
     
#9 Availability 

SELECT 
    t.id,
    t.capacity,
    COUNT(oc.client_id) AS count_clients,
    CASE
        WHEN t.capacity > COUNT(oc.client_id) THEN 'Free seats'
        WHEN t.capacity = COUNT(oc.client_id) THEN 'Full'
        WHEN t.capacity < COUNT(oc.client_id) THEN 'Extra seats'
    END AS availability
FROM
    tables t,
    orders o,
    orders_clients oc
WHERE o.table_id = t.id 
AND oc.order_id = o.id
AND floor = 1
GROUP BY 1
ORDER BY 1 DESC;

#10 Extract bill 

DELIMITER $$
CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))
RETURNS DECIMAL(19,2)
DETERMINISTIC

BEGIN
DECLARE client_id INT;
DECLARE sum DECIMAL(19,2);

set client_id := (select id from clients where concat(first_name, ' ', last_name) = full_name);

set sum = (select sum(p.price)
from products p,
orders_products op,
orders_clients oc
where p.id = op.product_id
and op.order_id = oc.order_id 
and oc.client_id = client_id);

RETURN sum;
END$$

DELIMITER ; 

SELECT c.first_name, c.last_name, udf_client_bill('Silvio Blyth') as 'bill' FROM clients c
WHERE c.first_name = 'Silvio' AND c.last_name= 'Blyth';
 
#11 Happy hour 

DELIMITER $$
CREATE PROCEDURE udp_happy_hour(`type` VARCHAR(50))

BEGIN
update products p set p.price = p.price * 0.80 where p.price >= 10 and p.type=`type`;
END$$

DELIMITER ; 
call udp_happy_hour;