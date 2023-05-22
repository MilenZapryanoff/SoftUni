#1 
SELECT 
    first_name, last_name
FROM
    employees
WHERE
    first_name LIKE 'Sa%'
ORDER BY employee_id;

#2
SELECT 
    first_name, last_name
FROM
    employees
WHERE
    last_name LIKE '%ei%'
ORDER BY employee_id;

#3
SELECT 
    first_name
FROM
    employees
WHERE
    department_id IN (3 , 10)
        AND hire_date BETWEEN '1995-01-01' AND '2005-12-31'
ORDER BY employee_id;

#4
SELECT 
    first_name, last_name
FROM
    employees
WHERE
    job_title NOT LIKE ('%engineer%')
ORDER BY employee_id;

#5
SELECT 
    name
FROM
    towns
WHERE
    CHAR_LENGTH(name) BETWEEN 5 AND 6
ORDER BY name;

#6
SELECT 
    town_id, name
FROM
    towns
WHERE
    name LIKE ('M%') 
		OR name LIKE ('K%')
        OR name LIKE ('B%')
        OR name LIKE ('E%')
ORDER BY name;

#7
SELECT 
    town_id, name
FROM
    towns
WHERE
    name NOT LIKE ('R%')
        AND name NOT LIKE ('B%')
        AND name NOT LIKE ('D%')
ORDER BY name;

#8
CREATE VIEW v_employees_hired_after_2000 AS
    SELECT 
        first_name, last_name
    FROM
        employees
    WHERE
        hire_date > '2001-01-01';
SELECT * FROM v_employees_hired_after_2000;

#9
SELECT 
    first_name, last_name
FROM
    employees
WHERE
    CHAR_LENGTH(last_name) = 5;

#10
SELECT 
    country_name, iso_code
FROM
    countries
WHERE
    country_name LIKE '%a%a%a%'
ORDER BY iso_code;

#11
SELECT 
    p.peak_name,
    r.river_name,
    CONCAT(LOWER(SUBSTRING(p.peak_name, 1, LENGTH(p.peak_name) - 1)), LOWER(r.river_name)) AS mix
FROM
    peaks p
        JOIN rivers r ON LOWER(SUBSTRING(p.peak_name, - 1)) = LOWER(SUBSTRING(r.river_name, 1, 1))
ORDER BY mix;

#12
SELECT 
    name, DATE_FORMAT(`start`, '%Y-%m-%d') AS 'start'
FROM
    games
WHERE
    `start` BETWEEN '2011-01-01' AND '2012-12-31'
ORDER BY `start`
LIMIT 50;

#13
SELECT 
    user_name,
    SUBSTRING_INDEX(email, '@', - 1) AS 'email provider'
FROM
    users
ORDER BY 2, 1;

#14
SELECT 
    user_name, ip_address
FROM
    users
WHERE
    ip_address LIKE '___.1%.%.___'
ORDER BY user_name;
 
#15
SELECT 
    name AS game,
    CASE
        WHEN HOUR(`start`) >= 0 AND HOUR(`start`) < 12 THEN 'Morning'
        WHEN HOUR(`start`) >= 12 AND HOUR(`start`) < 18 THEN 'Afternoon'
        WHEN HOUR(`start`) >= 18 AND HOUR(`start`) < 24 THEN 'Evening'
        ELSE 'Unknown'
    END AS 'Part of the Day',
    CASE
        WHEN duration <= 3 THEN 'Extra Short'
        WHEN duration BETWEEN 4 AND 6 THEN 'Short'
        WHEN duration BETWEEN 7 AND 10 THEN 'Long'
        ELSE 'Extra Long'
    END AS Duration
FROM
    games;
    
#16
SELECT 
    product_name,
    order_date,
    DATE_ADD(order_date, INTERVAL 3 DAY) AS pay_due,
    DATE_ADD(order_date, INTERVAL 1 MONTH) AS deliver_due
FROM
    orders;