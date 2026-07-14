package ExceptionHandling;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ExceptionsExampleTest {
	@Test
	public void catchANullPointerException() {
		Integer age = null;
		String ageAsString;
		try {
			ageAsString = age.toString();
		} catch(NullPointerException e) {
			age = 18;
			ageAsString = age.toString();
		}
		System.out.println(age);
		System.out.println("Age is: " + ageAsString);
		assertEquals("18", ageAsString);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
