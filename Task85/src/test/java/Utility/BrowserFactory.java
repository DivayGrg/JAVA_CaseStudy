package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	public static WebDriver startBrowser(WebDriver driver,String browserName, String AppUrl)
	{
		if(browserName.equalsIgnoreCase("Chrome")|| browserName.equalsIgnoreCase("GC")||browserName.equalsIgnoreCase("Google Chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")|| browserName.equalsIgnoreCase("EG")||browserName.equalsIgnoreCase("Microsoft Edge")) 
		{
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("FireFox")|| browserName.equalsIgnoreCase("FF")||browserName.equalsIgnoreCase("Mozilla Firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else 
		{
			System.out.print("Sorry we do not support this browser");
		}
		driver.manage().window().maximize();
		driver.get(AppUrl);
		return driver;
	}
public static void closeBrowser(WebDriver driver)
{
	driver.quit();
}
}
