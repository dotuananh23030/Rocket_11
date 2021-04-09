package com.vti.academy.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.vti.academy.Utils.ScannerUtils;
import com.vti.academy.entity.Student;

public class List {
	private ArrayList<Student> students;
	private Scanner scanner;

	public void List() {
		scanner = new Scanner(System.in);
		students = new ArrayList<>();		
	}

	private void inputStudent() {
		students.add(new Student("Đạt"));
		students.add(new Student("Quang"));
		students.add(new Student("Minh"));
		students.add(new Student("Dũng"));
		students.add(new Student("Mạnh"));
		students.add(new Student("Bình"));
	}
	
	private void printSudent() {
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	public void getAmountOfStudent() {
		System.out.println("Student Amount :" + students.size());
	}
	
	public void getIndex4OfStudent() {
		System.out.println("Student thứ 4: " + students.get(3));
	}
	
	public void printFirstAndLastStudent() {
		System.out.println("First Student: " + students.get(0));
		System.out.println("Last Student: " + students.get(5));
	}
	
	public void addStudentIntoFirstStudents() {
		students.add(0, new Student("Nam"));
		System.out.println("Danh sách thí sinh sau khi thêm: ");
		inputStudent();
	}
	
	public void addStudentIntoLastStudent() {
		students.add(students.size(), new Student("Quý"));
		System.out.println("List Students after adding: ");
		inputStudent();
	}
	
	public void reverseStudents() {
		Collections.reverse(students);
		System.out.println("Danh sách sau khi đảo ngược: ");
		inputStudent();
	}
	
	public void findStudentById() {
		System.out.println("Nhập id cần tìm :");
		int id = ScannerUtils.inputIntWithString(scanner);
		
		for (Student student : students) {
			if(student.getId() == id) {
				System.out.println(student);
			}
		}
	}
	
	public void findStudentByName() {
		System.out.println("Nhập tên cần tìm :");
		String name = ScannerUtils.inputStringWithString(scanner);
		
		for (Student student : students) {
			if(Student.getName().equals(name)) {
				System.out.println(student);
			}
		}
	}
	
	public void findDuplicateStudent() {
		for (int i = 0; i < students.size(); i++) {
			for (int j = i + 1; j <students.size(); j++) {
			if(students.get(i).getName().equals(students.get(j).getName())){
					System.out.println("Các student trùng tên :");
					System.out.println(students.get(i));
					System.out.println(students.get(j));
				}
			}
		}
	}
	
	public void deleteStudentId5() {
		for (Student student : students) {
			if(student.getId() == 5) {
				students.remove(student);
			}
		}
	}
	
	public void addAllStudentsToStudentCopies() {
		 ArrayList<Student> studentcopies = new ArrayList<Student>();
		 studentcopies.addAll(students);
	}
	
	
}
