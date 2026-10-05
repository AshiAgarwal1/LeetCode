# Write your MySQL query statement below
SELECT d.name AS Department ,
 e.name AS Employee ,
 e.salary AS Salary
FROM Employee e 
JOIN Department d
ON e.departmentId = d.id

JOIN (SELECT e.departmentId , MAX(e.salary) AS max_salary
FROM Employee e
GROUP BY e.departmentId) m
ON e.departmentId = m.departmentId
AND e.salary = m.max_salary
