
#1
SELECT 
    department_id, COUNT(*) AS 'Number of employees'
FROM
    employees
GROUP BY department_id
ORDER BY department_id , `Number of employees`;

#2
SELECT 
    department_id, ROUND(AVG(salary), 2) AS 'Average salary'
FROM
    employees
GROUP BY department_id;

#3
SELECT 
    department_id, ROUND(MIN(salary), 2) AS 'Min salary'
FROM
    employees
GROUP BY department_id
HAVING `Min salary` > 800;

#4
SELECT 
    COUNT(*)
FROM
    products
WHERE
    category_id = 2 AND price > 8;
    
#5
SELECT 
    category_id, ROUND(AVG(price), 2), MIN(price), MAX(price)
FROM
    products
GROUP BY category_id;
