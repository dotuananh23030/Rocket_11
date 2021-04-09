package com.vti.academy.backend;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.vti.academy.Utils.ScannerUtils;
import com.vti.academy.entity.Student;



public class Set {
Set<Student> students;
	
	public Question3() {
		students = new HashSet<Student>();
	}
	
	public void inputStudent() {
		System.out.println("Nhập vào số Student bạn muốn thêm");
		int n = ScannerUtils.inputSoDuong("Số student phải là 1 số dương");
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập student thứ: " + (i+1));
			students.add(new Student());
		}
	}
	
	public void printSudent() {
		for (Student student : students) {
			System.out.println(student);
		}
	}
	public void inRaTongSoPhanTu(){
		System.out.println("Tổng số phần tử của students là: " + students.size() );
	}
	
	public void getIndex4ofStudent() {
		Iterator<Student> iterator = students.iterator();
		for (int i = 0; i < 3; i++) {
			iterator.next();
		}
		System.out.println("Phần tử thứ 4");
		System.out.println(iterator.next());
	}
	
	public void printFirst() {
		System.out.println("First Student " + students.iterator().next());
	}
	public void printLast() {
		Iterator< Student> iterator = students.iterator();
		for (int i = 0; i < students.size()-1; i++) {
			iterator.next();
		}
		System.out.println(iterator.next());
	}
}
