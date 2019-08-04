# Write your MySQL query statement below

-- Runtime: 153 ms, faster than 52.12% of MySQL online submissions for Shortest Distance in a Plane.
SELECT
    ROUND(
        SQRT(
            MIN( (POW(p1.x - p2.x, 2) + POW(p1.y - p2.y, 2)) )
        ), 2
    ) AS shortest
FROM
    point_2d AS p1
        JOIN
    point_2d AS p2
    ON
    # to avoid calculating the distance of a point with itself
    p1.x != p2.x OR p1.y != p2.y