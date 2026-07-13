package com.AccessModifiers.Examples;
class B{
	int x=10;
	public void b1() {
		System.out.println("This is a default method");
	}
	protected int z=200;
	protected void ProtectedMethod() {
		System.out.println("This is a protected method");
	}
}
public class C_02_Default {

	public static void main(String[] args) {
		B obj=new B();
		
		int output=obj.z;
		System.out.println("Value of Z is " + output);
		obj.b1();
		obj.ProtectedMethod();
		// TODO Auto-generated method stub

	}

}
