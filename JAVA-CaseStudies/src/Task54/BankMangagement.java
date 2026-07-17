package Task54;

/**
 * Beginner-friendly bank account demo and simple tests using if-based assertions.
 * Tests included:
 *  - create account, deposit, assert balance
 *  - checking account allowing negative balance
 *  - savings account rejecting overdraft (throws)
 *  - parameterized savings withdraw tests
 */
public class BankMangagement {

	// Simple base account
	static class Account {
		protected double balance;

		public Account() {
			this.balance = 0;
		}

		public Account(double initial) {
			this.balance = initial;
		}

		public void deposit(double amount) {
			if (amount < 0) throw new IllegalArgumentException("Deposit must be non-negative");
			balance += amount;
		}

		/**
		 * Withdraw from account. Base implementation allows overdraft (used for checking).
		 */
		public void withdraw(double amount) {
			balance -= amount;
		}

		public double getBalance() {
			return balance;
		}
	}

	// Checking account - allows negative balances
	static class CheckingAccount extends Account {
		public CheckingAccount() { super(); }
		public CheckingAccount(double initial) { super(initial); }
		@Override
		public void withdraw(double amount) {
			// allow overdraft
			super.withdraw(amount);
		}
	}

	// Savings account - does NOT allow withdrawing more than available balance
	static class SavingsAccount extends Account {
		public SavingsAccount() { super(); }
		public SavingsAccount(double initial) { super(initial); }

		@Override
		public void withdraw(double amount) {
			if (amount < 0) throw new IllegalArgumentException("Withdraw must be non-negative");
			if (amount > balance) {
				throw new IllegalStateException("Insufficient funds for savings account");
			}
			super.withdraw(amount);
		}
	}

	// Very small helper that behaves like an if-based assertion for beginners
	static void assertEquals(double expected, double actual, String testName) {
		if (expected == actual) {
			System.out.println("PASS: " + testName + " (expected=" + expected + ", actual=" + actual + ")");
		} else {
			System.out.println("FAIL: " + testName + " (expected=" + expected + ", actual=" + actual + ")");
		}
	}

	public static void main(String[] args) {
		System.out.println("Running simple account tests...");

		// Arrange - create an account using the no-argument constructor
		Account a1 = new Account();
		// Act - deposit 10
		a1.deposit(10);
		// Assert - check that the balance is 10
		assertEquals(10, a1.getBalance(), "Account deposit to 10");

		// Arrange - create a checking account using the parameterized constructor
		CheckingAccount ca = new CheckingAccount(0);
		// Act - deposit 10
		ca.deposit(10);
		// Act - withdraw 20
		ca.withdraw(20);
		// Assert - check that the balance is -10
		assertEquals(-10, ca.getBalance(), "Checking account overdraft to -10");

		/* EXCEPTIONS */
		// Test: create a new savings account and then immediately try to withdraw 10
		SavingsAccount sa = new SavingsAccount();
		boolean exceptionThrown = false;
		try {
			sa.withdraw(10);
		} catch (IllegalStateException ex) {
			exceptionThrown = true;
			System.out.println("PASS: Savings withdraw threw exception as expected: " + ex.getMessage());
		} catch (Exception ex) {
			exceptionThrown = true;
			System.out.println("PASS (unexpected exception type): " + ex);
		}
		if (!exceptionThrown) {
			System.out.println("FAIL: Savings withdraw did NOT throw when overdrawing");
		}

		/* PARAMETERIZED TEST */
		// For all iterations: create a new savings account and deposit 10.
		int[] withdrawValues = {0, 5, 10};
		for (int w : withdrawValues) {
			SavingsAccount s = new SavingsAccount();
			s.deposit(10);
			String testName = "Savings withdraw " + w + " -> balance " + (10 - w);
			try {
				s.withdraw(w);
				// If we reach here, withdrawal succeeded; check balance
				assertEquals(10 - w, s.getBalance(), testName);
			} catch (Exception ex) {
				System.out.println("FAIL: " + testName + " threw exception: " + ex.getMessage());
			}
		}

		System.out.println("Tests finished.");
	}
}
