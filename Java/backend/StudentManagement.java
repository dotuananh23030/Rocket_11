package com.vti.academy.backend;

import com.vti.academy.entity.Student;

public class StudentManagement {
	private Student[] students;
	
	public StudentManagement() {
		students = new Student[10];
	}

	public void initStudents() {
		students[1] = new Student(1, "Nam", 1);
		students[2] = new Student(2, "Minh Anh", 2);
		students[3] = new Student(3, "Đăng", 1);
		students[4] = new Student(4, "Minh", 3);
		students[5] = new Student(5, "Tuấn", 1);
		students[6] = new Student(6, "Hưng", 3);
		students[7] = new Student(7, "Bình", 2);
		students[8] = new Student(8, "Thương", 2);
		students[9] = new Student(9, "Phượng", 1);
		students[10] = new Student(10, "Ninh", 3);
	}

	public void caLopDiemDanh() {
		for (int i = 1; i <= 10; i++) {
			students[i].diemDanh();
		}
	}

	public void nhomDiHocBai() {
		for (int i = 1; i <= 10; i++) {
			if (students[i].getGroup() == 1) {
				students[i].dangHocBai();
			}
		}
	}

	public void nhomDiDonVeSinh() {
		for (int i = 1; i <= 10; i++) {
			if (students[i].getGroup() == 2) {
				students[i].diDonVeSinh();
			}
		}
	}
	
}
