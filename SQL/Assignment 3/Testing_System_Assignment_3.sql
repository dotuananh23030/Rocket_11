CREATE OR REPLACE VIEW vw_InfAccountMaxGroup
AS
SELECT A.*, COUNT(GA.GroupID) AS SoLuong
FROM groupaccount GA
JOIN `Account` A ON GA.AccountID = A.AccountID
GROUP BY GA.AccountID
HAVING SoLuong = (SELECT COUNT(GA.GroupID) AS SoLuong
                 FROM groupaccount GA
                 JOIN `Account` A ON GA.AccountID = A.AccountID
				 GROUP BY A.AccountID
                 ORDER BY SoLuong DESC
                 LIMIT 1);
SELECT 	* 
FROM 	vw_InfAccountMaxGroup;

CREATE OR REPLACE VIEW vw_DepartmentMaxAccount
AS
SELECT D.*,COUNT(D.DepartmentID) AS SoLuong
FROM department D
JOIN `Account` A ON A.DepartmentID = D.DepartmentID
GROUP BY D.DepartmentID
HAVING SoLuong = (
                    SELECT COUNT(D.DepartmentID) AS SoLuong
					FROM department D
                    JOIN `Account` A ON A.DepartmentID = D.DepartmentID
                    GROUP BY D.DepartmentID
                    ORDER BY COUNT(D.DepartmentID) DESC
                    LIMIT 1
                    );
SELECT 	* 
FROM 	vw_DepartmentMaxAccount;

CREATE OR REPLACE VIEW vw_QuesHoNguyen
AS
SELECT  Q.*,A.FullName
FROM    `account` A 
JOIN    question Q ON A.AccountID = Q.CreatorID
WHERE   SUBSTRING_INDEX(FullName,' ',1) = 'Nguyen';    

SELECT 	* 
FROM 	vw_QuesHoNguyen;

CREATE VIEW Danhsachnhanvienphongsale AS
SELECT *
FROM `Account` A
WHERE A.DepartmentID IN 
            (SELECT DepartmentID
             FROM Department
             WHERE DepartmentName = 'Sale');

CREATE OR REPLACE VIEW vw_ContenTren300Tu
AS             
SELECT 	*,LENGTH(Content)
FROM	Question
WHERE	LENGTH(Content) > 300;

SELECT 	* 
FROM 	vw_ContenTren300Tu;