CREATE DATABASE minions;

#1
CREATE TABLE minions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    age INT
);
CREATE TABLE towns (
    town_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

#2
ALTER TABLE minions
ADD town_id INT,
ADD -- CONSTRAINT fk_minions_towns -- ако искаме да зададем име на FK
FOREIGN KEY (town_id) REFERENCES towns(id); 

#3
INSERT INTO towns ()
VALUES 
(1,'Sofia'), 
(2,'Plovdiv'),
(3,'Varna');

INSERT INTO minions ()
VALUES 
(1,'Kevin',22,1), 
(2,'Bob',15,3),
(3,'Steward',NULL,2);

#4
TRUNCATE minions;

#5
DROP TABLE minions, towns;

#6 
drop database minions;
create database `database`;
use `database`;

CREATE TABLE people (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL, 
picture BLOB,
height DOUBLE,
weight DOUBLE,
gender ENUM('m','f') NOT NULL,
birthdate DATE NOT NULL,
biography TEXT
);

INSERT INTO people (name, gender, birthdate)
VALUES 
('Boris', 'm', date(now())),
('Alexander','m',date(now())),
('Elena','f',date(now())),
('Milen','m',date(now())),
('Desislava','f',date(now()));

#7
CREATE TABLE users
(id INT PRIMARY KEY AUTO_INCREMENT, 
username VARCHAR(30) NOT NULL, 
password VARCHAR(26) NOT NULL,
profile_picture BLOB,
last_login_time TIME,
is_deleted BOOLEAN
);
	
INSERT INTO users (username, password, last_login_time, is_deleted)
VALUES 
('Boris', 'parola', time(now()), '0'),
('Milen', 'parola1', time(now()), '0'),
('superUser', 'parola2', time(now()), '0'),
('test_user', 'parola3', time(now()), '1'),
('my_user', 'parola4', time(now()), '0');

#8 -- Промяна на Primary key
ALTER TABLE users
DROP PRIMARY KEY, 
ADD PRIMARY KEY pk_users (`id`, `username`); 

#9 -- Промяна на default-на стойност на колона
ALTER TABLE users
MODIFY COLUMN last_login_time DATETIME DEFAULT now();

#10
ALTER TABLE users 
DROP PRIMARY KEY, 
ADD PRIMARY KEY pk_users (`id`),
MODIFY COLUMN username VARCHAR(30) UNIQUE;

#11
CREATE DATABASE movies;

CREATE TABLE directors (
id INT PRIMARY KEY AUTO_INCREMENT,
director_name VARCHAR(255) NOT NULL,
notes TEXT
);
CREATE TABLE genres (
id INT PRIMARY KEY AUTO_INCREMENT,
genre_name VARCHAR(255) NOT NULL,
notes TEXT
);
CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(255) NOT NULL,
notes TEXT
);
CREATE TABLE movies (
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(255) NOT NULL, 
director_id INT,
copyright_year VARCHAR(255),
length VARCHAR(255),
genre_id INT,
category_id INT,
rating VARCHAR(255),
notes TEXT
);

/*ALTER TABLE movies
ADD CONSTRAINT fk_movies_directors FOREIGN KEY (director_id) REFERENCES directors(id),
ADD CONSTRAINT fk_movies_genre FOREIGN KEY (genre_id) REFERENCES genres(id),
ADD CONSTRAINT fk_movies_category FOREIGN KEY (category_id) REFERENCES categories(id);
*/

INSERT INTO directors()
VALUES 
(1, 'Scorseze', 'Oscar'),
(2, 'Camoron', '3 times Oscar'),
(3, 'King', 'No Oscards'),
(4, 'Niki Iliev', 'No Oscards at all'),
(5, 'Rowling', 'A lot of Oscards');
INSERT INTO genres()
VALUES 
(1, 'Horror', 'scary movie'),
(2, 'Thriller', 'thrill story'),
(3, 'Comedy', 'Funny stuff'),
(4, 'Fantasy', 'Fiction'),
(5, 'Shit', 'Total shit movie');
INSERT INTO categories()
VALUES 
(1, 'Afro-American movie', 'Globus award'),
(2, 'American movie', 'Oscar academy'),
(3, 'French movie', 'Ascer national film fest'),
(4, 'Russian shit', 'Nu pogodi'),
(5, 'Bulgarian movie', 'Sofial film fest');
INSERT INTO movies()
VALUES 
(1, 'Avatar', 2, '2023', '3h15m', 4, 2, NULL, 'Oscar'),
(2, 'Titanic', 2, '2003', '3h04m', 4, 2, NULL, '9 Oscars'),
(3, 'Taxi', 3, '2004', '1h35m', 3, 3, NULL, 'Ascer'),
(4, 'Chalga', 4, '2023', '1h17m', 5, 5, NULL, NULL),
(5, 'Masha i Mechoka', 5, '2000', '1h03m', 4, 4, NULL, NULL);


#12
CREATE DATABASE car_rental;

CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT,
category VARCHAR(255),
daily_rate VARCHAR(255),
weekly_rate VARCHAR(255),
monthly_rate VARCHAR(255),
weekend_rate VARCHAR(255)
);
CREATE TABLE cars (
id INT PRIMARY KEY AUTO_INCREMENT,
plate_number VARCHAR(255) NOT NULL,
make VARCHAR(255) NOT NULL, 
model VARCHAR(255) NOT NULL,
category_id INT,
doors INT,
picture BLOB,
car_condition VARCHAR(255),
available BOOLEAN 
);
CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
title VARCHAR(255),
notes TEXT
);
CREATE TABLE customers (
id INT PRIMARY KEY AUTO_INCREMENT,
driver_licence_number VARCHAR(255) NOT NULL,
full_name VARCHAR(255) NOT NULL,
address VARCHAR(255),
city VARCHAR(255),
zip_code VARCHAR(255),
notes TEXT
);
CREATE TABLE rental_orders (
id INT PRIMARY KEY AUTO_INCREMENT,
employee_id INT NOT NULL,
customer_id INT NOT NULL, 
car_id INT NOT NULL, 
car_condition VARCHAR(255),
tank_level VARCHAR(255),
kilometrage_start INT NOT NULL, 
kilometrage_end INT NOT NULL,
total_kilometrage INT NOT NULL, 
start_date DATE NOT NULL, 
end_date DATE NOT NULL, 
total_days INT NOT NULL, 
rate_applied VARCHAR(255),
tax_rate VARCHAR(255),
order_status VARCHAR(255), 
notes TEXT
);

INSERT INTO categories ()
VALUES 
(1, 'Minivan', NULL, NULL, NULL, NULL),
(2, 'SportsCar', NULL, NULL, NULL, NULL),
(3, 'SUV', NULL, NULL, NULL, NULL);
INSERT INTO cars ()
VALUES 
(1, 'CA 0082 PB', 'Opel', 'Zafira', 1, 5, NULL, 'good', 1),
(2, 'PB 3932 CP', 'Porsche', '911', 2, 3, NULL, 'bad', 0 ),
(3, 'A 4942 AC', 'Mercedes', 'GLE 350', 3, 5, NULL, 'excelent', 1);
INSERT INTO employees ()
VALUES 
(1, 'Ivan', 'Ivanov', 'cashier', NULL),
(2, 'Georgi', 'Glavchev', 'hunter', NULL),
(3, 'Alexander', 'Peev', 'supervisor', NULL);
INSERT INTO customers ()
VALUES 
(1, '29v9as88','Atanas Topuzakov', 'Em. Stanev', 'Sofia', '1000', NULL),
(2, '1515158A','Erik Rogers', 'Rodeo dr.', 'Los Angeles', 'CA5065', NULL),
(3, '153355BC','Ivan Andreev', 'Em. Stanev', 'Dimitrovgrad', '6400', NULL);
INSERT INTO rental_orders ()
VALUES 
(1, 1, 1, 1, 'good', 'full', 135000, 136500, 1500, '2023-01-20', '2023-01-25', 5, 'daily', NULL, 'Completed', NULL),
(2, 2, 2, 2, 'bad', 'full', 9500, 9650, 150, '2023-03-20', '2023-03-25', 5, 'daily', NULL, 'Completed', NULL),
(3, 3, 3, 3, 'excelent', 'full', 35000, 37200, 2200, '2023-05-20', '2023-05-25', 5, 'daily', NULL, 'Completed', NULL);

#13
CREATE DATABASE soft_uni;

CREATE TABLE towns (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NOT NULL
);

CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT, 
address_text VARCHAR(255) NOT NULL,
town_id INT NOT NULL,
CONSTRAINT fk_addresses_towns FOREIGN KEY (town_id) REFERENCES towns(id)
);

CREATE TABLE departments(
id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(255) NOT NULL
);

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    job_title VARCHAR(255) NOT NULL,
    department_id INT NOT NULL,
    hire_date DATE,
    salary DECIMAL(10 , 2 ),
    address_id INT,
    CONSTRAINT fk_employees_addresses FOREIGN KEY (address_id) REFERENCES addresses (id),
    CONSTRAINT fk_employees_department FOREIGN KEY (department_id) REFERENCES departments (id)
);

/* ако искаме отделно да добавим FK в таблиците
ALTER TABLE employees
ADD CONSTRAINT fk_employees_addresses FOREIGN KEY (address_id) REFERENCES addresses(id),
ADD CONSTRAINT fk_employees_department FOREIGN KEY (department_id) REFERENCES departments(id);

ALTER TABLE addresses
ADD CONSTRAINT fk_addresses_towns FOREIGN KEY (town_id) REFERENCES towns(id);
*/

INSERT INTO towns (name)
VALUES
('Sofia'), ('Plovdiv'),('Varna'),('Burgas');

INSERT INTO departments (name)
VALUES
('Engineering'), ('Sales'),('Marketing'),('Software Development'),('Quality Assurance');

INSERT INTO employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary)
VALUES
('Ivan','Ivanov','Ivanov','.NET Developer', 4 ,'2013-02-01','3500.00'),
('Petar','Petrov','Petrov','Senior Engineer', 1 ,'2004-03-02','4000.00'),
('Maria','Petrova','Ivanova','Intern', 5 ,'2016-08-28','525.25'),
('Georgi','Terziev','Ivanov','CEO', 2 ,'2007-12-09','3000.00'),
('Peter','Pan','Pan','Intern', 3 ,'2016-08-28','599.88');

#14
SELECT * FROM towns;
SELECT * FROM departments;
SELECT * FROM employees;

#15
SELECT * FROM towns
ORDER BY name;
SELECT * FROM departments
ORDER BY name;
SELECT * FROM employees
ORDER BY salary DESC;

#16
SELECT name FROM towns
ORDER BY name;
SELECT name FROM departments
ORDER BY name;
SELECT first_name, last_name, job_title, salary 
FROM employees
ORDER BY salary DESC;

#17
UPDATE employees 
SET salary = (salary + salary * 0.10);
select salary from employees;
