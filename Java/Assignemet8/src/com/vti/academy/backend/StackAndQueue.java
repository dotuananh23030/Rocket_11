package com.vti.academy.backend;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.vti.academy.entity.Student;

public class StackAndQueue {
	public void cauA() {
		Stack<Student> students = new Stack<>();
		students.push(new Student("Nguyễn Văn A"));
		students.push(new Student("Trần Văn Nam"));
		students.push(new Student("Nguyễn Văn Huyên"));
		students.push(new Student("Nguyễn Văn Nam"));

		System.out.println(students.pop());
		System.out.println(students.pop());
		System.out.println(students.pop());
		System.out.println(students.pop());
	}

	public void cauB() {

		Queue<Student> students = new LinkedList<>();
		students.add(new Student("Nguyễn Văn A"));
		students.add(new Student("Trần Văn Nam"));
		students.add(new Student("Nguyễn Văn Huyên"));
		students.add(new Student("Nguyễn Văn Nam"));

		System.out.println(students.poll());
		System.out.println(students.poll());
		System.out.println(students.poll());
		System.out.println(students.poll());

	}
}
