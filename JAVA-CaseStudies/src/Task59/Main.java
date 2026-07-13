package Task59;
interface FirstInterface {
	void myMethod();
}
interface SecondInterface {
	void myOtherMethod();
}
class DemoClass implements FirstInterface, SecondInterface {
	public void myMethod() {
		System.out.println("Some text..");
	}
	public void myOtherMethod() {
		System.out.println("Some other text...");
	}
}
public class Main {
public static void main(String[] args) {
	DemoClass obj = new DemoClass();
	obj.myMethod();
	obj.myOtherMethod();

}
}
