package com.vti.academy.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.vti.academy.entity.Student;

public class Comparing {
private List<Student> students;
	
	public void Question1_2() {
		students = new ArrayList<Student>();
	}
	public void addStudent() {
		students.add(new Student("AAA", LocalDate.parse("2020-02-02"), 8));
		students.add(new Student("AAA", LocalDate.parse("2020-02-02"), 6));
		students.add(new Student("DDD", LocalDate.parse("2020-03-03"), 9));
		students.add(new Student("FFF", LocalDate.parse("2020-04-04"), 3));
		students.add(new Student("BBB", LocalDate.parse("2020-05-05"), 5));
	}
	public void printStudent() {
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	public void printStudentSortName() {
		Collections.sort(students);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	public void sortStudent() {
		Collections.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if (o1.getName().compareTo(o2.getName())>0) {
					return 1;
				}
				else if (o1.getName().compareToIgnoreCase(o2.getName())<0) {
					return -1;
				}
				else {
					if (o1.getBirthDay().compareTo(o2.getBirthDay())>0) {
						return 1;
					}
					else if (o1.getBirthDay().compareTo(o2.getBirthDay())<0) {
						return -1;
					}
					else {
						if (o1.getScore()>o2.getScore()) {
							return -1;
						}
						else if (o1.getScore()<o2.getScore()) {
							return 1;
						}
						return 0;
					}
				}
				
			}
		});
	}
}