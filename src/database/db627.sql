# 627. 变更性别
UPDATE Salary
SET sex = CASE sex 
            WHEN 'f' THEN 'm'
            ELSE 'm' 
            END;
            
UPDATE Salary
SET sex = IF(sex = 'f', 'm', 'f');