package com.vti.academy.entity;

public class Student {
	private int id;
	private String name;
	public static int count = 0;

	public static void main(String[] args) {
		Student student1 = new Student("Nguyen Van Nam");
		System.out.println(student1.getId());
		// System.out.println(student1.getIdNew());
	}

	public Student(String name) {
		count++;
		this.id = count;
		this.name = name;
	}

	/**
	 * @deprecated replace by {@link #getIdNew()}
	 */
	public int getId() {
		return this.id;
	}

	public String getIdNew() {
		String result = "MSSV: " + this.id;
		return result;
	}


	
}
