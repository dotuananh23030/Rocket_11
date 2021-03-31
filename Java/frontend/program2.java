package com.vti.academy.frontend;

import java.util.Scanner;

import com.vti.academy.backend.StudentManagement;

public class program2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentManagement sm = new StudentManagement();
		System.out.println(
				"1.Tạo 10 học sinh, chia thành 3 nhóm\n" + "2.Kêu gọi cả lớp điểm danh.\n3.Gọi nhóm 1 đi học bài"
						+ "\n4.Gọi nhóm 2 đi dọn vệ sinh.\n5.Thoát khỏi chương trình.");
		while (true) {
			System.out.println("mời bạn nhâp số: ");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				sm.initStudents();
				break;
			case 2:
				sm.caLopDiemDanh();
				break;
			case 3:
				sm.nhomDiHocBai();
				break;
			case 4:
				sm.nhomDiDonVeSinh();
				break;
			case 5:
				System.out.println("thoát ra khỏi chương trình");
				return;

			default:
				break;
			}
		}
	}
	
}
