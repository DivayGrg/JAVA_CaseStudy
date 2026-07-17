package com.SeleniumWebDriver.ChromeBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserTest {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://magicpin.in/");
		System.out.println("Page Titile is: "+ driver.getTitle());
		driver.quit();
	}

}
