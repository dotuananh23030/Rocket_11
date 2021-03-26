package com.vti.academy.frontend.encapsulation.ex2;

public class circle {
	private double radius;
	private String color;
	private final double PI = 3.14;
	
	public circle() {
		
	}
	
	public circle(double radius) {
		this.radius = radius;
	}
	
	public circle(double radius,String color) {
		this.radius = radius;
		this.color = color;
	}
	
	public double getRadius() {
		return radius;
	} 
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public String getColor() {
		return color;
	} 
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		return PI * Math.pow(radius, 2.0);
	}
	
	public String toString() {
		return "Circle{" + "radius=" + radius + ", color='" + color + '\'' + '}';
	}
}
