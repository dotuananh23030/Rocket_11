DROP PROCEDURE IF EXISTS getDepartmentOfInputAccount;
DELIMITER $$
CREATE PROCEDURE getDepartmentOfInputAccount (IN search CHAR(50))
  BEGIN
     SELECT  *
     FROM    Department D
     JOIN    `account` A ON D.DepartmentID = A.DepartmentID 
     WHERE    Username LIKE concat('%',search,'%');
  END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_accountOfGroup;
DELIMITER $$
CREATE PROCEDURE sp_accountOfGroup(IN in_GroupID TINYINT UNSIGNED)
BEGIN

	SELECT 		GroupID, COUNT(AccountID)
    FROM		GroupAccount 
    WHERE		GroupID = in_GroupID 
    GROUP BY	GroupID;
	
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_TypeID_MaxQuestion;
DELIMITER $$
CREATE PROCEDURE sp_TypeID_MaxQuestion()
BEGIN
       SELECT TypeID,COUNT(TypeID)
	   FROM question
	   GROUP BY TypeID
       HAVING COUNT(TypeID) = (SELECT	COUNT(TypeID)
							   FROM		Question 
		                       GROUP BY	TypeID
                               ORDER BY	COUNT(TypeID) DESC
							   LIMIT 		1);
     
 END$$
DELIMITER ;

call sp_TypeID_MaxQuestion();

DROP PROCEDURE IF EXISTS sp_TypeID_MaxQuestion;
DELIMITER $$
CREATE PROCEDURE sp_TypeID_MaxQuestion()
BEGIN
       SELECT TypeID,COUNT(TypeID)
	   FROM question
	   GROUP BY TypeID
       HAVING COUNT(TypeID) = (SELECT	COUNT(TypeID)
							   FROM		Question 
		                       GROUP BY	TypeID
                               ORDER BY	COUNT(TypeID) DESC
							   LIMIT 		1);
     
 END$$
DELIMITER ;

call sp_TypeID_MaxQuestion();

DROP PROCEDURE IF EXISTS sp_findNameByIDTypeQuestion();
DELIMITER $$
CREATE PROCEDURE sp_findNameByIDTypeQuestion()
BEGIN
       SELECT TQ.TypeName
	   FROM   Question Q 
       JOIN   TypeQuestion TQ ON TQ.TypeID = Q.TypeID
	   GROUP BY Q.TypeID
       HAVING COUNT(Q.TypeID) = (SELECT	    COUNT(TypeID)
							     FROM		Question 
		                         GROUP BY	TypeID
                                 ORDER BY	COUNT(TypeID) DESC
							     LIMIT 		1);
     
 END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_nameOfGroupOrUserName;
DELIMITER $$
CREATE PROCEDURE sp_nameOfGroupOrUserName
(IN	in_stringInput VARCHAR(50), IN in_select TINYINT)
BEGIN
	IF in_select = 1 THEN
		SELECT 	*
        FROM	`Group`
        WHERE	GroupName LIKE in_stringInput;
	ELSE
		SELECT 	Email, Username, FullName
        FROM	`Account`
        WHERE	Username LIKE in_stringInput;
	END IF;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_importInf_Of_Account;
DELIMITER $$
CREATE PROCEDURE sp_importInf_Of_Account (IN in_email VARCHAR(50), IN in_fullname VARCHAR(50))
BEGIN
     DECLARE Username VARCHAR(50) DEFAULT SUBSTRING_INDEX(in_email,'@',1);
     DECLARE DepartmentID TINYINT UNSIGNED DEFAULT 1;
     DECLARE PositionID TINYINT UNSIGNED DEFAULT 10;
     DECLARE CreateDate DATETIME DEFAULT NOW();
     
     INSERT INTO `Account`  (Email     ,   Username  , FullName  ,  DepartmentID  ,PositionID  ,CreateDate)
     VALUE                  (in_Email  ,   Username  ,in_FullName  ,DepartmentID  ,PositionID  ,CreateDate);
     
     SELECT *
     FROM   `Account` A
     WHERE A.username = username;  
END$$
DELIMITER ;
DROP PROCEDURE IF EXISTS sp_maxContentWithTypeID;
DELIMITER $$
CREATE PROCEDURE sp_maxContentWithTypeID(IN in_TypeName VARCHAR(15))
BEGIN
    IF (in_TypeName = 'Essay') THEN
		SELECT 	Content, MAX(LENGTH(content))
        FROM	question
        WHERE	TypeID = 1;
	ELSEIF (in_TypeName = 'Multiple-Choice') THEN
		SELECT 	Content, MAX(LENGTH(content))
        FROM	question
        WHERE	TypeID = 2;
	END IF;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_DeleteExamWithID;
DELIMITER $$
CREATE PROCEDURE sp_DeleteExamWithID(IN ExamID TINYINT UNSIGNED)
BEGIN
     DELETE  
     FROM    Exam
     WHERE   ExamID = in_ExamID;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_DeleteUser3Years;
DELIMITER $$
CREATE PROCEDURE sp_Delete3Yeaars()
BEGIN
     DELETE
     FROM 	Exam
     WHERE 	ExamID = (  SELECT ExamID
					    FROM   Exam
                        WHERE  (YEAR(NOW()) - YEAR(CreateDate)) > 3);
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_DepartmentName;
DELIMITER $$
CREATE PROCEDURE sp_DeleteDepartment(IN in_DepartmentName NVARCHAR(50))
BEGIN
      UPDATE `Account`
      SET    DepartmentID = 10
      WHERE  DepartmentID = (SELECT DepartmentID
                             FROM   Department
                             WHERE  DepartmentName = in_DepartmentName);
	  DELETE
      FROM   Department
      WHERE  DepartmentName = in_DepartmentName;
END$$
DELIMITER ;
    