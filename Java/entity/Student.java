package com.vti.academy.entity;

public class Student implements IStudent {
	private int id;
	private String name;
	private int group;
	
	public Student(int id, String name, int group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}
	
	public int getGroup() {
		return group;
	}
	
	public void diemDanh() {
		System.out.println(name + "Điểm danh");
	}
	
	public void dangHocBai() {
		System.out.println(name + "đang đi học bài");
	}
	
	public void diDonVeSinh() {
		System.out.println(name +"đi dọn vệ sinh");
	}
	
}
