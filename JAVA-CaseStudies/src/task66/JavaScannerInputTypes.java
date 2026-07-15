package task66;
import java.util.Scanner;
public class JavaScannerInputTypes {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// nextBoolean() - Reading Boolean value
		System.out.print("Enter a boolean value (true/false): ");
		boolean boolValue = input.nextBoolean();
		System.out.println("Boolean entered: " + boolValue);
		
		// nextByte() - Reading Byte value
		System.out.print("Enter a byte value (-128 to 127): ");
		byte byteValue = input.nextByte();
		System.out.println("Byte entered: " + byteValue);
		System.out.print("Enter a double value: ");
		double doubleValue = input.nextDouble();
		System.out.println("Double entered: " + doubleValue);
		
		// nextFloat() - Reading Float value
		System.out.print("Enter a float value: ");
		float floatValue = input.nextFloat();
		System.out.println("Float entered: " + floatValue);
		
		// nextInt() - Reading Int value
		System.out.print("Enter an integer value: ");
		int intValue = input.nextInt();
		System.out.println("Integer entered: " + intValue);
		// nextLong() - Reading Long value
		System.out.print("Enter a long value: ");
		long longValue = input.nextLong();
		System.out.println("Long entered: " + longValue);
				
		// nextShort() - Reading Short value
		System.out.print("Enter a short value (-32768 to 32767): ");
		short shortValue = input.nextShort();
		System.out.println("Short entered: " + shortValue);
				
		// nextLine() - Reading Line value (String)
		// Note: Add nextLine() to consume the leftover newline
		input.nextLine();
		System.out.print("Enter a line of text: ");
		String lineValue = input.nextLine();
System.out.println("Line entered: " + lineValue);
		
		// Display summary
		System.out.println("\n========== Summary ==========");
		System.out.println("Boolean: " + boolValue);
		System.out.println("Byte: " + byteValue);
		System.out.println("Double: " + doubleValue);
		System.out.println("Float: " + floatValue);
		System.out.println("Integer: " + intValue);
		System.out.println("Long: " + longValue);
		System.out.println("Short: " + shortValue);
		System.out.println("Line: " + lineValue);
		
		input.close();
	}
}
