package MouseHandOer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseOverElements {
	int linkCount;
	List<WebElement> list;
	@Test
	public void mouseover() throws Exception 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.easycalculation.com/");
		
		WebElement ele=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[9]/a[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
		
		list =driver.findElements(By.tagName("a"));
		System.out.println("Number if a links-- :"+list.size());
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
		}
		Thread.sleep(2000);
		
		WebElement ele2=driver.findElement(By.xpath("(//a[normalize-space()='Dictionary'])[1]"));
		ele2.click();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
}
