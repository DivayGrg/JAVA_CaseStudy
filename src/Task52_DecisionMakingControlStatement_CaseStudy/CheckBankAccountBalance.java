package Task52_DecisionMakingControlStatement_CaseStudy;

public class CheckBankAccountBalance {

	public static void main(String[] args) {
		// Demonstration program using nested if statements (no user input)
		// Uses hard-coded (dummy) data to check voting eligibility.

		int[] testAges = { -5, 0, 15, 17, 18, 30, 121 };
		boolean[] citizenStatus = { true, false };

		System.out.println("=== Voting Eligibility Tests (using nested if statements) ===");

		for (int age : testAges) {
			for (boolean isCitizen : citizenStatus) {
				System.out.print("Age=" + age + ", Citizen=" + isCitizen + " => ");

				// First-level validation
				if (age < 0) {
					System.out.println("Invalid age (negative).");
				} else {
					// Optional sanity check for unrealistic age
					if (age > 120) {
						System.out.println("Unrealistic age.");
					} else {
						// Outer if: check if age meets minimum voting age
						if (age >= 18) {
							// Nested if: check citizenship requirement
							if (isCitizen) {
								System.out.println("Eligible to vote.");
							} else {
								System.out.println("Not eligible: must be a citizen to vote.");
							}
						} else {
							// Nested if inside the else branch (example of nested if usage)
							if (age >= 16) {
								System.out.println("Not eligible yet: teen below voting age (18).");
							} else {
								System.out.println("Not eligible: under minimum voting age.");
							}
						}
					}
				}
			}
		}
	}

}
