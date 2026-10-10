# Write your MySQL query statement below
SELECT DISTINCT a.num AS ConsecutiveNums
FROM Logs a
JOIN Logs b ON b.id = a.id+1
JOIN Logs c ON c.id = b.id+1
WHERE a.num = b.num AND b.num = c.num