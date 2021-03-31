package com.vti.academy.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.academy.entity.News;

public class MyNews {
	private ArrayList<News> newsList;
	private Scanner scanner;
	
	public MyNews() {
		super();
		newsList = new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	
	public void insertNews() {
		News news = new News();
		int[] rates = new int[3];
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhập Title: ");
		news.setTitle(scanner.nextLine());

		System.out.println("Nhập Publish Date: ");
		news.setPublishDate(scanner.nextLine());

		System.out.println("Nhập Author: ");
		news.setAuthor(scanner.nextLine());

		System.out.println("Nhập Content: ");
		news.setContent(scanner.nextLine());
		
		System.out.println("Nhập vào 3 đánh giá: ");
		for(int i = 0; i < 3 ;i++) {
			System.out.println("Đánh giá" + (i+1) + ":");
			rates[i] = scanner.nextInt();
		}
		news.setRates(rates);

		newsList.add(news);
	}
	

	public void viewListNews() {
		// TODO Auto-generated method stub
		for(News news : newsList) {
			news.display();
		}
	}

	public void averageRate() {
		// TODO Auto-generated method stub
		for(News news : newsList) {
			System.out.println("Title: " + news.getTitle() + "  Average Rate: " + news.calculate());
		}
	}
}
