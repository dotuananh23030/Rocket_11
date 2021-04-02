import java.util.Scanner;

public class Department {
	private Scanner scanner;
	private int departmentId;
	private String departmentName;
	
	public Department(int departmentId, String departmentName) throws Exception {
		
		scanner = new Scanner(System.in);
		this.departmentId = inputId();
		this.departmentName = inputName();
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	private int inputId() throws Exception
	{
		try {
			System.out.println("Input ID: ");
			int id = scanner.nextInt();
			return id;
		} catch (Exception e) {
			throw new Exception("Please input number!!!");
		}
	}
	
	private String inputName() throws Exception
	{
		try {
			System.out.println("Please input DepartmentName: ");
			String name = scanner.nextLine();
			return name;
			
		} catch (Exception e) {
			throw new Exception("Input Wrong, Again!!!!");
		}
	}
	
}
