# Random test

# create test function 1

DELIMITER $$
CREATE FUNCTION ufn_function_name(str VARCHAR(50)) -- входен аргумент (може и без)
RETURNS VARCHAR(50) -- / INT
DETERMINISTIC 
BEGIN
RETURN concat(str, ' Function');
END$$

# drop function
DELIMITER ;
DROP FUNCTION ufn_test_function;

select ufn_test_function('TEST');


#1 Count Employees by Town 

DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50)) -- town_name входен аргумент
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE e_count INT; 
SET e_count := (select count(*) from employees e, addresses a, towns t
where e.address_id = a.address_id 
and a.town_id = t.town_id 
and t.name = `town_name`); -- използваме входния аргумент 
RETURN e_count; 
END$$

DELIMITER ;
DROP FUNCTION ufn_count_employees_by_town;

select ufn_count_employees_by_town('Redmond') as Count;
select t.town_id, t.name, ufn_count_employees_by_town(name) as Count from towns t;


DELIMITER $$
CREATE PROCEDURE usp_test_procedure(max_id INT)
BEGIN
select * from employees where employee_id < max_id;
END$$

DELIMITER ;
drop PROCEDURE usp_test_procedure;
call usp_test_procedure(4);


#2 Employees Promotion 
DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN
update employees e set salary = salary * 1.05 where e.department_id in (select 
department_id from departments where name = `department_name`);
END$$

-- Проверка
DELIMITER ;
select first_name, salary
from employees e,
	departments d
where e.department_id = d.department_id
and d.name = 'Finance'
order by 1,2;

-- Извикване на процедурата
call usp_raise_salaries('Finance');

#3 Employees Promotion By ID 

DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN 

DECLARE employee_id_count INT;
SET employee_id_count := (select count(*) from employees where employee_id = id); -- проверяваме за запис/и с това ID (0 - няма)

IF (employee_id_count = 1)
THEN update employees set salary = salary * 1.05 where employee_id = id;
END IF;

END$$


#4 Triggered 

CREATE TABLE deleted_employees (
employee_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR (50),
last_name VARCHAR (50),
middle_name VARCHAR (50),
job_title VARCHAR (50),
department_id INT,
salary decimal (19,4)
);

DELIMITER $$
CREATE TRIGGER tr_after_delete_employees
AFTER DELETE 
ON employees
FOR EACH ROW
BEGIN
INSERT INTO deleted_employees (first_name, last_name, middle_name, job_title, department_id, salary)
VALUES (OLD.first_name, OLD.last_name, OLD.middle_name, OLD.job_title, OLD.department_id, OLD.salary);
END$$

DELIMITER ;
drop TRIGGER tr_after_delete_employees;

delete from employees where employee_id = 216;
select * from deleted_employees;