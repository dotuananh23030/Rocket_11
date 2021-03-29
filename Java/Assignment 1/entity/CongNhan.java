package com.vti.academy.entity;

import java.util.Scanner;

public class CongNhan extends CanBo {
	private int bac;
	
	private Scanner scanner;
	
	public CongNhan() {
		scanner = new Scanner(System.in);
		inputInfo();
	}

	public CongNhan(String ten, int tuoi, boolean gioiTinh, byte bac) {
		super(ten, tuoi, gioiTinh);
		this.bac = bac;
		scanner = new Scanner(System.in);
	}
	

	public int getBac() {
		return bac;
	}
	
	public void inputInfo() {
		super.inputInfo();
		System.out.println("Moi ban nhap vao bac: ");
		bac = scanner.nextInt();
	}
	
	public void getInfo() {
		super.getInfor();
		System.out.println("Bậc : " + bac);
	}
}
