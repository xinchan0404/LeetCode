# 183. 从不订购的客户
SELECT c.Name AS 'Customers'
FROM customers AS c
WHERE c.Id NOT IN (
	SELECT CustomerId
	FROM orders);