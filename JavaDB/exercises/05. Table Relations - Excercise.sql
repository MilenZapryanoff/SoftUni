#1 - One-To-One Relationship

CREATE TABLE passports (
    passport_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    passport_number VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE people (
    person_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    passport_id INT UNIQUE,
    CONSTRAINT fk_people_passports FOREIGN KEY (passport_id)
        REFERENCES passports (passport_id)
);

INSERT INTO passports (passport_id, passport_number)
VALUES (101,'N34FG21B'), 
	(102,'K65LO4R7'),
    (103,'ZE657QP2');

INSERT INTO people (first_name, salary, passport_id)
VALUES ('Roberto',43300.00,102),
	('Tom',56100.00,103),
    ('Yana',60200.00,101);

#2 - One-To-Many Relationship 

CREATE TABLE manufacturers (
manufacturer_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
name VARCHAR(255),
established_on date);

CREATE TABLE models (
model_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
name VARCHAR(255),
manufacturer_id INT, 
CONSTRAINT fk_models_manufacturers 
FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (manufacturer_id)
);

INSERT INTO manufacturers (name, established_on)
VALUES ('BMW','1916-03-01'),
	('Tesla','2003-01-01'),
    ('Lada','1966-05-01');

INSERT INTO models (model_id, `name`, manufacturer_id)
VALUES  (101,'X1',1),
	(102,'i6',1),
	(103,'Model S',2),
    (104,'Model X',2),
    (105,'Model 3',2),
    (106,'Nova',3);

#3 - Many-To-Many Relationship 

CREATE TABLE students (
student_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255));

CREATE TABLE exams (
exam_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255));

CREATE TABLE students_exams(
student_id INT,
exam_id INT,
CONSTRAINT pk_student_id_exam_id PRIMARY KEY (student_id, exam_id), 
CONSTRAINT fk_student_id_students FOREIGN KEY (student_id) REFERENCES students (student_id),
CONSTRAINT fk_exam_id_exams FOREIGN KEY (exam_id) REFERENCES exams (exam_id)
);

INSERT INTO students (name)
VALUES ('Mila'),
	('Toni'),
    ('Ron');
    
  INSERT INTO exams (exam_id, name)
VALUES (101,'Spring MVC'),
	(102,'Neo4j'),
    (103,'Oracle 11g');
    
 INSERT INTO students_exams (student_id, exam_id)
VALUES (1,101),
	(1,102),
    (2,101),
    (3,103),
    (2,102),
	(2,103);   
    
#4 - Self-Referencing 

CREATE TABLE teachers (
    teacher_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    manager_id INT
);

INSERT INTO teachers (teacher_id, name, manager_id)
VALUES (101,'John',NULL),
	(102,'Maya',106),
    (103,'Silvia',106),
    (104,'Ted',105),
    (105,'Mark',101),
	(106,'Greta',101);      

ALTER TABLE teachers
add CONSTRAINT fk_manager_id_teacher_id FOREIGN KEY teachers (manager_id) REFERENCES teachers (teacher_id);

#5 - Online Store Database 

CREATE DATABASE STORE;
USE STORE;

CREATE TABLE cities (
    city_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    birthday DATE,
    city_id INT,
    CONSTRAINT fk_cutomers_cities FOREIGN KEY (city_id)
        REFERENCES cities (city_id)
);

CREATE TABLE orders (
order_id INT PRIMARY KEY AUTO_INCREMENT,
customer_id INT,
    CONSTRAINT fk_orders_customers FOREIGN KEY (customer_id)
        REFERENCES customers (customer_id)
);

CREATE TABLE item_types (
item_type_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50)
);

CREATE TABLE items (
item_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
item_type_id INT,
  CONSTRAINT fk_items_item_types FOREIGN KEY (item_type_id)
        REFERENCES item_types (item_type_id)
);

CREATE TABLE order_items (
order_id INT,
item_id INT,
CONSTRAINT fk_order_items_orders FOREIGN KEY (order_id)
        REFERENCES orders (order_id),
CONSTRAINT fk_order_items_items FOREIGN KEY (item_id)
        REFERENCES items (item_id),
CONSTRAINT pk_order_items PRIMARY KEY (order_id, item_id)
);

#6 - University Database 