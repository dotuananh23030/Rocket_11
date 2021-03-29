package com.vti.academy.entity;

public class HighSchoolStudent extends Student {
		
		private int id;
		private String clazz;
		private String desiredUniversity;
		
		public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
			super(name, id);
			this.clazz = clazz;;
			this.desiredUniversity = desiredUniversity;
		}
		public int getID() {
			return id;
		}
		
		public String toString() {

			return "HighSchoolStudent{" + "id='" + super.getID() + '\'' + "name='" + super.getName() + '\'' + "clazz='"
					+ clazz + '\'' + ", desiredUniversity='" + desiredUniversity + '\'' + '}';
		}
}
