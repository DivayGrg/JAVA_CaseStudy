package com.SeleniumWebDriver.EdgeBrowser;
import org.openqa.selenium.edge.EdgeDriver;
public class EdgeBrowserTest {
public static void main(String[] args) {
		
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();//minimmize();
	}
}
