package ExceptionHandling;

public class C_03_UnCheckedException_TryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Program started");
		try {
			int x=10/0;
			System.out.println("Division result is: "+x);
		}
		catch(ArithmeticException e) {
			System.out.println("Something went wrong. Please check the Exception."+e.getMessage());
		}
		System.out.println("Program ended");

	}

}
