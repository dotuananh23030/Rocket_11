DROP DATABASE IF EXISTS Fresher_management;
USE Fresher_management;
INSERT INTO Trainee (   Full_Name		,   Birth_Date	, Gender	, ET_IQ	, ET_Gmath	, ET_English	, Trainning_Class	, Evaluation_Notes		)
VALUE 				('Nguyễn Hải Long'	,  '2000-05-29'	, 'male'	,	20	,	20		,	20			,		'VTI001'	,		'Very good'		),
					('Nguyễn Thị Bình'	,  '2000-05-04'	, 'male'	,	18	,	16		,	16			,		'VTI002'	,		'Normal'		),
                    ('Hoàng Thị Trang'	,  '2000-11-22'	, 'female'	,	11	,	17		,	10			,		'VTI003'	,		'Good'			),
                    ('Đỗ Trung Nam'		,  '2000-07-25'	, 'male'	,	20	,	12		,	20			,		'VTI004'	,		'Good'	    	),
                    ('Ngô Bá Khánh'		,  '2000-05-05'	, 'male'	,	16	,	20		,	16			,		'VTI005'	,		'Normal'		),
                    ('Nguyễn Văn Vỹ'	,  '2000-11-08'	, 'female'	,	19	,	10		,	19			,		'VTI006'	,		'Good'			),
                    ('Nguyễn Hải Hưng'	,  '2000-10-12'	, 'male'	,	20	,	19		,	18			,		'VTI007'	,		'Normal'		),
                    ('Trần Quang Anh'	,  '2000-11-12'	, 'female'	,	15	,	20		,	17			,		'VTI008'	,		'Good'			),
                    ('Nguyễn Thị Chinh'	,  '2000-11-14'	, 'male'	,	20	,	19		,	20			,		'VTI009'	,		'Normal'		),
					('Nguyễn Thị Huyền'	,  '2000-12-13'	, 'female'	,	20	,	19		,	15			,		'VTI010'	,		'Good'			);
      
SELECT * FROM Trainee;

SELECT * 
FROM Trainee
WHERE LENGTH(Full_Name) = (SELECT MAX(LENGTH(Full_Name)) FROM Trainee);

SELECT * 
FROM Trainee
WHERE ET_IQ + ET_Gmath>=20 AND ET_Gmath>=8 AND  ET_English>=18;

DELETE FROM Trainee WHERE TraineeID = 3; 

UPDATE Trainee 
SET Trainning_Class = 'VTI002' 
WHERE TraineeID = 5;

-- Exercise 2
DROP DATABASE Extra;
CREATE DATABASE Extra;
USE	Extra;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	Department_Number 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Department_Name		NVARCHAR(50) UNIQUE KEY NOT NULL
);

DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE Employee_Table(
	Employee_Number 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Employee_Name		NVARCHAR(50) NOT NULL,
    Department_Number	TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(Department_Number) REFERENCES Department(Department_Number)
);

DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE Employee_Skill_Table(
	Employee_Number 	TINYINT UNSIGNED AUTO_INCREMENT,
    Skill_Code			NVARCHAR(20) NOT NULL,
    Date_Registered		DATETIME DEFAULT NOW(),
    FOREIGN KEY(Employee_Number) REFERENCES Employee_Table(Employee_Number)
);

INSERT INTO Department	(Department_Name) 
VALUE 					('Marketing'	),
						('Sale'		),
						('Bảo vệ'		),
						('Nhân sự'		),
						('Kỹ thuật'	),
						('Tài chính'	),
						('Phó giám đốc'),
						('Giám đốc'	),
						('Thư kí'		),
						('Bán hàng'	);
                        
INSERT INTO Employee_Table 	(Employee_Name		, Department_Number	)
VALUE						('Nguyễn Phong'	,		1			),
							('Dương Văn Quuyết'	,		1			),
                            ('Trần Long '	,		2			),
                            ('Chu Chi Minh'	,		5			),
                            ('Trương Văn Nam'	,		6			),
                            ('Hoàng Văn Tuấn'	,		5			),
                            ('Lý Kim Quỳnh'		,		5			),
                            ('Trần Nam'		,		1			),
                            ('Hoàng Dũng'		,		9			),
                            ('Chu Văn Tâm'	,		10			);


INSERT INTO Employee_Skill_Table 	(Employee_Number, Skill_Code	, Date_Registered	)
VALUE								( 	1,				'Java'		, '2020-04-15'		),
									( 	2,				'Android'	, '2020-03-15'		),
									( 	3,				'C#'		, '2020-04-17'		),
									( 	1,				'SQL'		, '2020-03-22'		),
									( 	1,				'Postman'	, '2020-03-23'		),
									( 	4,				'Ruby'		, '2020-05-22'		),
									( 	5,				'Java'		, '2020-04-25'		),
									( 	6,				'C++'		, '2020-04-27'		),
									( 	7,				'C Sharp'	, '2020-04-03'		),
									( 	10,				'PHP'		, '2020-04-11'		);
                                    
SELECT 	ET.Employee_Number, ET.Employee_Name, ET.Department_Number, EST.Skill_Code 
FROM	Employee_Table ET 
RIGHT JOIN Employee_Skill_Table EST   ON		ET.Employee_Number = EST.Employee_Number
WHERE	EST.Skill_Code = 'Java';

SELECT		D.Department_Number, D.Department_Name, COUNT(ET.Department_Number)
FROM		Department D 
JOIN        Employee_Table ET ON			D.Department_Number = ET.Department_Number
GROUP BY 	ET.Department_Number
HAVING		COUNT(ET.Department_Number)>=3 ;

SELECT		ET.*
FROM		Department D 
JOIN        Employee_Table ET     ON		D.Department_Number = ET.Department_Number
ORDER BY	D.Department_Number ASC;

SELECT 		ET.*, COUNT(EST.Employee_Number)
FROM		Employee_Table ET 
RIGHT JOIN Employee_Skill_Table EST
ON			ET.Employee_Number = EST.Employee_Number
GROUP BY	ET.Employee_Number
HAVING 		COUNT(EST.Employee_Number)>1;
