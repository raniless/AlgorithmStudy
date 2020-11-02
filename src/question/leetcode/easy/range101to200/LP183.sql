-- Customers Who Never Order
-- Write your MySQL query statement below
SELECT Name as Customers
  FROM Customers a
 WHERE NOT EXISTS (SELECT 'X' FROM Orders WHERE CustomerId = a.Id)