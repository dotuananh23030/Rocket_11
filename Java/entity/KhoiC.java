package com.vti.academy.entity;

import java.util.Scanner;

public class KhoiC extends Thisinh {
	private String ten;
	private String monThi;
	private Scanner scanner;
	
	public KhoiC() {
		super();
		ten = "C";
		monThi = "Văn, Sử, Địa";
	}
	
	public void inputThisinhkhoiC() {
		super.inputThisinh();
		System.out.print("nhập tên: ");
		ten = scanner.nextLine();
	}
}
