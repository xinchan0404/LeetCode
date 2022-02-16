# 181. 超过经理收入的员工
SELECT emp.`Name` AS `Employee`
FROM Employee AS emp, Employee AS mgr
WHERE emp.ManagerId  = mgr.Id AND emp.salary > mgr.salary;