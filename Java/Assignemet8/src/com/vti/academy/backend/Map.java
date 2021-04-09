package com.vti.academy.backend;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class Map {
	Map<Integer, String> students = new HashMap<Integer, String>();

	public void add() {
		students.put(1, "AAA");
		students.put(4, "bbb");
		students.put(3, "ccc");
		students.put(2, "ddd");

	}
	public void printKey() {
		for (Integer a : students.keySet()) {
			System.out.println(a);
		}
	}

	public void printValues() {
		for (String string : students.values()) {
			System.out.println(string);
		}
	}

	public void printvaluesSort() {
		
		for (Entry<Integer, String> entry  : entriesSortedByValues(students)) {
			System.out.println(entry.getValue());
		}
	}
	
	
}
