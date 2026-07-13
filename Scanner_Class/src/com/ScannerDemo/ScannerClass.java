package com.ScannerDemo;
import java.util.Scanner;
public class ScannerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard=new Scanner(System.in);
		System.out.print("Please enter your first name Initial");
		String firstInitial=keyboard.nextLine();
		System.out.print("Please enter your last name");
		String lastName =keyboard.nextLine();
		System.out.print("Please enter your house number");
		int houseNumber=keyboard.nextInt();
		System.out.print("Please enter your street name");
		String streetName=keyboard.nextLine();
		System.out.print("Please enter your street type");
		String streetType=keyboard.nextLine();
		System.out.print("Please enter your city");
		String city=keyboard.nextLine();
		System.out.print(firstInitial+" "+lastName+" "+houseNumber+" ");
		System.out.println(streetName+" "+streetType+" "+city);
		
		keyboard.close();
	}

}
