# ref. https://stackoverflow.com/questions/16324504/sql-how-to-perform-string-does-not-equal

SELECT *
FROM cinema
WHERE id % 2 = 1 and description <> 'boring' ORDER BY rating DESC;