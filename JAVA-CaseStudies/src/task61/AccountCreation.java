package task61;

import java.util.ArrayList;
import java.util.List;

public class AccountCreation {

	public static void main(String[] args) {

		try {
			// Arrange - create an account using the no-argument constructor
			Account a1 = new Account();

			// Act - deposit 10
			a1.deposit(10);

			// Assert - check that the balance is 10
			if (a1.getBalance() != 10) throw new AssertionError("No-arg constructor deposit: expected 10 but was " + a1.getBalance());
			else System.out.println("PASS: No-arg constructor deposit -> " + a1.getBalance());

			// Arrange - create a checking account using the parameterized constructor
			Account a2 = new Account(0, 22222, Account.AccountType.CHECKING);

			// Act - deposit 10
			a2.deposit(10);

			// Act - withdraw 20
			a2.withdraw(20);

			// Assert - check that the balance is -10
			if (a2.getBalance() != -10) throw new AssertionError("Checking account overdraw: expected -10 but was " + a2.getBalance());
			else System.out.println("PASS: Checking account overdraw -> " + a2.getBalance());

			// EXCEPTIONS 
			Account sav = new Account(0, 33333, Account.AccountType.SAVINGS);
			boolean exceptionThrown = false;
			try {
				sav.withdraw(10);
			} catch (ArithmeticException ex) {
				exceptionThrown = true;
				System.out.println("PASS: Savings account overdraw throws ArithmeticException");
			}
			if (!exceptionThrown) {
				throw new AssertionError("Expected ArithmeticException when overdrawing savings account");
			}

			// PARAMETERIZED TEST for savings withdraw
			int[] withdrawals = {0, 5, 10};
			int[] expected = {10, 5, 0};
			for (int i = 0; i < withdrawals.length; i++) {
				Account s = new Account(0, 40000 + i, Account.AccountType.SAVINGS);
				s.deposit(10);
				s.withdraw(withdrawals[i]);
				if (s.getBalance() != expected[i]) throw new AssertionError("Savings withdraw " + withdrawals[i] + ": expected " + expected[i] + " but was " + s.getBalance());
				else System.out.println("PASS: Savings withdraw " + withdrawals[i] + " -> " + s.getBalance());
			}

			// Demonstrate array and list (kept inline to avoid extra methods)
			Account[] arr = new Account[] {
				new Account(10, 11111, Account.AccountType.CHECKING),
				new Account(20, 22222, Account.AccountType.SAVINGS),
				new Account(30, 33333, Account.AccountType.CHECKING)
			};
			for (Account a : arr) System.out.println(a);

			List<Account> list = new ArrayList<>();
			list.add(new Account(5, 44444, Account.AccountType.SAVINGS));
			list.add(new Account(15, 55555, Account.AccountType.CHECKING));
			list.add(new Account(25, 66666, Account.AccountType.SAVINGS));
			for (Account a : list) System.out.println(a);

			System.out.println("All checks passed.");
		} catch (Throwable t) {
			System.err.println("TEST FAILURE: " + t.getMessage());
			t.printStackTrace();
			System.exit(1);
		}
	}


	// Minimal Account implementation kept inside this file to avoid using external Account.java
	static class Account {

		static enum AccountType { CHECKING, SAVINGS }

		private int balance;
		private int accountNumber;
		private AccountType type;

		public Account() {
			this(0, 12345, AccountType.CHECKING);
		}

		public Account(int balance, int accountNumber, AccountType type) {
			this.balance = balance;
			this.accountNumber = accountNumber;
			this.type = type;
		}

		public int getBalance() {
			return balance;
		}

		public void deposit(int amount) {
			if (amount < 0) throw new IllegalArgumentException("Cannot deposit negative amount");
			this.balance += amount;
		}

		public void withdraw(int amount) {
			if (amount < 0) throw new IllegalArgumentException("Cannot withdraw negative amount");
			int resulting = this.balance - amount;
			if (this.type == AccountType.SAVINGS && resulting < 0) {
				throw new ArithmeticException("Overdrawing a savings account is not allowed");
			}
			this.balance = resulting;
		}

		@Override
		public String toString() {
			return String.format("The account with number %d is of type '%s' and has a balance of %d", accountNumber, type, balance);
		}
	}

}
