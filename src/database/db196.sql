# 196. 删除重复的电子邮箱
DELETE p1.*
FROM Person AS p1, Person AS p2
WHERE p1.Email = p2.Email AND p1.Id < p2.Id;