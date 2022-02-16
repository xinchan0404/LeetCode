# 596. 超过5名学生的课
SELECT class
FROM courses
GROUP BY class
HAVING COUNT(class) >= 5;