package constructors;

public class C_02_OverloadingArgumentType {
	//Constructor 1
	public C_02_OverloadingArgumentType(int a, int b) {
		int c=a+b;
		System.out.println("Sum of two integers: "+c);
	}
	//Constructor 2
	public C_02_OverloadingArgumentType(double a, double b) {
		double c=a+b;
		System.out.println("Summation is: "+c);
	}
	//method
	public void display() {
		System.out.println("This is a method of class C_02_OverloadingArgumentType");
	}
	public static void main(String[] args) {
		C_02_OverloadingArgumentType obj1 = new C_02_OverloadingArgumentType(10, 20);
		obj1.display();
		C_02_OverloadingArgumentType obj2 = new C_02_OverloadingArgumentType(10.5, 20.5);
		
		obj2.display();
	}
}
