-- Customers Who Never Order
--  https://leetcode.com/problems/customers-who-never-order/

-- Write your MySQL query statement below
SELECT Name as Customers
  FROM Customers a
 WHERE NOT EXISTS (SELECT 'X' FROM Orders WHERE CustomerId = a.Id)