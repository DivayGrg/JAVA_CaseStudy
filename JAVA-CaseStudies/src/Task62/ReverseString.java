package Task62;
import java.util.*;
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string to reverse: ");
		String str = sc.nextLine();
		int length = str.length();
		String reversedStr = "";
		for(int i = length - 1; i >= 0; i--) {
			reversedStr += str.charAt(i);
		}
		System.out.println("Reversed string: " + reversedStr);
		sc.close();
	}

}
