package Task52_DecisionMakingControlStatement_CaseStudy;
import java.util.Scanner;
class BankAccount{
	private double balance;
	public BankAccount(double initialBalance)
	{
		this.balance=initialBalance;
	}
	public void checkBalance()
	{
		System.out.println("Current Balance: "+balance);
	}
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
}
public class CheckBankAccountBalance {
	
	public static void main(String[] args)
	{
		Scanner scanner =new Scanner(System.in);
		BankAccount account=new BankAccount(1000.0); // Initial balance of 1000
		int choice;
		do {
		 System.out.println("\nBank Account Menu:");
		 System.out.println("1. Check Balance");
		 System.out.println("2. Deposit");
		 System.out.println("3. Withdraw");
		 System.out.println("4. Exit");
		 System.out.print("Enter your choice: ");
		 choice=scanner.nextInt();
		 switch(choice)
		 {
			 case 1:
				 account.checkBalance();
				 break;
			 case 2:
				 System.out.print("Enter amount to deposit: ");
				 double depositAmount=scanner.nextDouble();
				 account.deposit(depositAmount);
				 break;
			 case 3:System.out.print("Enter amount to withdraw: ");
				 double withdrawAmount=scanner.nextDouble();
				 account.withdraw(withdrawAmount);
				 break;
			 case 4: System.out.println("Exiting...");
				 break;
			default: System.out.println("Invalid choice. Please try again.");
		 }
		}while(choice!=4);
	scanner.close();
}

}
