package com.MethodOveriding.Demo;
class Bank {
	public void calculateInterest() {
		System.out.println("General Interest Calculation");
	}
	
}
class SBI extends Bank{
	@Override
	public void calculateInterest() {
		System.out.println("SBI Interest= 6.5%");
	}
}
class HDFC extends Bank{
	@Override
	public void calculateInterest() {
		System.out.println("HDFC Interest= 7.0%");
	}
}
public class BankTest {
public static void main(String[] args)
{
	SBI sbi=new SBI();
	sbi.calculateInterest();
	HDFC hdfc=new HDFC();
	hdfc.calculateInterest();
}
	
}
