package Task53;

public class Relational_Operators {

	public static void main(String[] args) {
		// Voting Eligibility Criteria Example
		int personAge = 22;
		int votingAge = 18;
		int seniorCitizenAge = 60;
		int retirementAge = 65;
		
		System.out.println("Voting & Age Verification");
		System.out.println("Person Age: " + personAge);
		System.out.println();
		
		
		System.out.println("1. Greater Than (>):");
		System.out.println("   Is person age > voting age? " + (personAge > votingAge));
		System.out.println("   " + personAge + " > " + votingAge + " = " + (personAge > votingAge));
		System.out.println();
		
		
		System.out.println("2. Greater Than or Equal To (>=):");
		System.out.println("   Is person age >= voting age? " + (personAge >= votingAge));
		System.out.println("   " + personAge + " >= " + votingAge + " = " + (personAge >= votingAge));
		System.out.println();
		
		
		System.out.println("3. Less Than (<):");
		System.out.println("   Is person age < senior citizen age? " + (personAge < seniorCitizenAge));
		System.out.println("   " + personAge + " < " + seniorCitizenAge + " = " + (personAge < seniorCitizenAge));
		System.out.println();
		
		
		System.out.println("4. Less Than or Equal To (<=):");
		System.out.println("   Is person age <= retirement age? " + (personAge <= retirementAge));
		System.out.println("   " + personAge + " <= " + retirementAge + " = " + (personAge <= retirementAge));
		System.out.println();
		
		
		System.out.println("5. Not Equal (!=):");
		System.out.println("   Is person age != voting age? " + (personAge != votingAge));
		System.out.println("   " + personAge + " != " + votingAge + " = " + (personAge != votingAge));
		System.out.println();
		
		
		System.out.println("6. Equal To (==):");
		System.out.println("   Is person age == voting age? " + (personAge == votingAge));
		System.out.println("   " + personAge + " == " + votingAge + " = " + (personAge == votingAge));
		System.out.println();
		
		// Voting Eligibility Result
		System.out.println("=== Result ===");
		if (personAge >= votingAge && personAge != votingAge) {
			System.out.println("Person is ELIGIBLE to vote!");
		} else {
			System.out.println("Person is NOT eligible to vote!");
		}
	}

}
