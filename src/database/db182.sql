# 182. 查找重复的电子邮箱
SELECT DISTINCT p1.Email
FROM Person AS p1, Person AS p2
WHERE p1.Id <> p2.Id AND p1.Email = p2.Email;