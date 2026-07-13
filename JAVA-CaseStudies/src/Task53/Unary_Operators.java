package Task53;

public class Unary_Operators {
public static void main(String args[])
{
	int balance=1000;
	boolean accountActive=true;
	//Unary plus operator (just shows positive);
	System.out.println("Balance: "+(+balance));
	//Unary minus operator (shows negative);
	System.out.println("Balance: "+(-balance));
	//Increment operator (deposits money)
	balance++; //balance=balance+1
	System.out.println("Balance after deposit: "+balance);
	//Decrement operator (withdraws money)
	balance--; //balance=balance-1
	System.out.println("Balance after withdrawal: "+balance);
	//Logical NOT operator (checks if account is inactive)
	System.out.println("Is account inactive? "+(!accountActive));
	
	//bitwise complement operator (flips bits of balance)
	int code=5;
	System.out.println("Bitwise complement of 5:: "+ ~code);
}
}
