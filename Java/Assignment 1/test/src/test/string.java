package test;

import java.util.Scanner;

public class string {
	public static void main(String[] args) {
//		String s1;
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Nhập chuỗi: ");
//		s1 = scanner.nextLine();
//		String[] words = s1.split(" ");
//		System.out.println("Số kí tự: " + words.length);
//        scanner.close();
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Nhập chuỗi 1: ");
//		String s1 = scanner.nextLine();
//		System.out.println("Nhập chuỗi 2: ");
//		String s2 = scanner.nextLine();
//		System.out.println("Sau khi nối chuỗi : " + s1.concat(s2));
//		scanner.close();
//		Scanner scanner = new Scanner(System.in);
//		String name;
//		System.out.println("Nhập Tên: ");
//		name = scanner.nextLine();
//		String firstCharacter = name.substring(0, 1).toUpperCase();
//		String leftCharacter = name.substring(1);
//		name = firstCharacter + leftCharacter;
//		System.out.println(name);
//		scanner.close();

//		String name;
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Nhập tên: ");
//		name = scanner.nextLine();
//		name = name.toUpperCase();
//		for (int i = 0; i < name.length(); i++) {
//			System.out.println("Ký tự thứ " + i + " là: " + name.charAt(i));
//		}
//		scanner.close();
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Nhập họ: ");
//		String firstName = scanner.nextLine();
//		System.out.println("Nhập tên: ");
//		String lastName = scanner.nextLine();
//		System.out.println("Họ tên đầy đủ: " + firstName.concat(lastName));
//		scanner.close();

		String fullName;
		String lastName = "", middleName = "", firstName = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập họ tên đầy đủ:");
		fullName = scanner.nextLine();
		fullName = fullName.trim();
		String[] words = fullName.split(" ");
		lastName = words[0];
		firstName = words[words.length - 1];
		for (int i = 1; i <= words.length - 2; i++) {
			middleName += words[i] + " ";
		}
		System.out.println("Họ là: " + lastName);
		System.out.println("Tên đệm là: " + middleName);
		System.out.println("Tên là: " + firstName);
		scanner.close();

		String[] groupNames = { "Java with Duy Nguyễn", "Cách qua môn gia va", "Học Java có khó không?" };

		for (String groupName : groupNames) {
			if (groupName.contains("Java")) {
				System.out.println(groupName);
			}
		}
		
		String[] groupNames = { "Java", "C#", "C++" };

		for (String groupName : groupNames) {
			if (groupName.equals("Java")) {
				System.out.println(groupName);
			}
		}
		canner scanner = new Scanner(System.in);
		String str;

		System.out.println("Mời bạn nhập vào một chuỗi: ");
		str = scanner.nextLine();

		scanner.close();

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if ('a' == str.charAt(i)) {
				count++;
			}
		}

		System.out.println(count);

	}
}
