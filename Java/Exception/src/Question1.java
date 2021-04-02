import java.util.Scanner;

public class Question1 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	try {
		float result = divide(10,1);
		System.out.println(result);
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("Error!");
	}finally {
		scanner.close();
		System.out.println("Finally!");
	}
}

private static float divide(int a, int b) {
	// TODO Auto-generated method stub
	return a/b;
}
}
