package webdriver.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.*;
import org.testng.annotations.*;
public class FindElementByLinks {
	WebDriver driver;
	String BaseURL="https://www.hollandandbarrett.com";
	int total=0;
	
	@BeforeTest
	public void VitaminsSupplement() throws Exception
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(BaseURL);
		
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		}
		catch(Exception e){
			System.out.println("Cookie popup not displayed");	
		}
	}
	@Test
	public void VitaminsLink() throws Exception
	{
		
		//driver.findElement(By.xpath("//a[contains(text(),'Vitamins & Supplements')]")).click();
		driver.findElement(By.linkText("Vitamins & Supplements")).click();
		List<WebElement> Links= driver.findElements(By .xpath("//a"));
		int linkCount=Links.size();
		total=total+Links.size();
		System.out.println("Number of Links :"+ linkCount);
		for(int i=0;i<Links.size();i++)
		{
			System.out.println(Links.get(i).getText());
		}
	}
}
