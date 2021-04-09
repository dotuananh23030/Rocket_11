package com.vti.academy.entity;

import java.util.Arrays;

public class Employee<T> {
	private int id;
	private String name;
	private T[] salaries;
	
	public Employee (int id,String name,T[] salaries) {
		this.id = id;
		this.name = name;
		this.salaries = salaries;
	}
	
	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", salaries=" + Arrays.toString(salaries) + '}';
	}
	
	public void setSalaries(T[] salaries) {
		this.salaries = salaries;
	}
}
