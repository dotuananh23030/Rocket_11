package com.vti.academy.backend;

public class Student {
	private int id;
	private String name;
	private static String college;
	private static int moneyGroup = 0;
	public static int counter = 0;
	public static final int maxStudent = 7;
	
	public Student(String name) {
		this.id = id;
		this.name = name;
		Student.college = "Đại học công nghệ";
		moneyGroup += 100;
	}
	
	public  Student(String name) throws Exception {
		
		if (counter > maxStudent) {
			throw new Exception("Không thể tạo quá 7 sinh viên");
		}
		this.id = ++counter;
		this.name = name;
	}
	
	public static String getCollege() {
		return college;
	}
	
	public static int getMoneyGroup() {
		return moneyGroup;
	}
	
	public static void spend(int money) {
		Student.moneyGroup -= money;
	}

	public void fund() {
		moneyGroup += 50;
	}
	
	public static void changecollege(String college) {
		Student.college = college;
	
	}
	
	
}
