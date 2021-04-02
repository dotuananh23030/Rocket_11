import java.util.Scanner;

public class Position {
	private Scanner scanner;
	private int positionId;
	private String positionName;
	
	public Position(int positionId, String positionName) throws Exception {
		scanner = new Scanner(System.in);
		this.positionId = inputId();
		this.positionName = inputName();
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
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
			System.out.println("Please input PositionName: ");
			String name = scanner.nextLine();
			return name;
			
		} catch (Exception e) {
			throw new Exception("Input Wrong, Again!!!!");
		}
	}
}
