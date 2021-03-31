package com.vti.academy.entity;

import java.util.Scanner;

public class KhoiB extends Thisinh {
	private String ten;
	private String monThi;
	private Scanner scanner;
	
	public KhoiB() {
		super();
		ten = "B";
		monThi = "Toán, Hoá, Sinh";
	}
	
	public void inputThisinhkhoiB() {
		super.inputThisinh();
		System.out.print("nhập tên: ");
		ten = scanner.nextLine();
	}
}
