# 175. 组合两个表 - 外部联结
SELECT firstName, lastName, city, state
FROM person AS p LEFT OUTER JOIN address AS a
ON p.personid = a.personid;