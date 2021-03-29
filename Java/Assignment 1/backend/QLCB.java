package com.vti.academy.backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.vti.academy.entity.CanBo;
import com.vti.academy.entity.CongNhan;
import com.vti.academy.entity.KySu;
import com.vti.academy.entity.NhanVien;

public class QLCB {
	private List<CanBo> canbos;
	private Scanner scanner;
	
	public QLCB() {
		canbos = new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	
	public void themCanBo() {
		System.out.print("Bạn muốn thêm cán bộ nào (1.CongNhan, 2.KySu, 3.NhanVien): ");
		int choose = scanner.nextInt();
		scanner.nextLine();
		switch (choose) {
		case 1:
			CongNhan a = new CongNhan();
			canbos.add(a);
			break;
		case 2:
			KySu b = new KySu();
			canbos.add(b);
			break;		
		case 3:
			NhanVien c = new NhanVien();
			canbos.add(c);
			System.out.println("Thêm thành công!");
			break;
		default:
			break;
		}
		
		scanner.close();
	}
	public void timKiemTheoTen() {
		System.out.println("Nhap ho ten can tim: ");
		String ten;
		Scanner scanner = new Scanner(System.in);
		ten = scanner.nextLine();
		
		for(CanBo canBo : canbos) {
			if(ten.equals(canBo.getTen())) {
				canBo.getInfor();
			}
		}
		scanner.close();
	}

	public void hienThiThongTinCanBo() {
		//System.out.println("Hiện thị thông tin về danh sách các cán bộ.");
		for(CanBo canBo : canbos) {
			canBo.getInfor();
		}
	}

	public void xoaCanBo() {
		System.out.println("Nhập vào tên của cán bộ và delete cán bộ đó");
		Scanner scanner = new Scanner(System.in);
		String ten;
		ten = scanner.nextLine();
		canbos.removeIf(cb -> ten.equals(cb.getTen()));
		
		
	}
}
