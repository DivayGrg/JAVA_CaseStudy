package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	public static WebDriver startBrowser(String browser, String url)
	{
		if(browser.equalsIgnoreCase("Chrome")|| browser.equalsIgnoreCase("GC")||browser.equalsIgnoreCase("Google Chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")|| browser.equalsIgnoreCase("EG")||browser.equalsIgnoreCase("Microsoft Edge")) 
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("FireFox")|| browser.equalsIgnoreCase("FF")||browser.equalsIgnoreCase("Mozilla Firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else 
		{
			System.out.print("Sorry we do not support this browser");
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
public static void closeBrowser(WebDriver driver)
{
	driver.quit();
}
}
