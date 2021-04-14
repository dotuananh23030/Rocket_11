package com.vti.academy.backend.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ques12 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/Test1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connection Success!");

		// Step 3: Create a statement object
		String sql = "Select * from Position";

		// Step 4: Excute Query
		Statement statement = connection.createStatement();

		ResultSet resultset = statement.executeQuery(sql);

		// Step 5: Xu li ket qua
		while (resultset.next()) {
			System.out.print(resultset.getInt("PositionID") + " ");
			System.out.println(resultset.getString("PositionName"));
		}
	}
}
