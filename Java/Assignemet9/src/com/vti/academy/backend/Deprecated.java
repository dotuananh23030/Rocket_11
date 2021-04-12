package com.vti.academy.backend;

import java.util.Date;

public class Deprecated {
public static void main(String[] args) {
	@SuppressWarnings("deprecation")
	Date date = new Date(2020, 5, 18);
	System.out.println(date);
	
	
}
}
