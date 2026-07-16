package com.SeleniumDriver.Alerts;
import org.openqa.selenium.chrome.*;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Reusability.Helper;
public class JavaScriptAlerts{
	@Test
	public void TestPopups() throws Exception{
		WebDriver driver=Helper.startBrowser("Chrome");
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		String result = driver.findElement(By.cssSelector("#result")).getText();
		System.out.println(result);
		Assert.assertEquals("You successfully clicked an alert", result);
		
		Thread.sleep(1000);
		//confirm() alert
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(1000);
		Alert alert2=driver.switchTo().alert();
		alert2.dismiss();
		Thread.sleep(1000);
		String result2=driver.findElement(By.cssSelector("#result")).getText();
		System.out.println(result2);
		Assert.assertEquals("You clicked: Cancel", result2);
		
		//confirm() alert accept
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(1000);
		Alert alert3=driver.switchTo().alert();
		alert3.accept();
		Thread.sleep(1000);
		String result3=driver.findElement(By.cssSelector("#result")).getText();
		System.out.println(result3);
		Assert.assertEquals("You clicked: Ok", result3);
		
		
		//alert prompt()
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Thread.sleep(1000);
		Alert alert4=driver.switchTo().alert();
		alert4.sendKeys("Hello Everyone");
		Thread.sleep(1000);
		alert4.accept();
		String result4=driver.findElement(By.cssSelector("#result")).getText();
		System.out.println(result4);
		Assert.assertEquals("You entered: Hello Everyone", result4);
		
		//
		driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String result5= driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText();
		Thread.sleep(8000);
		System.out.println("result5");
		Assert.assertEquals("Congratulations! You must have the proper credentials.", result5);
	}
}
