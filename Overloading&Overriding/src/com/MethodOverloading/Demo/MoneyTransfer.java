package com.MethodOverloading.Demo;

public class MoneyTransfer {
	public void transfer(double amount) {
		System.out.println("Transferring " + amount + " using bank transfer.");
	}
	public void transfer(double amount, String accountNumber) {
		System.out.println("Transferring " + amount + " to " + accountNumber + " using bank transfer.");
	}
	public void transfer(double amount, String accountNumber, String remarks) {
		System.out.println("Transferring " + amount + " " + remarks + " to account number: " + accountNumber);
	}
	public static void main(String[] args)
	{
		MoneyTransfer mt = new MoneyTransfer();
		mt.transfer(1000.0);
		mt.transfer(500.0, "123456789");
		mt.transfer(200.0, "987654321", "Payment for services");
	}
}
