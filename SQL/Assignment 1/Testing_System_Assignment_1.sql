
DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;
CREATE TABLE Department(
      DepartmentID   TINYINT,
      DepartmentName VARCHAR(50)
);

CREATE TABLE Position (
    PositionID   INT,
    PositionName VARCHAR(50)
);

CREATE TABLE Account (
    AccountID    TINYINT UNSIGNED PRIMARY KEY,
    PositionName varchar(50) NOT NULL,
    Username     varchar(50) NOT NULL,
    FullName     VARCHAR(50) NOT NULL,
    DepartmentID TINYINT,
    PositionID   TINYINT,
    CreateDate   DATE
);


