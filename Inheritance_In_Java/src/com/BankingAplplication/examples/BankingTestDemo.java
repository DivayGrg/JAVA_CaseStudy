package com.BankingAplplication.examples;
class Account{
	double balance=1000.0; // Initial balance
	String accountHolderName="Divay Garg";
	public void deposit(double amount)
	{
		if(amount>0)
		{
			balance+=amount;
			System.out.println("Deposited: "+amount);
		}
		else
		{
			System.out.println("Deposit amount must be positive.");
		}
	}
	public void withdraw(double amount)
	{
		if(amount>0)
		{
			if(amount<=balance)
			{
				balance-=amount;
				System.out.println("Withdrawn: "+amount);
			}
			else
			{
				System.out.println("Insufficient balance.");
			}
		}
		else
		{
			System.out.println("Withdrawal amount must be positive.");
		}
	}
	public void displayBalance()
	{
		System.out.println("Current Balance: "+balance);
	}
}

class SavingsAccount extends Account{
	double interestRate=0.05; // 5% interest rate
	public void calculateInterest()
	{
		double interest=balance*interestRate;
		System.out.println("Interest earned: "+interest);
	}
}
public class BankingTestDemo {

	public static void main(String[] args) {
	    SavingsAccount sa=new SavingsAccount();
	    System.out.println("Account Holder: "+sa.accountHolderName);
	    sa.deposit(500.0);
	    sa.withdraw(1000.0);
	    sa.displayBalance();
	    sa.calculateInterest();
	}

}
