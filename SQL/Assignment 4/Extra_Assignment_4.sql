DROP DATABASE IF EXISTS Project;
CREATE DATABASE Project;
USE Project;

DROP TABLE IF EXISTS Project_Modules;
CREATE TABLE Project_Modules
(
	ModuleID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ProjectID					TINYINT UNSIGNED NOT NULL,
    EmployeeID					TINYINT UNSIGNED NOT NULL,
    ProjectModulesDate			DATETIME DEFAULT NOW(),
    ProjectModulesOn			DATETIME DEFAULT NOW(),
    ProjectModulesDescription	NVARCHAR(50)
);
DROP TABLE IF EXISTS Projects;
CREATE TABLE Projects(
	ProjectID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ManagerID					TINYINT	UNSIGNED NOT NULL,
    ProjectName 				NVARCHAR(50) NOT NULL,
    ProjectStartDate			DATETIME DEFAULT NOW(),
    ProjectDescription			NVARCHAR(50) NOT NULL,
    ProjectDetail				NVARCHAR(50) NOT NULL,
    ProjectCompletedOn			DATETIME DEFAULT NOW()
);
DROP TABLE IF EXISTS Work_Done;
CREATE TABLE Work_Done(
	WorkDoneID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    EmployeeID					TINYINT UNSIGNED NOT NULL,
    ModuleID					TINYINT UNSIGNED NOT NULL,
    WorkDoneDate				DATETIME DEFAULT NOW(),
    WorkDoneDescription			NVARCHAR(50) NOT NULL,
    WorkDoneStatus				BIT NOT NULL -- 1: Hoàn thành, 0: Không hoàn thành
);
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
	EmployeeID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    EmployeeLastName			NVARCHAR(30) NOT NULL,
    EmployeeFirstName			NVARCHAR(30) NOT NULL,
    EmployeeHireDate			DATETIME DEFAULT NOW(),
    EmployeeStatus				BIT NOT NULL,
    SupervisorID				TINYINT UNSIGNED NOT NULL,
    SocialSecurityNumber		CHAR(5)
);



INSERT INTO Project_Modules (ProjectID	, EmployeeID, ProjectModulesDate, ProjectModulesOn	, ProjectModulesDescription	)
VALUE						(	1		,	1		,	'2019-06-06'	, '2019-06-06'		,	'Làm đúng hạn'			),
							(	2		,	2		,	'2019-08-06'	, '2019-05-06'		,	'Làm trước hạn'			),
                            (	3		,	3		,	'2019-08-06'	, '2019-09-06'		,	'Làm quá hạn'			),
                            (	4		,	1		,	'2019-07-06'	, '2019-06-06'		,	'Làm trước hạn'			);

INSERT INTO Projects		 ( ManagerID , ProjectName 		, ProjectStartDate	, ProjectDescription	, ProjectDetail		, ProjectCompletedOn	)
VALUE						(	1		,'Java'				,	'2019-05-06'	, 'Làm đúng vào'		,'Làm đúng hạn'		,	'2019-08-06'		),
							(	2		,'C#'				,	'2019-07-06'	, 'Làm nhanh lên'		,'Làm trước hạn'	,	'2019-09-06'		),
                            (	3		,'Android'			,	'2019-09-06'	, 'Nộp trước ngày 17/3'	,'Làm quá hạn'		,	'2019-10-06'		),
                            (	1		,'C++'				,	'2019-08-06'	, 'Không biết đừng làm'	,'Làm trước hạn'	,	'2019-11-06'		);

INSERT INTO Work_Done		( EmployeeID, ModuleID	, WorkDoneDate	, WorkDoneDescription	, WorkDoneStatus	)
VALUE						(	1		,	1		,'2019-06-06'	, 'Làm được phết'		,		1			),
							(	2		,	2		,'2019-08-06'	, 'Làm ổn phết'			,		1			),
                            (	3		,	3		,'2019-08-07'	, 'Không biết làm'		,		0			),
                            (	1		,	4		,'2019-07-08'	, 'Không biết ko làm'	,		0			);
INSERT INTO Employee		( EmployeeLastName	, EmployeeFirstName	, EmployeeHireDate	, EmployeeStatus, SupervisorID	, SocialSecurityNumber	)
VALUE						(N'Nguyễn Đình'		,N'Đăng'			,'2019-06-06'		, 		1		,		1		,'SS001'				),
							(N'Lê Thị'			,N'Minh'			,'2019-07-08'		, 		1		,		1		,'SS002'				),
                            (N'Nguyễn Văn'		,N'Thắng'			,'2019-08-07'		, 		1		,		2		,'SS003'				),
                            (N'Dương Văn'		,N'Minh'			,'2019-07-08'		, 		0		,		2		,'SS004'				);
                            
DROP PROCEDURE IF EXISTS sp_Module;
DELIMITER $$
CREATE PROCEDURE sp_Module(IN in_ModuleID TINYINT UNSIGNED)
BEGIN
     
	SELECT 	    *
    FROM		Work_Done	
    WHERE		ModuleID = in_ModuleID 
    GROUP BY	ModuleID;
END$$
DELIMITER ;