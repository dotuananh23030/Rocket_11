package com.vti.academy.entity;

public abstract class Waiter extends User {
		public Waiter(String name , double salaryRatio) {
			super(name , salaryRatio);
		}
		
		public double calculatePay() {
			return salaryRatio * 220;
		}
}
