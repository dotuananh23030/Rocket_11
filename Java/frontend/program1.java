package com.vti.academy.frontend;

import java.util.Scanner;

import com.vti.academy.backend.Tuyensinh;

public class program1 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	Tuyensinh tuyenSinh = new Tuyensinh();
	System.out.println("1. Thêm mới thí sinh\n" + "2. Hiện thông tin thí sinh\n3. Tìm kiếm theo số báo danh."
			+ "\n4.Thoát khỏi chương trình.");
	while(true) {
		System.out.println("Mới bạn nhập số: ");
		int choose = scanner.nextInt();
		switch(choose) {
		case 1:
			tuyenSinh.themThisinh();
			break;

		case 2:
			tuyenSinh.hienThiSinh();
			break;

		case 3:
			tuyenSinh.timsobaodanh();
			break;
			
		case 4:
			System.out.println("thoát ra khỏi chương trình");
			return;
			
		default:
			break;
		}
		
	 } 
  }
}
