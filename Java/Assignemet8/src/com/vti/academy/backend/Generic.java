package com.vti.academy.backend;

import com.vti.academy.entity.Employee;
import com.vti.academy.entity.MyMap;
import com.vti.academy.entity.Phone;
import com.vti.academy.entity.Staff;
import com.vti.academy.entity.Student;

public class Generic {
	public void print() {
		Student<Integer> student1 = new Student<Integer>(1, "DDD");
		print(student1);
		Student<Float> student2 = new Student<Float>(2.3f, "BBB");
		print(student2);
		Student<Double> student3 = new Student<Double>(3.5, "eee");
		print(student3);
		print(4);
		print(4.0f);
		print("AAA");
	}
	
	private <T> void print(T a) {
		System.out.println(a);
	}
	
	public void ques4() {
		Integer[] i= {5,  10 , 15};
		Float[] f = {6f, 5f, 15f};
		Double[] d = {5.2, 2.6 ,6.9};
		
		private <E> void printArr(E[] e) {
			for(int i = 0; i < e.length;i++ ) {
				System.out.println(e[i] + " ");
			}
		}
		
		public void print() {
			printArr(i);
			printArr(f);
			printArr(d);
		}
	}	
	
		public void ques5() {
			Integer[] salaryEmployee1 = {1000,1200,1250};
			Employee<Integer> employee1 = new Employee<Integer>(1,"Đăng", salaryEmployee1);
			Float[] salaryEmployee2 = {1000.5f,1200.3f,1250.7f};
			Employee<Float> employee2 = new Employee<Float>(2,"Nam", salaryEmployee2);
			Double[] salaryEmployee3 = {1000.55,1200.66,1250.77};
			Employee<Double> employee3 = new Employee<Double>(3,"Minh", salaryEmployee3);
			
			System.out.println("Employee vừa khởi tạo: ");
			System.out.println("Tháng lương cuối cùng của employee 1: " + salaryEmployee1[salaryEmployee1.length - 1]);
			System.out.println("Employee vừa khởi tạo: ");
			System.out.println("Tháng lương cuối cùng của employee 2: " + salaryEmployee1[salaryEmployee2.length - 1]);
			System.out.println("Employee vừa khởi tạo: ");
			System.out.println("Tháng lương cuối cùng của employee 3: " + salaryEmployee1[salaryEmployee3.length - 1]);
		}

		public void ques6() {
			MyMap<Integer,String> student = new MyMap<Integer, String>(1, "AAA");
			System.out.println("MSV: " + student.getKey());
			System.out.println("Name: " + student.getValue());
		}
		
		public void ques7() {
			Phone <String,String> email = new Phone<String, String>("abc@gmail.com","0983849211");
			System.out.println("Email: " + email.getKey() + "/" + "Phone Number: " + email.getPhoneNumber());
			Phone <Integer,String> id = new Phone<Integer, String>(1,"0983876511");
			System.out.println("id: " + id.getKey() + "/" + "Phone Number: " + id.getPhoneNumber());
			Phone <String,String> name = new Phone<String, String>("Nam","0765849211");
			System.out.println("name: " + name.getKey() + "/" + "Phone Number: " + name.getPhoneNumber());
			
		}
		
		public void ques8() {
			Staff<Integer> staff = new Staff<Integer> (1,"DD");
			System.out.println(" Id: " + staff.getID() + " Name: " + staff.getName());
			Staff<Long> staff1 = new Staff<Long>((long)2, "EE");
			System.out.println(" Id: " + staff.getID() + "Name: " + staff.getName());
		}
}
