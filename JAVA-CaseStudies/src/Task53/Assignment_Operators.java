package Task53;

public class Assignment_Operators {
	public static void main(String args[]) {
		int balance = 50000;
		System.out.println("E-Commerce Assignment Operations");
		System.out.println("Initial Balance: rs" + balance);
		System.out.println();
		
		System.out.println("Deposits: rs" + 500);
		balance += 500;
		System.out.println("Balance after deposit (+=): rs" + balance);
		System.out.println();
		
		System.out.println("Withdrawals: rs" + 2000);
		balance -= 2000;
		System.out.println("Balance after withdrawal (-=): rs" + balance);
		System.out.println();
		
		System.out.println("Multiply balance by 2 (*=)");
		balance *= 2;
		System.out.println("Balance after multiply and assign: rs" + balance);
		System.out.println();
		
		System.out.println("Divide balance by 3 (/=)");
		balance /= 3;
		System.out.println("Balance after divide and assign: rs" + balance);
		System.out.println();
		
		System.out.println("Modulus balance by 7 (%=)");
		balance %= 7;
		System.out.println("Balance after modulus and assign: rs" + balance);
	}

}
