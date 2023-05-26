#1
SELECT 
    COUNT(*) as count
FROM
    wizzard_deposits;
    
#2
SELECT 
    dMAX(magic_wand_size)
FROM
    wizzard_deposits;
    
#3
SELECT 
    deposit_group, MAX(magic_wand_size) AS 'longest_magic_wand'
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY `longest_magic_wand` , deposit_group;

#4
SELECT 
    deposit_group
FROM
    wizzard_deposits
GROUP BY deposit_group
HAVING AVG(magic_wand_size)
LIMIT 1;

#5
SELECT 
    deposit_group, SUM(deposit_amount) AS total_sum
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY total_sum;    
    
#6 
SELECT 
    deposit_group, SUM(deposit_amount) AS total_sum
FROM
    wizzard_deposits
WHERE
    magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
ORDER BY 1;    

#7
SELECT 
    deposit_group, SUM(deposit_amount) AS total_sum
FROM
    wizzard_deposits
WHERE
    magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
HAVING total_sum < 150000
ORDER BY 2 DESC;  

#8 
SELECT 
    deposit_group, magic_wand_creator, MIN(deposit_charge)
FROM
    wizzard_deposits
GROUP BY deposit_group , magic_wand_creator
ORDER BY magic_wand_creator , deposit_group;

#9
SELECT 
    CASE
        WHEN age >= 0 AND age <= 10 THEN '[0-10]'
        WHEN age >= 11 AND age <= 20 THEN '[11-20]'
        WHEN age >= 21 AND age <= 30 THEN '[21-30]'
        WHEN age >= 31 AND age <= 40 THEN '[31-40]'
        WHEN age >= 41 AND age <= 50 THEN '[41-50]'
        WHEN age >= 51 AND age <= 60 THEN '[51-60]'
        WHEN age >= 61 THEN '[61+]'
    END AS age_group,
    COUNT(age) as wizard_count
FROM
    wizzard_deposits
GROUP BY age_group
ORDER BY 1;

#10
SELECT DISTINCT
    SUBSTR(first_name, 1, 1) AS first_letter
FROM
    wizzard_deposits
WHERE
    deposit_group = 'Troll Chest'
ORDER BY 1;

#11
SELECT 
    deposit_group,
    is_deposit_expired,
    AVG(deposit_interest) AS average_interest
FROM
    wizzard_deposits
WHERE
    deposit_start_date > '1985-01-01'
GROUP BY 1 , 2
ORDER BY deposit_group DESC , is_deposit_expired;

#12
SELECT 
    department_id, MIN(salary)
FROM
    employees
WHERE
    department_id IN (2 , 5, 7)
        AND hire_date > '2000-01-01'
GROUP BY department_id
ORDER BY 1;

#13
CREATE TABLE highest_paid_employees AS SELECT * FROM
    employees
WHERE
    salary > 30000;
DELETE FROM highest_paid_employees 
WHERE
    manager_id = 42;
UPDATE highest_paid_employees 
SET 
    salary = salary + 5000
WHERE
    department_id = 1;
SELECT 
    department_id, AVG(salary)
FROM
    highest_paid_employees
GROUP BY department_id
ORDER BY 1;

#14
SELECT 
    department_id, MAX(salary) AS max_salary
FROM
    employees
GROUP BY department_id
HAVING max_salary NOT BETWEEN 30000 AND 70000
ORDER BY 1;

#15
SELECT 
    COUNT(*) AS ''
FROM
    employees
WHERE
    manager_id IS NULL;

#16
SELECT 
    department_id, MAX(salary) AS third_highest_salary
FROM
    employees
WHERE
    (SELECT 
            COUNT(DISTINCT salary)
        FROM
            employees e2
        WHERE
            e2.department_id = employees.department_id
                AND e2.salary > employees.salary) = 2
GROUP BY department_id
ORDER BY department_id;

#17
SELECT 
    e1.first_name, 
    e1.last_name, 
    e1.department_id 
FROM
    employees as e1
WHERE salary > (SELECT AVG(salary) FROM employees as e2
            WHERE e1.department_id = e2.department_id)
ORDER BY e1.department_id , e1.employee_id
LIMIT 10;

#18
SELECT 
    department_id, SUM(salary)
FROM
    employees
GROUP BY department_id
ORDER BY department_id;