package SpiceJetScroll;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
public class SpiceJetScroll {
public class TestScrollUpandDown{
	WebDriver driver;
	String url="https://www.spicejet.com/";
	@Test
	public void Test() throws Exception{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,6600)");
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-4200)", " ");
		}
	
}
}
