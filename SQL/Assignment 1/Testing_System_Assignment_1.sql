
DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;
CREATE TABLE Department(
      DepartmentID   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
      DepartmentName VARCHAR(50) NOT NULL UNIQUE KEY
);
INSERT INTO Department( DepartmentName)
VALUES                ('Marketing'),
					  ('kinhdoanh'),
                      ('ketoan'),
                      ('sale'),
                      ('nhansu');

CREATE TABLE Position (
    PositionID   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    PositionName VARCHAR(50) NOT NULL UNIQUE KEY
);
INSERT INTO Position ( PositionName )
VALUES              ('Giam doc'),
                    ('pho giam doc'),
                    ('truong phong'),
                    ('pho ohong'),
                    ('nhan vien');

CREATE TABLE `Account` (
    AccountID    TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Email        VARCHAR(50) NOT NULL UNIQUE KEY,
    Username     VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName     VARCHAR(50) NOT NULL ,
    DepartmentID TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    PositionID   TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate   DATETIME DEFAULT NOW(),
    FOREIGN KEY  (DepartmentID) REFERENCES Department(departmentID),
    FOREIGN KEY  (PositionID)   REFERENCES Position (positionID)
);
INSERT INTO `Account` ( Email,               Username,       FullName,           DepartmentID,       PositionID,       CreateDate) 
VALUES                ('abc@gmail.com',      'abc',         'Dotuananh',         2,                  1,                '2020-05-28'),
					  ('cde@gmail.com',      'cde',         'Lykimquynh',        3,                  3,                '2020-06-20'),
                      ('fgh@gmail.com',      'fgh',         'NguyenVanNam',      1,                  2,                '2020-07-28'),
					  ('hik@gmail.com',      'hik',         'NguyenThiQuynh',    5,                  5,                '2020-09-23'),
			          ('mno@gmail.com',      'mno',         'NguyenVantrung',    4,                  4,                '2020-07-28');


CREATE TABLE `group` (
    GroupID   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    GroupName VARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate DATETIME DEFAULT NOW()
);
INSERT INTO `group` (GroupName,           CreatorID,           CreateDate) 
VALUES              ('Phongnhansu',       1,                 '2020-12-27'),
				    ('PhongMarketing',    2,                 '2020-11-28'),
					('Phongtaichinh',     3,                 '2020-10-15'),
					('Phongkinhdoanh',    4,                 '2020-02-28'),
					('Phongsale',         5,                 '2020-09-17');

DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount (
    GroupID   TINYINT UNSIGNED  UNIQUE KEY,
    AccountID TINYINT UNSIGNED  UNIQUE KEY,
    JoinDate  DATETIME DEFAULT NOW(),
    PRIMARY KEY ( GroupID,AccountID)
);

DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion(
      TypeID   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
      TypeName VARCHAR(50) NOT NULL UNIQUE KEY
);
INSERT INTO TypeQuestion ( TypeName )
VALUES                   ('Essay'),
                         ('Multiple-Choice'),
						 ('Hard'),
                         ('extreme'),
                         ('easy')

DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
      CategoryID   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
      CategoryName VARCHAR(50) NOT NULL UNIQUE KEY
);
INSERT INTO CategoryQuestion ( CategoryName )
VALUES                       ('Java'),
                             ('.NET'),
							 ('SQL'),
							 ('Postman'),
							 ('Ruby');

DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
    QuestionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					VARCHAR(100) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    TypeID					TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(TypeID) 		REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY(CreatorID) 		REFERENCES `Account`(AccountId)
);
INSERT INTO Question  ( Content,                   CategoryID,         TypeID,           CreatorID,          CreateDate) 
VALUES                ('Java la gi',               2,                  1,                4,                 '2020-04-28'),
					  ('.NET de lam gi',           3,                  3,                1,                 '2020-05-20'),
                      ('c su dung phan mem gi',    1,                  2,                2,                 '2020-09-28'),
					  ('c++ la gi',                5,                  5,                3,                 '2020-10-23'),
			          ('php tac dung la gi',       4,                  4,                5,                 '2020-11-28');

CREATE TABLE Answer (
    AnswerID   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Content    VARCHAR(100) NOT NULL ,
	QuestionID TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    isCorrect  BIT DEFAULT 1,
    FOREIGN KEY(QuestionID) 	REFERENCES Question(QuestionID)
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
    ExamID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`					CHAR(10) NOT NULL,
    Title					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    Duration				TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId)
);

DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
    ExamID				TINYINT UNSIGNED NOT NULL,
	QuestionID			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID),
    FOREIGN KEY(ExamID) REFERENCES Exam(ExamID),
    PRIMARY KEY (ExamID,QuestionID)
);
