package com.vti.academy.frontend.encapsulation.ex2;

public class Account {
	private int string;
	private String name;
	private int balance;
	
	public Account(int string, String name ,int balance) {
		this.string = string;
		this.name = name;
		this.balance=  balance;
	}
	
	public int getString() {
		return string;
	}
	
	 public String getName() {
		 return name;
	 }
	 
	 public int getBalance() {
		 return balance;
	 }
	 
	 
}
