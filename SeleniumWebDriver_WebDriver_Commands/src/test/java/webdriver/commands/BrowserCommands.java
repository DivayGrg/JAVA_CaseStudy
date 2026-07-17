package webdriver.commands;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;

public class BrowserCommands {
@Test(priority=0)
public void ChromeBrowserTest()
{
	ChromeDriver driver=new ChromeDriver();
	String ExpectedTitle="Test Login | Practice Test Automation";
	String ExpectedBrowserURL="https://practicetestautomation.com/practice-test-login/";
	driver.get("https://practicetestautomation.com/practice-test-login/");
	driver.manage().window().maximize();
	String ActualTitle=driver.getTitle();
	System.out.println(ActualTitle);
	if(ActualTitle.equals(ExpectedTitle))
	{
		System.out.println("The test case has passed.The Actual Value Matches the Expected Value.");
	}
	else {
		System.out.println("The test case has failed. The Actual Value does not matches the Expected Value");
	}
	String ActualBrowserURL=driver.getCurrentUrl();
	System.out.println("The Current Url is : " + ActualBrowserURL);
	if(ActualBrowserURL.equals(ExpectedBrowserURL))
	{
		System.out.println("The test case has passed.The Actual URL Matches the Expected URL.");
	}
	else {
		System.out.println("The test case has failed. The Actual URL does not matches the Expected URL");
	}
//	String PagesSource=driver.getPageSource();
//	System.out.println("The Page Source : "+PagesSource);
	driver.quit();
	
}
@Test(priority=1)
public void EdgeBrowser()
{
	String ExpectedBrowserURL="https://mvnrepository.com/";
	String ExpectedTitle="Maven Repository: Search/Browse/Explore";
	EdgeDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://mvnrepository.com/");
	String ActualTitle=driver.getTitle();
	System.out.println(ActualTitle);
	if(ActualTitle.equals(ExpectedTitle))
	{
		System.out.println("The test case has passed.The Actual Value Matches the Expected Value.");
	}
	else {
		System.out.println("The test case has failed. The Actual Value does not matches the Expected Value");
	}
	String ActualBrowserURL=driver.getCurrentUrl();
	System.out.println("The Current Url is : " + ActualBrowserURL);
	if(ActualBrowserURL.equals(ExpectedBrowserURL))
	{
		System.out.println("The test case has passed.The Actual URL Matches the Expected URL.");
	}
	else {
		System.out.println("The test case has failed. The Actual URL does not matches the Expected URL");
	}
//	String BrowserTitle=driver.getTitle();
//	System.out.println(BrowserTitle);
//	String BrowserURL=driver.getCurrentUrl();
//	System.out.println("The Current Url is : " + BrowserURL);
//	String PagesSource=driver.getPageSource();
//	System.out.println("The Page Source : "+PagesSource);
	driver.quit();
					
}
@Test(priority=2)
public void FirefoxBrowser()
{
	String ExpectedBrowserURL="https://www.selenium.dev/";
	FirefoxDriver driver=new FirefoxDriver();
	 String ExpectedTitle="Selenium";
	driver.manage().window().maximize();
	driver.get("https://www.selenium.dev/");
	String ActualTitle=driver.getTitle();
	System.out.println(ActualTitle);
	if(ActualTitle.equals(ExpectedTitle))
	{
		System.out.println("The test case has passed.The Actual Value Matches the Expected Value.");
	}
	else {
		System.out.println("The test case has failed. The Actual Value does not matches the Expected Value");
	}
	String ActualBrowserURL=driver.getCurrentUrl();
	System.out.println("The Current Url is : " + ActualBrowserURL);
	if(ActualBrowserURL.equals(ExpectedBrowserURL))
	{
		System.out.println("The test case has passed.The Actual URL Matches the Expected URL.");
	}
	else {
		System.out.println("The test case has failed. The Actual URL does not matches the Expected URL");
	}
//	String BrowserTitle=driver.getTitle();
//	System.out.println(BrowserTitle);
//	String BrowserURL=driver.getCurrentUrl();
//	System.out.println("The Current Url is : " + BrowserURL);
//	String PagesSource=driver.getPageSource();
//	System.out.println("The Page Source : "+PagesSource);
	driver.quit();
//					
}

}
