package task61;

public class Account {

    public enum AccountType { CHECKING, SAVINGS }

    private int balance; // whole euros
    private int accountNumber;
    private AccountType type;

    // No-arg constructor with default values
    public Account() {
        this(0, 12345, AccountType.CHECKING);
    }

    // Parameterized constructor
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
            // For savings, do not allow overdraft - throw exception
            throw new ArithmeticException("Overdrawing a savings account is not allowed");
        }
        // For checking accounts, overdraft allowed
        this.balance = resulting;
    }

    @Override
    public String toString() {
        return String.format("The account with number %d is of type '%s' and has a balance of %d",
                this.accountNumber, this.type, this.balance);
    }

}
