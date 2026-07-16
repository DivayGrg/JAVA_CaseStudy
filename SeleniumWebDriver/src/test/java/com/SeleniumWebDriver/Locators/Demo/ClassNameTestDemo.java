package com.SeleniumWebDriver.Locators.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ClassNameTestDemo {
	
	String BaseURL="https://www.hollandandbarrett.com/shop/vitamins-supplements/vitamins/";
	@Test
	public void VitaminsSupplement() throws Exception
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(BaseURL);
		
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		}
		catch(Exception e){
			System.out.println("Cookie popup not displayed");	
		}
		driver.findElement(By.xpath("//img[@alt='Vitamin Drinks category product example']")).click();
		driver.findElement(By.className("ProductCardImage-module_innerImage__2kx-2")).click();
		String BrowserTitle=driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		
		driver.navigate().back();
		BrowserTitle=driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		
		driver.navigate().refresh();
		BrowserTitle=driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		
		driver.navigate().forward();
		BrowserTitle=driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		driver.quit();
		
	}

}
