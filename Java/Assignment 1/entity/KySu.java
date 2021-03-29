package com.vti.academy.entity;

import java.util.Scanner;

public class KySu extends CanBo {
	private String nghanhDaoTao;
	
	private Scanner scanner;
	
	public KySu() {
		scanner = new Scanner(System.in);
		inputInfo();
	}


	public KySu(String ten, int tuoi, boolean gioiTinh, String nghanhDaoTao) {
		super(ten, tuoi, gioiTinh);
		this.nghanhDaoTao = nghanhDaoTao;
		scanner = new Scanner(System.in);
	}

	public String getNghanhDaoTao() {
		return nghanhDaoTao;
	}
	
	public void inputInfo() {
		super.inputInfo();
		System.out.println("Moi ban nhap vao nganh dao tao: ");
		nghanhDaoTao = scanner.nextLine();
	}
	
	public void getInfor() {
		super.getInfor();
		System.out.println("Nghanh dao tao : " + nghanhDaoTao);
	}
}
