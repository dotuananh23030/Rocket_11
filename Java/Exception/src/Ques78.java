import java.util.Scanner;

public class Ques7 {
	private static Scanner scanner = new Scanner(System.in);

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	public static float inputFloat(String errMessage)
	{
		while(true)
		{
			try {
				return Float.parseFloat(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errMessage);
			}
		}
	}
	
	public static double inputDouble(String errMessage)
	{
		while(true)
		{
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errMessage);
			}
		}
	}
	
	public static String inputString(String errMessage)
	{
		String input = scanner.nextLine().trim();
		while(true)
		{
			if (!input.isEmpty()) {
				return input;
			}
			else {
				System.err.println(errMessage);
			}
		}
	}
	public static int inputAge()
	{
		while(true)
		{
			int age = inputInt("Ban phai nhap so, moi nhap lai!!!");
			if (age <= 0) {
				System.err.println("Tuoi phai lon hon 0, moi nhap lai!!!");
			}
			else {
				return age;
			}
		}
	}
	public static int inputAgeGreaterThan18()
	{
		while(true)
		{
			int age = inputAge();
			if (age < 18) {
				System.out.println("Cam tre em duoi 18 tuoi!!!");
			}
			else {
				return age;
			}
		}
	}
}
