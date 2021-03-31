package com.vti.academy.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.academy.entity.KhoiA;
import com.vti.academy.entity.KhoiB;
import com.vti.academy.entity.KhoiC;
import com.vti.academy.entity.Thisinh;

public class Tuyensinh implements ITuyenSinh {
	private Scanner scanner;
	private ArrayList<Thisinh> thisinhs;
	
	public Tuyensinh() {
		super();
		thisinhs= new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	
	public void themThisinh() {
		System.out.println("bạn muốn thêm khối nào: (1.khối A) (2. Khối B) (3.Khối C)");
		int choose = scanner.nextInt();
		scanner.nextLine();
		switch (choose) {
		case 1:
			KhoiA thisinh1 = new KhoiA();
			thisinh1.inputThisinh();
			thisinh1.inputThisinhkhoiA();
			thisinhs.add(thisinh1);
			System.out.println("thêm thành công");
			break;
		case 2:
			KhoiB thisinh2 = new KhoiB();
			thisinh2.inputThisinh();
			thisinh2.inputThisinhkhoiB();
			thisinhs.add(thisinh2);
			System.out.println("thêm thành công");
			break;
		case 3:
			KhoiC thisinh3 = new KhoiC();
			thisinh3.inputThisinh();
			thisinh3.inputThisinhkhoiC();
			thisinhs.add(thisinh3);
			System.out.println("thêm thành công");
			break;

		default:
			break;
		}
	}
	
	public void hienThiSinh() {
		for (Thisinh thisinh : thisinhs) {
			System.out.println(thisinh);
		}
	}
	
	public void timsobaodanh() {

		System.out.println("Nhập sbd cần tìm: ");
		String sbd = scanner.nextLine();

		for (Thisinh thisinh : thisinhs) {
			if (thisinh.getSbd().equals(sbd)) {
				System.out.println(thisinh);
			}
		}
	}
}
