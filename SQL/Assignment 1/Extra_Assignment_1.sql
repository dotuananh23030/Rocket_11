DROP DATABASE IF EXISTS Fresher_management;
CREATE DATABASE Fresher_management;
USE Fresher_management;

DROP TABLE IF EXISTS Trainee;
CREATE TABLE  Trainee(
	 TraineeID        TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
     Full_Name        NVARCHAR(50) NOT NULL ,
     Birth_Date       DATETIME DEFAULT NOW(),
     Gender           ENUM('male','female','unknown') NOT NULL,
     ET_IQ            TINYINT UNSIGNED CHECK(ET_IQ<=20) NOT NULL,
     ET_Gmath         TINYINT UNSIGNED CHECK(ET_Gmath<=20) NOT NULL,
     ET_English		  TINYINT UNSIGNED CHECK(ET_English<=20) NOT NULL,
     Trainning_Class  CHAR(6) NOT NULL,
     Evaluation_Notes NVARCHAR(50) NOT NULL

);

ALTER TABLE Trainee ADD COLUMN VTI_Account VARCHAR(30) NOT NULL UNIQUE;

DROP TABLE IF EXISTS Ques2;
CREATE TABLE Ques2(
     ID            TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
     `Name`        NVARCHAR(50) NOT NULL,
     `Code`        CHAR(5) NOT NULL,
     ModifiedDate  DATETIME DEFAULT NOW()
);

DROP TABLE IF EXISTS Ques3;
CREATE TABLE Ques3(
     ID             TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
     BirthDate      DATETIME DEFAULT NOW(),
     Gender			ENUM('0','1','2'), -- 0: Male, 1: Female, 2:Unknown
     IsDeletedFlag  ENUM('0','1') -- 0: Active,	1: Deleted
);