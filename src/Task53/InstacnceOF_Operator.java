package Task53;
class Vehicle {
	// Vehicle properties and methods
}
class Car extends Vehicle {
	// Car specific properties and methods
}
class Bike extends Vehicle {
	// Bike specific properties and methods
}

public class InstacnceOF_Operator {

	public static void main(String[] args) {
		Vehicle v1=new Car();
		Vehicle v2=new Bike();
		if(v1 instanceof Car) {
			System.out.println("v1 is an instance of Car");
		}
		if(v2 instanceof Bike) {
			System.out.println("v2 is an instance of Bike");
		}
		if(v1 instanceof Vehicle) {
			System.out.println("v1 is an instance of Vehicle");
		}

	}

}
