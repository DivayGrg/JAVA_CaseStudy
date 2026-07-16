package com.SeleniumWebDriver.Locators.Demo;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;
public class IDNameXpath {
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
}
