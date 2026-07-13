package Constructors;

public class ConstructorsUsingInstanceVariable {
	String webName;
	int webAge;
	// Constructor
	ConstructorsUsingInstanceVariable(String name, int age) {
		webName = name;
		webAge = age;
	}
	public static void main(String[] args) {
		ConstructorsUsingInstanceVariable obj = new ConstructorsUsingInstanceVariable("Java", 25);
		System.out.println("Website Name: " + obj.webName);
		System.out.println("Website Age: " + obj.webAge);
	}
	
}
