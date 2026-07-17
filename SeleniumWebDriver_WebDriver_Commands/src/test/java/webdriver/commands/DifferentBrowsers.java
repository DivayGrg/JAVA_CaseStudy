package webdriver.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;
public class DifferentBrowsers {
WebDriver driver;
	@Parameters("browser")
	
	@BeforeMethod
	public void setup(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
	}
	
	@Test
	public void navigationTest() throws InterruptedException
	{
		driver.get("https://practicetestautomation.com/practice-test-login/");
		Thread.sleep(2000);
		driver.findElement(By.id("sumbit")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
