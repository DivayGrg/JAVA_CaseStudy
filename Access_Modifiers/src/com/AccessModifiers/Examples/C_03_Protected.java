package com.AccessModifiers.Examples;

public class C_03_Protected {

	public static void main(String[] args) {
		// B is a package-private class defined in C_02_Default.java
		B obj = new B();
		int output = obj.z; // protected member accessible within same package
		System.out.println("Value of Z is " + output);
		obj.ProtectedMethod();
	}

}
