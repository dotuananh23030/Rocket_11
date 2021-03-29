package com.vti.academy.entity;

public abstract class Employee extends User{
	public Employee(String name , double salaryRatio) {
		super(name , salaryRatio);
	}
	
	public double calculatePay() {
		return salaryRatio * 220;
	}
}
