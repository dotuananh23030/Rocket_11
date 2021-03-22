import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class program {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	// Create group
			Group group1 = new Group();
			group1.id = 1;
			group1.name = "Java Fresher";
			group1.createDate = new Date(2020, 04, 21);

			Group group2 = new Group();
			group2.id = 2;
			group2.name = "DB Fresher";
			group2.createDate = new Date(2020, 04, 21);

			Group group3 = new Group();
			group3.id = 3;
			group3.name = "C++ Fresher";
			group3.createDate = new Date(2020, 04, 16);

			// Create Deparment
			Department department1 = new Department();
			department1.id = 1;
			department1.name = "Sale";

			Department department2 = new Department();
			department2.id = 2;
			department2.name = "Marketting";

			Department department3 = new Department();
			department3.id = 3;
			department3.name = "HR";

			// Create Position
			Position position1 = new Position();
			position1.id = 1;
			position1.name = "Manager";

			Position position2 = new Position();
			position2.id = 2;
			position2.name = "Team Leader";

			Position position3 = new Position();
			position3.id = 3;
			position3.name = "Trainee";

			// Create account
			Account account1 = new Account();
			account1.id = 1;
			account1.createDate = new Date(2020, 03, 17);
			account1.department = department1;
			account1.email = "An@gmail.com";
			account1.fullname = "Nguyen Van An";
			account1.position = position1;
			account1.username = "an.nguyenvan";

			Account account2 = new Account();
			account2.id = 2;
			account2.createDate = new Date(2020, 01, 9);
			account2.department = department1;
			account2.email = "Linh@gmail.com";
			account2.fullname = "Nguyen Hoai Linh";
			account2.position = position3;
			account2.username = "Linh.nguyenhoai";

			Account account3 = new Account();
			account3.id = 3;
			account3.createDate = new Date(2020, 03, 19);
			account3.department = department2;
			account3.email = "ha@gmail.com";
			account3.fullname = "Pham Hai Ha";
			account3.position = position1;
			account3.username = "Ha.phamhai";

			// Create CategoryQuestion
			CategoryQuestion category1 = new CategoryQuestion();
			category1.id = 1;
			category1.name = "JAVA";

			CategoryQuestion category2 = new CategoryQuestion();
			category2.id = 2;
			category2.name = "DB";

			CategoryQuestion category3 = new CategoryQuestion();
			category3.id = 3;
			category3.name = "C++";

			// Create TypeQuestion
			TypeQuestion type1 = new TypeQuestion();
			type1.id = 1;
			type1.name = "Essay";

			TypeQuestion type2 = new TypeQuestion();
			type2.id = 2;
			type2.name = "Multi-choice";

			// Create Question
			Question question1 = new Question();
			question1.categoryQuestion = category1;
			question1.content = "Dac diem chinh cua Java";
			question1.createDate = new Date(2020, 1, 7);
			question1.creator = account1;
			question1.id = 1;
			question1.typeQuestion = type1;

			Question question2 = new Question();
			question2.categoryQuestion = category1;
			question2.content = "Cac chuong trinh Java chu yeu";
			question2.createDate = new Date(2020, 2, 8);
			question2.creator = account1;
			question2.id = 2;
			question2.typeQuestion = type2;

			Question question3 = new Question();
			question3.categoryQuestion = category1;
			question3.content = "Quy tac thiet ke Database";
			question3.createDate = new Date(2019, 2, 9);
			question3.creator = account2;
			question3.id = 3;
			question3.typeQuestion = type1;

			// Create exam
			Exam exam1 = new Exam();
			exam1.code = "JV01";
			exam1.createDate = new Date(2019, 9, 4);
			exam1.creator = account1;
			exam1.duration = Duration.MINUTE_60;
			exam1.id = 1;
			exam1.title = "Kien thuc co ban ve Java";

			Exam exam2 = new Exam();
			exam2.code = "DB01";
			exam2.createDate = new Date(2019, 12, 4);
			exam2.creator = account2;
			exam2.duration = Duration.MINUTE_45;
			exam2.id = 2;
			exam2.title = "Kien thuc co ban ve Database";

			// add question to exam
			Question[] questionOfExam1 = { question1, question2 };
			exam1.questions = questionOfExam1;

			Question[] questionOfExam2 = { question3 };
			exam1.questions = questionOfExam2;

			// add group to account
			Group[] groupOfAccount1 = { group1 };
			account1.groups = groupOfAccount1;

			Group[] groupOfAccount2 = { group3 };
			account2.groups = groupOfAccount2;

			Group[] groupOfAccount3 = { group1 };
			account3.groups = groupOfAccount3;

			// add account to group
			Account[] accountOfGroups1 = { account1, account2, account3 };
			group1.accounts = accountOfGroups1;
			 //Q1.
//			if (account2.department == null) {
//				System.out.println("Nhân viên này chưa có phòng ban");
//			} else
//				System.out.println("Phòng ban của nhân viên này là: "
//						+ account2.department.name);

			//Q2
//			if (account2.groups == null || account2.groups.length == 0) {
//				System.out.println("Nhân viên này chưa có group");
//				} else if (account2.groups.length == 1){
//				System.out.println("Group của nhân viên này là" + account2.groups[0]);	
//			    }
//			else if(account2.groups.length == 2) {
//				System.out.println("Group của nhân viên này là" + account2.groups[1] +","+account2.groups[0]);
//			    }
//			else if (account2.groups.length == 3) {
//				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
//
//			} else
//				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
//
			//Q4
//			System.out.println(account1.position.name == "Dev" ? "Đây là Developer" : "Người này không phải Developer");
			//Q3
//			System.out.println(account1.department == null ? "Nhân viên này chưa có phòng ban" : "Nhân viên này thuộc phòng ban " + account2.department.name);
			//Q5
//			int x = group1.accounts.length;
//			switch(x) {
//			case 1:
//				System.out.println("Nhóm có một thành viên");
//				break;
//			case 2:
//				System.out.println("Nhóm có hai thành viên");
//				break;
//			case 3:
//				System.out.println("Nhóm có ba thành viên");
//			default:
//				System.out.println("Nhóm có nhiều thành viên");
//			}
			//Q6
//			int y = account2.groups.length;
//			switch (y) {
//			case 0:
//				System.out.println("Nhân viên này chưa có group");
//				break;
//			case 1:
//				System.out.println("Group của nhân viên này là"+ account2.groups[0]);
//				break;
//			case 2:
//				System.out.println("Group của nhân viên này là"+ account2.groups[0] + ", " + account2.groups[1]);
//				break;
//			case 3:
//				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
//				break;
//			default:
//				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
//			}
            //Q7
//			String z = account1.position.name;
//			switch(z) {
//			case"Dev":
//				System.out.println("Đây là developer");
//				break;
//			default:
//				System.out.println("Người này không phải developer");
//			}
			//Q8
//			Account[] accounts = {account1,account2,account3};
//			for(Account account : accounts) {
//				System.out.println("Email: " + account.email );
//				System.out.println("FullName: " + account.fullname);
//				System.out.println("Name department: " + account.department.name);
//			}
			//Q9
//			Department[] departments = { department1, department2, department3 };
//			for (Department department : departments) {
//				System.out.println("ID Department: " + department.id);
//				System.out.println("Name Department: " + department.name);
//               }
			//Q10
//			Account[] accounts1 = {account1,account2,account3};
//			for (int i = 0; i < accounts1.length; i++) {
//				System.out.println("Thông tin account thứ " + (i + 1) + " là :");
//				System.out.println("Email: " + accounts1[i].email);
//				System.out.println("Fullname: " + accounts1[i].fullname);
//				System.out.println("Department: " + accounts1[i].department.name);
//			}
			//Q11
//			Department[] departments = { department1, department2, department3 };
//			for (int i = 0; i < departments.length; i++) {
//				System.out.println("Thông tin department thứ " + (i + 1) + " là :" );
//				System.out.println("ID: " + departments[i].id);
//				System.out.println("Name: "+ departments[i].name);
//			}
			//Q12
//			Department[] departments = { department1, department2 };
//			for (int i = 0; i < departments.length ; i++) {
//				System.out.println("Thông tin department thứ " + (i + 1) + " là :" );
//				System.out.println("ID: " + departments[i].id);
//				System.out.println("Name: "+ departments[i].name);
//			}
			//Q13
//			Department[] departments = { department1, department2 };
//			for (int i = 0; i < departments.length; i++) {
//				if (i != 1) {
//					System.out.println("Thông tin department thứ " + (i + 1)
//							+ " là :");
//					System.out.println("ID: " + departments[i].id);
//					System.out.println("Name: " + departments[i].name);
//				}
//			}

			//Q14
//			Account[] accounts111 = {account1,account2,account3};
//			for (int i = 0; i < accounts111.length; i++) {
//				if (accounts111[i].id < 4) {
//					System.out.println("Thông tin account thứ " + (i + 1) + " là :");
//					System.out.println("Email: " + accounts111[i].email);
//					System.out.println("Fullname: " + accounts111[i].fullname);
//					System.out.println("Department: " + accounts111[i].department.name);
//				}
//			}
			// Q15.
//			for (int i = 2; i <= 20; i = i + 2) {
//				System.out.println(i);
//			}
//			// Q16
//			int i = 0;
//			Account[] accounts1 = {account1,account2,account3};
//			while (i < accounts1.length) {
//				System.out.println("Thông tin account thứ " + (i + 1) + " là :");
//				System.out.println("Email: " + accounts1[i].email);
//				System.out.println("Fullname: " + accounts1[i].fullname);
//				System.out.println("Department: " + accounts1[i].department.name);
//				i++;
//			}
			// Q17
//			int i = 0;
//			Account[] accounts1 = {account1,account2,account3};
//			do {
//				System.out.println("Thông tin account thứ " + (i + 1) + " là :");
//				System.out.println("Email: " + accounts1[i].email);
//				System.out.println("Fullname: " + accounts1[i].fullname);
//				System.out.println("Department: " + accounts1[i].department.name
//						break;);
//				}
//			while( i < accounts1.length);
			//Ex2:
		//Q1:
//			int a = 5;
//			System.out.printf(Locale.US,"%d%n", a);
		//Q2:
//			int b = 1000000000 ;
//			System.out.printf(Locale.US,"%,d%n", b);
		//Q3:
//			float c = 5.567098f;
//			System.out.printf("%5.4f%n", c);
		//Q4:
//			String s = "Nguyen van A";
//			System.out.printf("Tên tôi là \"" + s + "\" và tôi đang độc thân \n");
		//Q5:
//			String pattern = "dd/MM/yyyy HH:mm:ss";
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//			String date = simpleDateFormat.format(new Date());
//			System.out.println(date);
			//EX 3:
		  //Q 1
//			Locale locale = new Locale("vi", "VN");
//			DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
//			String date = dateformat.format(account1.createDate);
//			System.out.println(exam1.code + ": " + date);
		  //Q 2
//			String pattern = "yyyy-MM-dd-HH-mm-ss";
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//			Exam[] exams = { exam1, exam2 };
//			for (Exam exam : exams) {
//				String date = simpleDateFormat.format(exam.createDate);
//				System.out.println(exam.code + ": " + date);
//			}
		  //Q 3
//			String pattern = "yyyy";
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//			for (Exam exam : exams) {
//				String date = simpleDateFormat.format(exam.createDate);
//				System.out.println(exam.code + ": " + date);
//			}
			
		  //Q 4
//			String pattern = "yyyy-MM";
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//			Exam[] exams = { exam1, exam2 };
//			for (Exam exam : exams) {
//				String date = simpleDateFormat.format(exam.createDate);
//				System.out.println(exam.code + ": " + date);
//			}
		  //Q 5
//			String pattern = "MM-DD";
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//			Exam[] exams = { exam1, exam2 };
//			for (Exam exam : exams) {
//				String date = simpleDateFormat.format(exam.createDate);
//				System.out.println(exam.code + ": " + date);
//			}
			//EX 4
			@SuppressWarnings("unused")
		//Q 1
//			Random random = new Random();
//			int x = random.nextInt();
//			System.out.println(x);
		//Q 2
//			Random random = new Random();
//			float x = random.nextFloat();
//			System.out.println(x);
		//Q 3
//			String[] names = {"Nguyen Mai", "Van Linh", "Hoa Lan" };
//			Random random = new Random();
//			int x = random.nextInt(names.length);
//			System.out.println(names[1]);
		//Q 4
//			int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
//			int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
//			long randomInt = minDay + random.nextInt(maxDay - minDay);
//			LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
//			System.out.println(randomDay);
		// Q5.
//			int now = (int) LocalDate.now().toEpochDay();
//			Random random = new Random();
//			randomInt = now - random.nextInt(365);
//			randomDay = LocalDate.ofEpochDay(randomInt);
//			System.out.println(randomDay);

		}
	}
