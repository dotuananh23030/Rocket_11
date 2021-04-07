package com.vti.academy.entity;

public class MyMath {
	public static int max(int a,int b) {
		int max;
		if(a > b) {
			max = a;
		}else {
			max = b;
		}
		return max;
	}
	
	public static int min(int a,int b) {
		int min;
		if(a > b) {
			min = a;
		}else {
			min = b;
		}
		return min;
	}
	
	public static int sum(int a,int b) {
		return a + b;
	}
}
