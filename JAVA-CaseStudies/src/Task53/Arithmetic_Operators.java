package Task53;

public class Arithmetic_Operators {

	public static void main(String[] args) {
		// E-commerce Example: Laptop Purchase
		int laptopPrice = 50000;
		int quantity = 2;
		
		// Addition: Total Price
		//int totalPrice = laptopPrice + laptopPrice;
		System.out.println(" E-Commerce Arithmetic Operations ");
		System.out.println("Laptop Price: rs" + laptopPrice);
		System.out.println("Quantity: " + quantity);
		System.out.println();
		
		// Addition
		int addition = laptopPrice + laptopPrice;
		System.out.println("1. Addition (Price + Price): rs" + laptopPrice + " + rs" + laptopPrice + " = rs" + addition);
		
		// Multiplication
		int multiplication = laptopPrice * quantity;
		System.out.println("2. Multiplication (Price × Quantity): rs" + laptopPrice + " × " + quantity + " = rs" + multiplication);
		
		// Subtraction:
		int subtraction = multiplication - laptopPrice;
		System.out.println("3. Subtraction (Total - One Item): rs" + multiplication + " - rs" + laptopPrice + " = rs" + subtraction);
		
		// Division:
		int division = multiplication / quantity;
		System.out.println("4. Division (Total ÷ Quantity): rs" + multiplication + " ÷ " + quantity + " = rs" + division);
		
		// Modulus:
		int modulus = multiplication % 3;
		System.out.println("5. Modulus (Total % 3): rs" + multiplication + " % 3 = rs" + modulus);
	}

}
