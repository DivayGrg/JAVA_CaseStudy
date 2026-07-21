package Iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Iframes_MultipleFrame {
	WebDriver driver;
	@Test
	public void iframe() throws Exception
	{
		driver=new ChromeDriver();
		driver.get("file:///C:/Applications/eclipse/iFrames/iframe.html");
		Thread.sleep(1000);
		
		//count number of frames
		int TotalNoFrames= driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of Frames: "+TotalNoFrames);
		
		//switching to easycalculation
		driver.switchTo().frame("easycalculation");
		driver.get("https://www.login.hiox.com/login?referrer=easycalculation.com");
		driver.findElement(By.id("log_email")).sendKeys("9740673180");
		driver.findElement(By.id("log_password")).sendKeys("raghubn@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='log_submit']")).click();
		Thread.sleep(1000);
		String Title1=driver.getTitle();
		System.out.println("The Title is : "+ Title1);
		
		//practicetestautomation
		driver.navigate().to("file:///C:/Applications/eclipse/iFrames/iframe.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/a")).click();
		driver.navigate().to("https://www.selenium.dev/");
		driver.findElement(By.xpath("//span[normalize-space()='Documentation']")).click();
		Thread.sleep(2000);
		String Title2=driver.getTitle();
		System.out.println("The second title is :"+Title2);
		
		//PracticeAutomation
		driver.navigate().to("file:///C:/Applications/eclipse/iFrames/iframe.html");
		driver.switchTo().frame("My Store");
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		String Title3=driver.getTitle();
		System.out.println(Title3);
		Thread.sleep(2000);
		driver.quit();
		
		
			
	}
}

