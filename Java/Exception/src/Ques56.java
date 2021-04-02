import java.util.InputMismatchException;
import java.util.Scanner;

public class Ques56 {
	public static void main(String[] args) {
		while(true)
		{
			try {
				int age = inputInt();
				System.out.println("tuoi cua ban la: " + inputAge(age));
				return;
			} catch (Exception e) {
				System.out.println("Tuoi phai lon hon 0!!!!!");
			}
		}
	}
	public static int inputAge(int age) throws Exception 
	{
			if (age <= 0) {
				throw new Exception("Tuoi phai lon hon 0");
			}
			else {
				return age;
			}
	}
	
	public static int inputInt()
	{
		while(true)
		{
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("moi ban nhap so: ");
				int a = scanner.nextInt();
				return a;
			} catch (InputMismatchException e) {
				System.err.println("Ban phai nhap so!!!");
			}
		}
	}
	
	
}
