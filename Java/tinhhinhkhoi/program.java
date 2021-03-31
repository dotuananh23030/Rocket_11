package com.vti.academy.tinhhinhkhoi;

public class program {
public static void main(String[] args) {
	HinhChuNhat hcn = new HinhChuNhat();
	float c = hcn.tinhChuVi(5,  7);
	System.out.println(c);
	
	HinhVuong hv = new HinhVuong();
	float d = hv.tinhChuVi(5, 5);
	System.out.println(d);
}
}
