package Task72;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class TestScnario2 {
	WebDriver driver;
	@Test
	public void WebElementsCommands()
	{
		driver=new ChromeDriver();
		driver.get("https://www.easycalculation.com/");
		WebElement GoogleSearch=driver.findElement(By.id("googleSearchId"));
		boolean display=GoogleSearch.isDisplayed();
		if(display==true) {
			System.out.println("The googleSearch is being Displayed");
		}
		else
		{
			System.out.println("The googleSearch is not being Displayed");
		}
		driver.quit();
	}

}
