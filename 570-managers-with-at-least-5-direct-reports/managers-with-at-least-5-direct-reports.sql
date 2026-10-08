# Write your MySQL query statement below
SELECT e.name 
FROM Employee e
JOIN Employee e1
ON e.id = e1.managerId
GROUP BY e.id , e.name
HAVING COUNT(*) >= 5
