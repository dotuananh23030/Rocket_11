package com.vti.academy.backend;

import com.vti.academy.entity.MyMath;

public class program  {
	private Student[] students;

	public void question1() throws Exception {
		students = new Student[3];
		students[0] = new Student(1,"Nguyễn Văn A");
		students[1] = new Student(2,"Nguyễn Văn B");
		students[2] = new Student(3,"Nguyễn Văn C");

		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	public void question2() {
		System.out.println("Số tiền của nhóm trước khi tiêu: ");
		System.out.println(Student.getMoneyGroup());
		
		students[0].spend(50);
		System.out.println("Số tiền sau khi student 1 tiêu: ");
		System.out.println(Student.getMoneyGroup());
		
		students[1].spend(20);
		System.out.println("Số tiền sau khi student 2 tiêu: ");
		System.out.println(Student.getMoneyGroup());
		
		students[2].spend(150);
		System.out.println("Số tiền sau khi student 3 tiêu: ");
		System.out.println(Student.getMoneyGroup());
		
		for(Student student : students) {
			student.fund();
		}
		System.out.println("Số tiền sau khi đóng quỹ: ");
		System.out.println(Student.getMoneyGroup());
		
	}
	
	public void question3() {
		System.out.println(MyMath.max(6, 9));
		System.out.println(MyMath.min(6, 9));
		System.out.println(MyMath.sum(6, 9));
	}
	
	public void question4() {
		Student.changecollege("Đại hoc Kinh tế Quốc dân");
		System.out.println("Sau khi gọi method changeCollege: ");
		
		for(Student student : students) {
			System.out.println(student.getCollege());
		}
	}
	
	public void question5() {
		System.out.println("Số sinh viên được tạo: ");
		System.out.println(Student.counter);
	}
	
	public void question6() throws Exception {
		Student student1 = new PrimaryStudent("Nguyễn Văn A");
		Student student2 = new PrimaryStudent("Nguyễn Văn B");
		Student student3 = new SecondaryStudent("Nguyễn Văn C");
		Student student4 = new SecondaryStudent("Nguyễn Văn D");
		Student student5 = new SecondaryStudent("Nguyễn Văn E");
		Student student6 = new SecondaryStudent("Nguyễn Văn F");
	}
	
}
