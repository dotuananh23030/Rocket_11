package com.vti.academy.entity;

public class Student {
	private final int id ;
	private String name;
	
	public Student(int id,String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	} 
	
	@Override
	public String toString() {
		return "Student{" + "name='" + getID() + '\'' + "name='" + name + '\'' + '}';
	}
	
	public static void study() {
		System.out.println("Dang hoc bai...");
	}

}
