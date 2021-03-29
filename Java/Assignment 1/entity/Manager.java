package com.vti.academy.entity;

public abstract class Manager extends User {
	public Manager(String name , double salaryRatio) {
		super(name , salaryRatio);
	}
	
	public double calculatePay() {
		return salaryRatio * 520;
	}
}
