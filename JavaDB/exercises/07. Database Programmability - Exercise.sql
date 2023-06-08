#1 Employees with Salary Above 35000

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
select first_name, last_name from employees e where e.salary > 35000
order by 1, 2, employee_id;
END$$

DELIMITER ;
call usp_get_employees_salary_above_35000;

#2 Employees with Salary Above Number 

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(salary_input DECIMAL(19, 4))
BEGIN
select e.first_name, e.last_name from employees e where e.salary >= salary_input
order by 1, 2, e.employee_id;
END$$

DELIMITER ;
call usp_get_employees_salary_above(45000);

#3 Town Names Starting With 

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(string_input VARCHAR(50))
BEGIN
DECLARE first_letter VARCHAR(50);
SET first_letter := CONCAT(UPPER(string_input), '%'); 
-- SET first_letter := UPPER(string_input); v2
select t.name from towns t where t.name like first_letter
-- select t.name from towns t where Upper(substr(t.name,1,1)) = first_letter; v2 
order by 1;
END$$

DELIMITER ;
call usp_get_towns_starting_with('b');

#4 Employees from Town 

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
select e.first_name, e.last_name
from employees e, addresses a, towns t
where e.address_id = a.address_id and a.town_id = t.town_id
and t.name = town_name
order by 1,2, e.employee_id;
END$$

DELIMITER ;
call usp_get_employees_from_town('Sofia');

#5 Salary Level Function

DELIMITER $$

CREATE FUNCTION ufn_get_salary_level(salary INT)
RETURNS VARCHAR(50)
DETERMINISTIC 
BEGIN

DECLARE result VARCHAR(50);

IF (salary < 30000) THEN set result := 'Low';
ELSEIF (salary between 30000 and 50000) THEN set result := 'Average';
ELSEIF (salary > 50000) THEN set result := 'High';
END IF;

RETURN result;
END$$

DELIMITER ;
select ufn_get_salary_level(125500) as salary_level;

#6 Employees by Salary Level 

DELIMITER $$

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(50))
BEGIN

IF (salary_level = 'low') THEN select first_name, last_name from employees where salary < 30000 Order by 1 DESC, 2 DESC;
ELSEIF (salary_level = 'average') THEN select first_name, last_name from employees where salary between 30000 and 50000 Order by 1 DESC, 2 DESC;
ELSEIF (salary_level = 'high') THEN select first_name, last_name from employees where salary  > 50000 Order by 1 DESC, 2 DESC;
END IF;

END$$

DELIMITER ;
call usp_get_employees_by_salary_level('average');

#7 Define Function 

DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN word REGEXP (concat('^[', set_of_letters, ']+$'));
END$$

select ufn_is_word_comprised('oistmiahf','Sofia');

#8 Find Full Name 

DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
select concat(first_name, ' ', last_name) as full_name from account_holders Order by 1, id; 
END$$

DELIMITER ; 
call usp_get_holders_full_name();

#9 *People with Balance Higher Than

DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(amount INT) 
BEGIN
SELECT 
    ah.first_name, 
    ah.last_name
FROM
    account_holders ah,
    accounts a
WHERE ah.id = a.account_holder_id
AND amount < (SELECT SUM(balance) FROM accounts acc WHERE acc.account_holder_id = ah.id)
GROUP BY 1,2;
END$$

DELIMITER ;
call usp_get_holders_with_balance_higher_than(7000);

#10 Future Value Function 

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19,4), yearly_interest_rate DOUBLE, number_of_years INT)
RETURNS DECIMAL (19,4)
DETERMINISTIC
BEGIN

DECLARE result DECIMAL(19,4);
SET result := sum * POW((1 + yearly_interest_rate),number_of_years);
RETURN result;

END$$

DELIMITER ;
select ufn_calculate_future_value(1000, 0.5, 5);

#11 Calculating Interest 

DELIMITER $$

CREATE PROCEDURE usp_calculate_future_value_for_account(input_id INT, interest DECIMAL(19,4))
BEGIN
DECLARE sum DECIMAL(19,4);
SET sum := (select a.balance from accounts a where id = input_id);
SELECT 
    a.id as account_id,
    ah.first_name,
    ah.last_name,
    a.balance AS current_balance,
	cast(sum * POW((1 + interest),5) as DECIMAL (19,4)) AS balance_in_5_years
FROM
    account_holders ah,
    accounts a
WHERE a.account_holder_id = ah.id
AND a.id = input_id;
END$$

DELIMITER ; 
call usp_calculate_future_value_for_account(1,0.1);

#12 Deposit Money 

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL (19,4))
BEGIN
START TRANSACTION;
IF (money_amount > 0) THEN update accounts set balance = (balance + money_amount) where id = account_id;
COMMIT;
END IF;
END$$

DELIMITER ;
call usp_deposit_money(1,10); 

#13 Withdraw Money

DELIMITER $$

CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL (19,4))
BEGIN

DECLARE available_sum DECIMAL(19,4);
set available_sum := (select balance from accounts where id = account_id);
IF (money_amount > 0) and (money_amount <= available_sum) THEN update accounts set balance = (balance - money_amount) where id = account_id;
END IF;
END$$

DELIMITER ;
call usp_withdraw_money(1,10); 
select balance from accounts where id = 1;

#14 Money Transfer 

DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL (19,4))
BEGIN

IF (select count(id) from accounts where id = from_account_id) = 1 
and (select count(id) from accounts where id = to_account_id) = 1 
and amount > 0
and amount <= (select balance from accounts where id = from_account_id)
and from_account_id != to_account_id
THEN 
update accounts set balance = balance + amount where id = to_account_id;
update accounts set balance = balance - amount where id = from_account_id; 
END IF;
END$$

DELIMITER ;

