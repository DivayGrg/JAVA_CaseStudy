package com.ScannerDemo;
import java.util.Scanner;
public class next {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name: ");
		
		String value = input.next();
		System.out.println("Text Entered: " + value);
		input.close();

	}

}
