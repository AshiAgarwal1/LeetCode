# Write your MySQL query statement below
Select v.customer_id,
COUNT(*) as count_no_trans
From Visits v
Left Join Transactions t
On v.visit_id = t.visit_id
Where t.transaction_id IS NULL
Group By v.customer_id