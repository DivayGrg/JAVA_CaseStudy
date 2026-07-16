package Task72;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
public class TestScenario1 {
	WebDriver driver;
	@Test
	public void WebElementsCommands() throws Exception
	{
		driver=new ChromeDriver();
		driver.get("https://www.easycalculation.com/");
		driver.navigate().to("https://www.easycalculation.com/health/bmi-calculator.php");
		driver.findElement(By.xpath("//input[@name='wg']")).clear();
		driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("50");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@name='opt2']")).sendKeys("5");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@name='opt3']")).sendKeys("7");
		driver.findElement(By.xpath("//input[@name='wg']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@name='opt2']")).sendKeys("1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@name='opt3']")).sendKeys("0");
		Thread.sleep(1000);
		driver.quit();
	}


}
