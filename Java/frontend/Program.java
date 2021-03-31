package com.vti.academy.frontend;

import java.util.Scanner;

import com.vti.academy.backend.MyNews;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MyNews myNews = new MyNews();
		System.out.println("1. Insert news\n" + "2. View list news\n3. Average rate các cán bộ."
				+ "\n4.Thoát khỏi chương trình.");
		while(true) {
			System.out.println("Mới bạn nhập số: ");
			int choose = scanner.nextInt();
			switch(choose) {
			case 1:
				myNews.insertNews();
				break;

			case 2:
				myNews.viewListNews();
				break;

			case 3:
				myNews.averageRate();
				break;
				
			case 4:
				System.out.println("thoát ra khỏi chương trình");
				return;
				
			default:
				break;
			}
			
		} 
	}
}
