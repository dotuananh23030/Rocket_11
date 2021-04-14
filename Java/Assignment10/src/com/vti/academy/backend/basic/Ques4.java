package com.vti.academy.backend.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ques4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/Test1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connection Success!");
		// Create a statement object

		String sql = "	UPDATE `Position` " 
				   + "	SET PositionName = ?" 
				   + " WHERE PositionID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		// input from scanner
		int positionID = 5;
		String positionName = "Junior";

		// set parameter
		statement.setString(1, positionName);
		statement.setInt(2, positionID);
		
		// Execute SQL Query with executeUpdate
		int effectedRecordAmount = statement.executeUpdate();

		// Handing result set
		System.out.println("Effected Record Amount: " + effectedRecordAmount);

		// Step 6: Close connection
		connection.close();
	}
}
