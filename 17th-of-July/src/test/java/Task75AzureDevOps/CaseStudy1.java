package Task75AzureDevOps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CaseStudy1 {
	WebDriver driver;
	@Test
	public void facebook() throws Exception
	{
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/reg/?entry_point=login&next=");
		Thread.sleep(5000);
		
		WebElement day=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/label[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
		WebElement Month=driver.findElement(By.xpath("(//*[name()='svg'][@class='x1lliihq x2lah0s x1k90msu x2h7rmj x1qfuztq x198g3q0 xxk0z11 xvy4d1p'])[3]"));
		WebElement Year=driver.findElement(By.xpath("(//*[name()='svg'][@class='x1lliihq x2lah0s x1k90msu x2h7rmj x1qfuztq x198g3q0 xxk0z11 xvy4d1p'])[4]"));
		System.out.println("sheit");
		
		Select day_list= new Select(day);
		Select Month_list= new Select(Month);
		Select Year_list= new Select(Year);
		 
		List<WebElement> d_list =  day_list.getOptions();
		List<WebElement> m_list =  Month_list.getOptions();
		List<WebElement> y_list =  Year_list.getOptions();
		int total_days=d_list.size();
		int total_months=m_list.size();
		int total_years=y_list.size();
		System.out.println("Total days count in List : " +total_days);
		for(WebElement e:d_list)
		{
			String name=e.getText();
			System.out.println("Month Names in List : "+name);
		}
		System.out.println("Total months count in List : " +total_months);
		
		
		for(WebElement e:m_list)
		{
			String name=e.getText();
			System.out.println("Month Names in List : "+name);
		}
		System.out.println("Total years count in List : " +total_years);
		
		
		for(WebElement e:y_list)
		{
			String name=e.getText();
			System.out.println("Years Names in List : "+name);
		}
	}

}
