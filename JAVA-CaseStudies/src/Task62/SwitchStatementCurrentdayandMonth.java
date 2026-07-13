package Task62;
import java.util.Scanner;
public class SwitchStatementCurrentdayandMonth {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Get day and month from user
		System.out.print("Enter day (1-7, where 1=Sunday): ");
		int dayOfWeek = sc.nextInt();
		
		System.out.print("Enter month (1-12): ");
		int month = sc.nextInt();
		
		// Switch statement for day of week
		String dayName = "";
		switch(dayOfWeek) {
			case 1:
				dayName = "Sunday";
				break;
			case 2:
				dayName = "Monday";
				break;
			case 3:
				dayName = "Tuesday";
				break;
			case 4:
				dayName = "Wednesday";
				break;
			case 5:
				dayName = "Thursday";
				break;
			case 6:
				dayName = "Friday";
				break;
			case 7:
				dayName = "Saturday";
				break;
			default:
				dayName = "Invalid day";
		}
		
		// Switch statement for month
		String monthName = "";
		switch(month) {
			case 1:
				monthName = "January";
				break;
			case 2:
				monthName = "February";
				break;
			case 3:
				monthName = "March";
				break;
			case 4:
				monthName = "April";
				break;
			case 5:
				monthName = "May";
				break;
			case 6:
				monthName = "June";
				break;
			case 7:
				monthName = "July";
				break;
			case 8:
				monthName = "August";
				break;
			case 9:
				monthName = "September";
				break;
			case 10:
				monthName = "October";
				break;
			case 11:
				monthName = "November";
				break;
			case 12:
				monthName = "December";
				break;
			default:
				monthName = "Invalid month";
		}
		
		// Print the day and month
		System.out.println("\nDay: " + dayName);
		System.out.println("Month: " + monthName);
		
		sc.close();
	}

}
