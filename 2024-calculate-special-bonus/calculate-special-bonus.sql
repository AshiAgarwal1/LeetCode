# Write your MySQL query statement below
Select employee_id, 
Case
    When employee_id % 2 = 1 and name not like 'M%'
    Then salary
    Else 0
End As bonus 
From Employees
Order by employee_id