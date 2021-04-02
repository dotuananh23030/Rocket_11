
public class Question4 {
	public static void main(String[] args) {
		try {
			String Department[] = {"department1","department2","department3"};
			getIndex(Department);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Khong tìm thấy phần tử trong mảng");
		}
	}

	private static void getIndex(String[] department) throws Exception {
		// TODO Auto-generated method stub
		int index = 5;
		if(index > department.length)
			throw new Exception("khong tim thay phan tu trong mang.");
	}
	
}
