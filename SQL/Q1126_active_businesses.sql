-- ref. https://leetcode.com/problems/active-businesses/discuss/335607/MySQL-beats-100

# Write your MySQL query statement below

SELECT a.business_id
FROM
    Events AS a
    LEFT JOIN
    (
        SELECT
            event_type,
            AVG(occurences) AS average
        FROM Events
        GROUP BY event_type
    ) AS b
    ON a.event_type = b.event_type
WHERE
    a.occurences > b.average
GROUP BY
    business_id
HAVING COUNT(*) > 1;