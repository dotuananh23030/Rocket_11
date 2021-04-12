package com.vti.academy.backend;

import com.vti.academy.backend.NgayThangNam.GioPhutGiay;

public class MainClass {
	public static void main(String[] args) {
		NgayThangNam date = new NgayThangNam();
		date.ngay = 31;
		date.thang = 10;
		date.nam = 2017;
		
		GioPhutGiay time = date.new GioPhutGiay();
		time.gio = 10;
		time.phut = 15;
		time.giay = 30;
		
		time.xuatThongTin();
	}
}
