-- Employees Earning More Than Their Managers
-- Write your MySQL query statement below
SELECT a.Name as Employee
  FROM Employee a
 INNER JOIN Employee b
    ON (a.ManagerId = b.Id)
 WHERE a.Salary > b.salary