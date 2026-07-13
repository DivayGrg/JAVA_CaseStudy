package constructors;
class Student{
	String name;
	int age;
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}
	
}
public class ConstructionDemo {
public static void main(String[] args) {
	//Creating object of class
	Student obj = new Student();
	//Calling method
	obj.display();
}
}