package com.vti.academy.frontend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.academy.backend.basic.DepartmentDao;
import com.vti.academy.entity.Department;
import com.vti.academy.utils.ScannerUtils;

public class CRUSDprogram {
	public static void main(String[] args) throws Exception {
		// Q1. Get departments
		question1();

		// Q3. Get department by id
		question2_3();

		// Q4.Check data exist
		question4();

		// Q5. Create department
		question5();

		// Q6.
		question6();

		// Q7.
		question7();
	}

	private static void question1() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Department> departments = new DepartmentDao().getDepartment();
		for (Department department : departments) {
			System.out.println(department);
		}
	}

	public static void question2_3() throws Exception {
		System.out.println("Input department id: ");
		int id = ScannerUtils.inputId();

		Department department = new DepartmentDao().getDepartmentByID(id);
		System.out.println(department);
	}

	public static void question4() throws Exception {
		System.out.println("Input department Name: ");
		String name = ScannerUtils.inputName();

		boolean result = new DepartmentDao().isDepartmentNameExists(name);
		System.out.println("Result: " + result);
	}

	public static void question5() throws Exception {
		System.out.println("Input department Name: ");
		String name = ScannerUtils.inputName();

		new DepartmentDao().createDepartment(name);
		System.out.println("create success!");
	}

	public static void question6() throws Exception {
		System.out.println("Input department Name: ");
		String name = ScannerUtils.inputName();

		System.out.println("Input department id: ");
		int id = ScannerUtils.inputId();

		new DepartmentDao().updateDepartment(id, name);
		System.out.println("create success!");
	}

	public static void question7() throws Exception {
		System.out.println("Input department id: ");
		int id = ScannerUtils.inputId();

		new DepartmentDao().deleteDepartment(id);
		System.out.println("delete success!");
	}

}
