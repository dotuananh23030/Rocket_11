package com.vti.academy.entity;

public class HinhTron extends HinhHoc {
	public HinhTron(float a, float b) throws Exception {
		super(a, b);
	}
	public double dientich (float a) {
		return a * a * 3.14;
	}
	public double chuVi (double a) {
		return a *2 * 3.14;
	}
}
