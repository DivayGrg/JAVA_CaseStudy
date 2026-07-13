package Task62;
import java.util.Scanner;
public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to check if it is prime or not: ");
		int num = sc.nextInt();
		boolean isPrime = true;
		for(int i = 2; i <= num/2; i++) {
			if(num % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.println(num + " is " + (isPrime ? "a prime number" : "not a prime number"));
		sc.close();
	}

}
