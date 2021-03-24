package test;

public class BoxingAndUnboxing {
	public static void main(String[] args) {
//		question1();
//		question2();
		question3();
	}
//	public static void question1() {
//		Integer salary = 5000;
//		System.out.printf("%2.2f", (float) salary);
//	}
//	public static void question2() {
//		String s1 = "1234567";
//		Integer a = Integer.valueOf(s1);
//		System.out.println(a);
//	}
	public static void question3() {
		Integer a = 1234567 ;
		int b = a.intValue();
		System.out.println(b);
	}
}
