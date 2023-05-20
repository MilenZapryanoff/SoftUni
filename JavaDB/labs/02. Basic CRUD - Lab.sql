#SOLUTIONS 

#1
SELECT id, first_name, last_name, job_title
FROM employees
ORDER BY id;

#2
SELECT 
    id, CONCAT(first_name, ' ', last_name) AS full_name, job_title, salary
FROM employees
WHERE salary > 1000
ORDER BY id;

#3
UPDATE employees
SET salary = salary + 100
WHERE job_title = "Manager";
SELECT salary
FROM employees;
    
#4
SELECT * FROM employees
WHERE salary = (SELECT MAX(salary) FROM employees);

#5
SELECT * FROM employees
WHERE department_id = 4
AND salary >= 1000
ORDER BY 1;

#6
DELETE FROM employees
where department_id in (1,2);
SELECT * FROM employees
ORDER BY id;