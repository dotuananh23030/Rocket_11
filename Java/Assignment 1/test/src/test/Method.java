package test;

public class Method {
public static void main(String[] args) {
	Department[] departments = new Department[5];

	Department department1 = new Department();
	department1.id = 1;
	department1.name = "Sale";

	Department department2 = new Department();
	department2.id = 2;
	department2.name = "Marketing";

	Department department3 = new Department();
	department3.id = 3;
	department3.name = "Boss of director";

	Department department4 = new Department();
	department4.id = 4;
	department4.name = "Waiting room";

	Department department5 = new Department();
	department5.id = 5;
	department5.name = "Accounting";

	departments[0] = department1;
	departments[1] = department2;
	departments[2] = department3;
	departments[3] = department4;
	departments[4] = department5;

	if (department1.equals(department2)) {
		System.out.println("Có bằng nhau !");
	} else {
		System.out.println("Không bằng nhau !");
	}
	
	if (department.name.equals("Phòng A")) {
		System.out.println("Có tên là phòng A");
	} else {
		System.out.println("Không tên là phòng A");
	}

	
	for (int i = 0; i < departments.length; i++) {
		for (int j = 0; j < departments.length - 1; j++) {

			if (departments[i].name.compareToIgnoreCase(departments[j].name) < 0) {
				// swap
				Department temp = departments[i];
				departments[i] = departments[j];
				departments[j] = temp;
			}
		}
	}

	// print departments
	for (Department department : departments) {
		System.out.println(department);
	}

}
}
