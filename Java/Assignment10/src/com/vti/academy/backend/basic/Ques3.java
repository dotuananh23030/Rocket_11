package com.vti.academy.backend.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ques3 {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	String url = "jdbc:mysql://localhost:3306/Test1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
	String username = "root";
	String password = "root";

	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection connection = DriverManager.getConnection(url, username, password);

	System.out.println("Connection Success!");
	// Create a statement object

	String sql = "	INSERT INTO `Position` (	PositionName	) "
			  + "	VALUE 				   (		?			)";
	PreparedStatement statement = connection.prepareStatement(sql);

	//input from scanner
	String PositionName = "Senior";
	// set parameter
	statement.setString(1, PositionName);

	// Execute SQL Query with executeUpdate
	int effectedRecordAmount = statement.executeUpdate();

	// Handing result set
	System.out.println("Effected Record Amount: " + effectedRecordAmount );
	
	//Step 6: Close connection
	connection.close();
}
}
