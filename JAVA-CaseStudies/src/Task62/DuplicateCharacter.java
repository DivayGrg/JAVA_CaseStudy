package Task62;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCharacter {

	public static void main(String[] args) {
		System.out.println("Enter a string to check for duplicate characters:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		// Use LinkedHashMap to preserve insertion order
		Map<Character, Integer> freq = new LinkedHashMap<>();
		for (char c : input.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		
		boolean found = false;
		System.out.println("Duplicate characters and their counts:");
		for (Map.Entry<Character, Integer> e : freq.entrySet()) {
			if (e.getValue() > 1) {
				char ch = e.getKey();
				String printable = (ch == ' ') ? "(space)" : String.valueOf(ch);
				System.out.println(printable + " : " + e.getValue());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No duplicate characters found.");
		}
		sc.close();
	}

}
