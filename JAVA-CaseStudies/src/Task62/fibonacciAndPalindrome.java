package Task62;
import java.util.Scanner;
public class fibonacciAndPalindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to print the numebr of terms in Fibonaaci:  ");
		int num1 = sc.nextInt();
		
		// Fibonacci series
		int a = 0, b = 1;
		System.out.print("Fibonacci series up to " + num1 + ": ");
		while (a <= num1) {
			System.out.print(a + " ");
			int next = a + b;
			a = b;
			b = next;
		}
		
		System.out.println();
		
		// Palindrome check
		System.out.print("Enter a number to check if it is a palindrome: ");
		int num2 = sc.nextInt();
		int original =num2;
		int reverse=0;
		while(num2>0) {
			int digit=num2%10;
			reverse=reverse*10+digit;
			num2/=10;
		}
		if(original==reverse) {
			System.out.println(original+" is a palindrome.");
			}
			else {
				System.out.println(original+" is not a palindrome.");
			}
		sc.close();
	}
}
