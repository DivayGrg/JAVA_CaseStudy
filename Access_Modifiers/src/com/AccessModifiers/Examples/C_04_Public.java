package com.AccessModifiers.Examples;

public class C_04_Public {

	public static void main(String[] args) {
		// Use class B from the same package to demonstrate public access
		B obj = new B();
		int ouput = obj.x;
		System.out.println("Value of x is : " + ouput);
		obj.b1();

	}

}
