-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table: Department
DROP TABLE IF EXISTS DonHang;
CREATE TABLE DonHang(
	DonHangID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DonHangName 			NVARCHAR(30) NOT NULL UNIQUE KEY,
	Soluong				INT NOT NULL,
    author_id				TINYINT UNSIGNED,
    CreateDate				DATETIME DEFAULT NOW(),
    ModifiedDate			DATETIME DEFAULT NOW() 
);

-- create table: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY, 
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    `password` 				VARCHAR(800) NOT NULL,
    FirstName				NVARCHAR(50) NOT NULL,
    LastName				NVARCHAR(50) NOT NULL,	
    DonHangID 			TINYINT UNSIGNED,	
    CreateDate				DATETIME DEFAULT NOW(),
    `Role` 					ENUM('Admin','User','Manager') NOT NULL DEFAULT 'User',
    FOREIGN KEY(DonHangID) REFERENCES DonHang(DonHangID) ON DELETE SET NULL
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data DonHang
INSERT INTO DonHang	(DonHangName, author_id	,	Soluong		,CreateDate	 ,	ModifiedDate)
VALUES              (N'quạt'	,	5		,		5	  	,'2020-03-05' 	 ,	'2020-03-05'),
					(N'quạt1'	,	1		,		5	  	,'2020-03-07' 	 ,	'2020-03-07'),
					(N'quạt2'		,	2		,		5	  	,'2020-03-08' 	 ,	'2020-03-08'),
					(N'quạt3'	,	3		,		5	 	,'2020-03-10' 	 ,	'2020-03-10'),
					(N'quạt4'	,	4		,		6		,NOW()		 ,	NOW()		),
					(N'quạt5'	,	6		,		6		,NOW()		 ,	NOW()		),
					(N'quạt6'	,	7		,		6		,'2020-04-07' ,	'2020-04-07'),
					(N'quạt7'	,	8		,		6		,'2020-04-07' ,	'2020-04-07'),
					(N'quạt8'	,	9		,		6		,'2020-04-09' ,	'2020-04-09'),
					(N'quạt9'	,	5		,		6		,'2020-04-09' ,	'2020-04-09'),
					(N'quạt10',	5		,		6		,'2020-04-09' ,	'2020-04-09');

-- Add data Account
-- password: 123456
INSERT INTO `Account`(Email								, Username			,	`password`,															FirstName,		LastName,				DonHangID	,	CreateDate		,	`Role`		)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Dang'	,		'Nguyen Hai'	,   '1'			,	'2020-03-05'	,	'Admin'		),
					('account1@gmail.com'				, 'quanganh'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Anh'	,		'Tong Quang'	,   '1'			,	'2020-03-05'	,	'Admin'		),
                    ('account2@gmail.com'				, 'vanchien'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Chien',		'Nguyen Van'	,   '2'			,	'2020-03-07'	,	'User'		),
                    ('account3@gmail.com'				, 'cocoduongqua'	,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Do'	,		'Duong'			,   '3'			,	'2020-03-08'	,	'User'		),
                    ('account4@gmail.com'				, 'doccocaubai'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Thang',		'Nguyen Chien'  ,   '4'			,	'2020-03-10'	,	'User'		),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Kha'	,		'Ngo Ba'		,   '1'			,	NOW()			,	'Admin'		),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Huan'	,		'Bui Xuan'		,   '7'			,	NOW()			,	'Admin'		),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Tung'	,		'Nguyen Thanh'	,   '8'			,	'2020-04-07'	,	'Manager'	),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Huu'	,		'Duong Van'		,   '9'			,	'2020-04-07'	,	'Manager'	),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Ai'	,		'Vi Ti'			,   '10'		,	'2020-04-09'	,	'Manager'	);

ALTER TABLE DonHang
ADD FOREIGN KEY (author_id) REFERENCES `Account`(AccountID);

