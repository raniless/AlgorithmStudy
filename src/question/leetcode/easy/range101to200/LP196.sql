-- Delete Duplicate Emails
--  https://leetcode.com/problems/delete-duplicate-emails/

-- Write your MySQL query statement below
DELETE p1
  FROM Person p1
     , Person p2
 WHERE p1.Email = p2.Email
   AND p1.Id > p2.Id

DELETE FROM p1
 USING Person p1, Person p2
 WHERE p1.Email = p2.Email
   AND p1.Id > p2.Id

-- Best (Subquery에 Alias 없으면 오류 발생)
DELETE FROM Person
  WHERE Id NOT IN (SELECT U.Id
                     FROM (SELECT Id
                                , RANK() OVER (PARTITION BY Email Order BY Id) as RNum
                             FROM Person) U
                     WHERE U.RNum = 1)