package Task75AzureDevOps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class spicejet5thelement {
	@Test
	public void spicejet() throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[5]/div[2]/div[2]/div[2]/div[1]/div[5]/div[1]")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
