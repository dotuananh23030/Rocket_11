package com.vti.academy.entity;

import java.util.Scanner;

public class CanBo {
	protected String ten;
	protected int tuoi;
	protected boolean gioiTinh;
	protected String diaChi;
	private Scanner scanner;
	
	public CanBo() {
	}
	
	public CanBo(String ten, int tuoi, boolean gioiTinh) {
		this.ten = ten;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		scanner = new Scanner(System.in);
	}

	public String getTen() {
		return ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}
	
	public String getDiachi() {
		return diaChi;
	}
	
	public void inputInfo() {
		scanner = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào tên:");
		ten = scanner.nextLine();
		System.out.print("Mời bạn nhập vào tuổi: ");
		tuoi = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Mời bạn nhập vào giới tính (nam/nu): ");
		String gt = scanner.nextLine();
		gioiTinh = gt.equals("nam") ? true : false;
	}
	
	public void getInfor() {
		System.out.println("Tên  :" + ten);
		System.out.println("Tuổi :" + tuoi);
		System.out.println("Giới tính  :" + gioiTinh);
		System.out.println("Địa chỉ  : " + diaChi);
	}
	
	
}
