package com.vti.academy.backend.basic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.academy.entity.Department;

public class DepartmentDao {

	public List<Department> getDepartment() throws ClassNotFoundException, SQLException {
		List<Department> departments = new ArrayList<>();

		String url = "jdbc:mysql://localhost:3306/Test1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connection Success!");

		// Create a statement object
		String sql = "SELECT * FROM Department";

		// Excute Query
		Statement statement = connection.createStatement();

		ResultSet resultset = statement.executeQuery(sql);

		// handling result set
		while (resultset.next()) {
			Department department = new Department();
			department.setId(resultset.getInt("DepartmentId"));
			department.setName(resultset.getString("DepartmentName"));

			departments.add(department);
		}
		return departments;
	}

	public Department getDepartmentByID(int id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Test1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connection Success!");

		// Create a statement object
		String sql = "SELECT * FROM Department WHERE DepartmentId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		// input from scanner
//		int departmentID = 5;

		// set parameter
		statement.setInt(1, id);
		// Excute Query
		ResultSet resultset = statement.executeQuery(sql);

		// handling result set
		if (resultset.next()) {
			Department department = new Department();
			department.setId(resultset.getInt("DepartmentId"));
			department.setName(resultset.getString("DepartmentName"));

			return department;
		} else {
			throw new IOException("Cannot find department which has id = 5");
		}
	}

	public boolean isDepartmentNameExists(String name) throws SQLException, IOException, ClassNotFoundException {

		// get connection
		String url = "jdbc:mysql://localhost:3306/Test1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connection Success!");

		// Create a statement object
		String sql = "SELECT 1 FROM Department WHERE DepartmentName = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, name);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}

	public void createDepartment(String name) throws Exception {
		// get connection
		String url = "jdbc:mysql://localhost:3306/Test1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connection Success!");
		// Create a statement object

		String sql = "	INSERT INTO Department (	DepartmentName	) "
				+ "	VALUE 				   (		?			)";
		PreparedStatement statement = connection.prepareStatement(sql);

		// set parameter
		statement.setString(1, name);

		// Step 4: execute query
		int resultSet = statement.executeUpdate();

		// Handing result set
		System.out.println("Effected Record Amount: " + resultSet);

	}

	public void updateDepartment(int id, String name) throws Exception {
		// get connection
		String url = "jdbc:mysql://localhost:3306/Test1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connection Success!");
		// Create a statement object

		String sql = "	UPDATE Department " + "  SET DepartmentName = ?" + "  WHERE DepartmentId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		// set parameter
		statement.setString(1, name);
		statement.setInt(2, id);

		// Step 4: execute query
		int resultSet = statement.executeUpdate();

		// Handing result set
		System.out.println("Effected Record Amount: " + resultSet);

	}

	public void deleteDepartment(int id) throws Exception {
		// get connection
		String url = "jdbc:mysql://localhost:3306/Test1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connection Success!");
		// Create a statement object
		String sql = "DELETE FROM Department WHERE DepartmentID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		// set parameter
		statement.setInt(1, id);

		// Step 4: execute query
		int resultSet = statement.executeUpdate();

		// Handing result set
		System.out.println("Effected Record Amount: " + resultSet);

	}
}
