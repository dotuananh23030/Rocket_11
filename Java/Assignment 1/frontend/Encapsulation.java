package com.vti.academy.frontend;

import java.util.Scanner;

public class Encapsulation {
	//Qs1:
	private int id;
	private String name;
	private String hometown;
	private float score;
	
	public Student (int id, String name, String hometown, float score) {
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.score = 0;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public int getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	public void plusScore(float score) {
		this.score += score;
	}

	public String toString() {
		String level;
		if (score > 8.0) {
			level = "Giỏi";
		} else if (score>6 && score < 8) {
			level = "Khá";
		} else if (score < 6 && score >4) {
			level = "Trung bình";
		} else {
			level = "Yếu";
		}

		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", hometown='" + hometown + '\'' + ", score="
				+ score + ", xepLoai='" + level + '\'' + '}';
	}

	
}
