package Task73Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;
public class DifferentWebsitesChecking {
	WebDriver driver;
	String BaseURL="https://practicetestautomation.com/practice-test-login/";
	@Test
	public void IDLocator() {
		driver=new ChromeDriver();
		driver.navigate().to(BaseURL);
		driver.manage().window().maximize();
		
		//Locator ID Name and Xpath
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		String Title=driver.getTitle();
		String Message=driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
		if(Title.equals(Message))
		{
			System.out.println("The test case passed.");
		}
		else {
			System.out.println("The test case failed.");
		}
	}
	@Test
	public void saucelabs()
	{
		BaseURL="https://saucelabs.com/sign-up";
		driver=new ChromeDriver();
		driver.navigate().to(BaseURL);
		driver.manage().window().maximize();
		String Title=driver.getTitle();
		String CurrentUrl=driver.getCurrentUrl();
		String ExpectedUrl="https://saucelabs.com/sign-up";
		String ExpectedTitle="Sign Up for a Free Trial | Sauce Labs";
		if(Title.equals(ExpectedTitle))
		{
			System.out.println("Test Case has passed. Title does match.");
		}
		else
		{
			System.out.print("Test case has failed. Title doesn't match.");
		}
		if(CurrentUrl.equals(ExpectedUrl))
		{
			System.out.println("Test Case has passed. Url does match.");
		}
		else
		{
			System.out.println("Test case has failed. Url doesn't match.");
		}
	}
}
