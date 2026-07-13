package Constructors;
//WAP in java using constructors setter and getter methods for Employee having id, name, salary
class Employee{
	private int id;
	private String name;
	private float salary;
	private String ssn;
	// No-arg constructor
	public Employee() {
	}

	// Parameterized constructor to match usage in main
	public Employee(int id, String name, float salary, String ssn) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.ssn = ssn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + ", ssn='" + ssn + "'}";
	}
	
	
}
	
public class ConstructorsUsingGettersAndSetters {
	

	public static void main(String[] args) {
		// create employee using parameterized constructor
		Employee emp = new Employee(12, "Divay Garg", 12000f, "126376");
		// Print using toString()
		System.out.println("Using toString: " + emp);
		// Print details using getters
		System.out.println("Details via getters:");
		System.out.println("ID: " + emp.getId());
		System.out.println("Name: " + emp.getName());
		System.out.println("Salary: " + emp.getSalary());
		System.out.println("SSN: " + emp.getSsn());
		// Update salary using setter
		emp.setSalary(15000f);
		System.out.println("\nAfter salary update:");
		System.out.println("Salary: " + emp.getSalary());
		// Print whole object again
		System.out.println(emp);

	}

}
