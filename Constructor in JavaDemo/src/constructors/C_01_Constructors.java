package constructors;

public class C_01_Constructors {
	public C_01_Constructors() {
		System.out.println("This is a constructor");
	}
	//Method
	public void method() {
		System.out.println("This is a method");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C_01_Constructors obj=new C_01_Constructors();// Default Constructors
		//Constructor is called when object is created
		obj.method();
		//Need to call explicitly for the method
	}

}
