package DropDownElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;



public class Handling_DropDown {
	WebDriver driver;
	String url="https://testautomationpractice.blogspot.com/";
	
	@BeforeTest
	public void SetUp()
	{
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void DropDownList() throws Exception
	{
		WebElement Country_Dropdown=driver.findElement(By.id("country"));
		Select Country_list=new Select(Country_Dropdown);
		//selectByIndex()
		Country_list.selectByIndex(3);
		Thread.sleep(1000);
		
		//selectByVisibleText
		Country_list.selectByVisibleText("India");
		Thread.sleep(1000);
		
		//getFirstSelectedOption();
		WebElement option=Country_list.getFirstSelectedOption();
		String countryindex=option.getText();
		System.out.println(countryindex);
		
		//getOptions();
		List<WebElement> c_list =  Country_list.getOptions();
		int total_month=c_list.size();
		System.out.println("Total months count in List : " +total_month);
		for(WebElement e:c_list)
		{
			String coun_name=e.getText();
			System.out.println("Country Names in List : "+coun_name);
		}
		
	}
}
