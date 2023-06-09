#1 Employee Address 
SELECT 
    e.employee_id, e.job_title, e.address_id, a.address_text
FROM
    employees e,
    addresses a
WHERE
    e.address_id = a.address_id
ORDER BY e.address_id
LIMIT 5;

#2 Addresses with Towns 
SELECT 
    e.first_name, e.last_name, t.name AS town, a.address_text
FROM
    employees e,
    addresses a,
    towns t
WHERE
    e.address_id = a.address_id
        AND a.town_id = t.town_id
ORDER BY 1 , 2
LIMIT 5;
 
#3 Sales Employee 
SELECT 
    e.employee_id,
    e.first_name,
    e.last_name,
    d.name AS department_name
FROM
    employees e,
    departments d
WHERE
    e.department_id = d.department_id
        AND d.name = 'Sales'
ORDER BY 1 DESC;

#4 Employee Departments
SELECT 
    e.employee_id,
    e.first_name,
    e.salary,
    d.name AS department_name
FROM
    employees e,
    departments d
WHERE
    e.department_id = d.department_id
        AND e.salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;

#5 Employees Without Project 
SELECT 
    e.employee_id, e.first_name
FROM
    employees e
WHERE     e.employee_id NOT IN (SELECT employee_id FROM employees_projects)
ORDER BY 1 DESC
LIMIT 3;

#6 Employees Hired After 
SELECT 
    e.first_name,
    e.last_name,
    e.hire_date,
    d.name AS department_name
FROM
    employees e,
    departments d
WHERE
    e.department_id = d.department_id
        AND e.hire_date > '1999-01-01'
        AND d.name IN ('Sales' , 'Finance')
ORDER BY 3;

select * from employees;

#7 Employees with Project 
SELECT 
    e.employee_id, e.first_name, p.name AS project_name
FROM
    employees e,
    employees_projects ep,
    projects p
WHERE
    ep.employee_id = e.employee_id
        AND ep.project_id = p.project_id
        AND DATE(p.start_date) > '2002-08-13'
        AND p.end_date IS NULL
ORDER BY e.first_name , p.name
LIMIT 5;

#8 Employee 24 
SELECT 
    e.employee_id,
    e.first_name,
    CASE
        WHEN DATE(p.start_date) > '2004-12-31' THEN NULL
        ELSE p.name
    END AS project_name
FROM
    employees e,
	employees_projects ep,
    projects p
WHERE ep.employee_id = e.employee_id
AND ep.project_id = p.project_id
AND p.project_id IN (SELECT project_id FROM employees_projects WHERE e.employee_id = 24)
ORDER BY 3;

#9 Employee Manager 
SELECT 
    e.employee_id, e.first_name, e.manager_id, em.first_name
FROM
    employees e,
    employees em
WHERE e.manager_id = em.employee_id
AND e.manager_id IN (3 , 7)
ORDER BY 2;

#10 Employee Summary 
SELECT 
    e.employee_id,
    CONCAT(e.first_name, ' ', e.last_name) AS employee_name,
    CONCAT(em.first_name, ' ', em.last_name) AS manager_name,
    d.name AS department_name
FROM
    employees e,
    employees em,
    departments d
WHERE e.manager_id = em.employee_id
AND e.department_id = d.department_id
AND e.manager_id IS NOT NULL
ORDER BY 1
LIMIT 5;

#11 Min Average Salary 
SELECT 
    AVG(e.salary) AS min_average_salary
FROM
    employees e
GROUP BY department_id
ORDER BY 1
LIMIT 1;


#12 Highest Peaks in Bulgaria 
SELECT 
    mc.country_code, m.mountain_range, p.peak_name, p.elevation
FROM
    peaks p,
    mountains m,
    mountains_countries mc
WHERE p.mountain_id = m.id
AND m.id = mc.mountain_id
AND p.elevation > 2835
AND mc.country_code = 'BG'
ORDER BY 4 DESC;

#13 Count Mountain Ranges 
SELECT 
    country_code, COUNT(*) as mountain_range
FROM
    mountains_countries mc
WHERE
    country_code IN ('BG' , 'RU', 'US')
GROUP BY country_code
ORDER BY 2 DESC;

#14 Countries with Rivers 
SELECT 
    c.country_name, r.river_name
FROM
    countries c
        LEFT JOIN
    countries_rivers cr ON c.country_code = cr.country_code
        LEFT JOIN
    rivers r ON cr.river_id = r.id
WHERE
    c.continent_code = 'AF'
ORDER BY 1
LIMIT 5;

#15 *Continents and Currencies 
SELECT 
    c.continent_code, currency_code, COUNT(*) AS currency_usage
FROM
    countries c
GROUP BY 1 , 2
HAVING currency_usage > 1
    AND currency_usage = (SELECT 
        COUNT(*) AS count_of_currencies
    FROM
        countries c2
    WHERE
        c2.continent_code = c.continent_code
    GROUP BY c2.currency_code
    ORDER BY count_of_currencies DESC
    LIMIT 1)
ORDER BY 1 , 2;

#16 Countries without any Mountains 
SELECT 
    COUNT(*)
FROM
    countries c
WHERE
    c.country_code NOT IN (SELECT 
            country_code
        FROM
            mountains_countries mc);

#17 Highest Peak and Longest River by Country
SELECT 
    c.country_name,
    MAX(p.elevation) AS highest_peak_elevation,
    MAX(r.length) AS longest_river_length
FROM
    countries c
        JOIN
    countries_rivers cr ON c.country_code = cr.country_code
        JOIN
    rivers r ON cr.river_id = r.id
        JOIN
    mountains_countries mc ON c.country_code = mc.country_code
        JOIN
    mountains m ON mc.mountain_id = m.id
        JOIN
    peaks p ON p.mountain_id = m.id
GROUP BY 1
ORDER BY 2 DESC , 3 DESC , 1
LIMIT 5;
