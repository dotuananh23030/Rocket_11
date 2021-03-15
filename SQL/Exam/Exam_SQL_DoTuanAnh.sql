DROP DATABASE IF EXISTS Final_Exam_SQL;
CREATE DATABASE Final_Exam_SQL;
USE	Final_Exam_SQL;

DROP TABLE IF EXISTS Country;
CREATE TABLE Country(
	CountryID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CountryName 			NVARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO Country	(CountryName) VALUE 
					(N'VietNam'),
					(N'THaiLan'	),
					(N'Campuchia');
                    
DROP TABLE IF EXISTS Location;
CREATE TABLE IF NOT EXISTS Location
(	LocationID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	street_address			NVARCHAR(50) NOT NULL,
    postal_code			    INT UNSIGNED NOT NULL,
    CountryID               TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (CountryID) REFERENCES Country(CountryID)
);
                    
INSERT INTO	Location	(		street_address		,	postal_code		,	CountryID		)
VALUES				    (     '128CPhuongLiet'	    ,	   '10000' 	    ,		1		    ),
					    (     '345BangKok'	        ,	   '10100'	    ,		2           ),
					    (     '324PhnomPenh'	    ,	   '12101'      ,		3	        );

DROP TABLE IF EXISTS Employee;
CREATE TABLE IF NOT EXISTS Employee
(	EmployeeID				 INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	full_name			     VARCHAR(50) NOT NULL,
    email			         VARCHAR(50) NOT NULL UNIQUE KEY,
    LocationID               TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (LocationID) REFERENCES Location(LocationID)
);

INSERT INTO	Employee	(   full_name		    ,	              email		                 ,	        LocationID 		)
VALUES				    ('Nguyen Hai Dang'	    ,	   'haidang29productions@gmail.com' 	 ,		       1		    ),
					    ( 'Duong Do'	        ,	   'account3@gmail.com'	    			 ,		       2            ),
					    ( 'bunhanho'	        ,	   'nn03@gmail.com'      				 ,		       3 	        );
                        
SELECT	    E.full_name,E.email,E.LocationID ,C.CountryName 
FROM		Employee E 
INNER JOIN  Location L
ON			E.LocationID = L.LocationID
INNER JOIN	Country C
ON			C.CountryID = L.CountryID
WHERE	    C.CountryName = 'VietNam';

SELECT     C.CountryName , E.email
FROM       Country C
INNER JOIN Location L ON C.CountryID = L.CountryID
INNER JOIN Employee E ON E.LocationID = L.LocationID
WHERE      E.email = 'nn03@gmail.com';


SELECT 		L.LocationID ,C.CountryID ,C.CountryName ,COUNT(E.EmployeeID) AS 'SO LUONG'
FROM        Employee E
INNER JOIN  Location L ON E.LocationID = L.LocationID
INNER JOIN  Country C ON C.CountryID = L.CountryID
GROUP BY	E.LocationID
ORDER BY	E.LocationID ASC;

DROP TRIGGER IF EXISTS Max_Employee_In_Country;
DELIMITER $$
CREATE TRIGGER Max_Employee_In_Country
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
		IF (SELECT 		C.CountryID
			FROM        Employee E
            INNER JOIN  Location L ON E.LocationID = L.LocationID
            INNER JOIN  Country C ON C.CountryID = L.CountryID
			GROUP BY 	E.EmployeeID
			HAVING		Count(E.EmployeeID) >= 10) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Một Country có nhiều nhất 10 Employee';
        END IF;
END $$
DELIMITER ;
INSERT INTO	Employee	(   full_name		    ,	              email		                 ,	        LocationID 		)
VALUES				    ('Nguyen Hai '	       ,	   'haidang29999productions@gmail.com' 	     ,		       1		    );

DROP TRIGGER IF EXISTS casDel;
DELIMITER $$
CREATE TRIGGER casDel
AFTER DELETE ON Location
FOR EACH ROW
BEGIN
		DELETE FROM Employee
        WHERE EmployeeID = OLD.EmployeeID;
END$$
DELIMITER ;
