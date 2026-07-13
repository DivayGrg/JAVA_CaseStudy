package Task53;

public class Logical_Operators {

	public static void main(String[] args) {
		int age=25;
		double income=50000;
		boolean hasCriminalRecord=false;
		boolean hasGoodCreditScore=true;
		
		
		boolean ageAndIncomeCheck = (age >= 18 && income >= 30000);
		
		boolean creditOrIncomeCheck = (hasGoodCreditScore || income >= 40000);
		
		boolean noCriminalRecordCheck = !hasCriminalRecord;
		
		if(ageAndIncomeCheck && creditOrIncomeCheck && noCriminalRecordCheck) {
			System.out.println("Eligible for loan approval.");
		} else {
			System.out.println("Not eligible for loan approval.");
		}
	}

}
