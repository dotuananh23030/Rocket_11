package com.vti.academy.entity;

public abstract class Student extends Person {
		private int id;
		
		public Student(String name, int id) {
			super(name);
			this.id = id;
			
		}
		
		public int getID() {
			return id;
		}
		
		public void setID(int id) {
			this.id = id;
		}

}
