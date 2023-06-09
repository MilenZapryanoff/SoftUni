#1
SELECT title
FROM books
where substr(title, 1, 3) = 'The';

#2
select replace(title, 'The', '***') as title
from books
where substr(title, 1, 3) = 'The';

#3
select ROUND(SUM(cost), 2) 
from books;

#4 
SELECT 
    CONCAT(first_name, ' ', last_name) AS 'Full Name',
    TIMESTAMPDIFF(DAY, born, died) AS 'Days Lived'
FROM authors;

#5
select title
from books
where title like '%Harry Potter%'
order by id;
