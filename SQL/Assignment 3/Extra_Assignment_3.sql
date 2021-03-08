-- Question 1
CREATE VIEW ProductSubcategoryID_Saddles AS
SELECT `Name`
FROM Product
WHERE ProductSubcategoryID IN 
            (SELECT ProductSubcategoryID
             FROM ProductSubcategory
             WHERE `Name` = 'Saddles');

SELECT 	* 
FROM ProductSubcategoryID_Saddles


CREATE VIEW MIN_StandardCost AS
SELECT 	`Name`
FROM 	Product
WHERE	StandardCost IN 
          (SELECT  MIN(StandardCost)
	       FROM    Product
	       WHERE   ProductSubcategoryID = 3);

SELECT * FROM MIN_StandardCost
-- Exercise 2

SELECT CR.`Name`,SP.`Name`
FROM Countryregion CR
JOIN Stateprovince SP ON SP.CountryregionCode = CR.CountryregionCode

SELECT CR.`Name`,SP.`Name`
FROM Countryregion CR
JOIN Stateprovince SP ON SP.CountryregionCode = CR.CountryregionCode
WHERE CR.`Name` = 'Canada' 
OR CR.`Name` = 'Germany';

SELECT 	SDH.SalesOrderID, SDH.OrderDate, SP.SalesPersonID, SP.Bonus, SP.SalesYTD
FROM	salesperson SP 
JOIN salesorderheader SDH
ON	SP.SalesPersonID = SDH.SalesPersonID;

SELECT 		SDH.SalesOrderID, SDH.OrderDate, E.Title, SP.Bonus, SP.SalesYTD
FROM		salesperson SP 
JOIN salesorderheader SDH
ON			SP.SalesPersonID = SDH.SalesPersonID
JOIN	     employee E 
ON			SP.SalesPersonID = E.EmployeeID;