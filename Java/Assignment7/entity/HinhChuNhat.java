package com.vti.academy.entity;

public class HinhChuNhat extends HinhHoc {

	public HinhChuNhat(float a, float b) throws Exception {
		super(a, b);
	}
	public float chuVi(float a,float b) {
		return (a + b)*2;
	}
	public float dienTich(float a,float b) {
		return a*b;
	}
}
