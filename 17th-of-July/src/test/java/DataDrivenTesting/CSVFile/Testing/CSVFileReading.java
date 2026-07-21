
package DataDrivenTesting.CSVFile.Testing;

import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import au.com.bytecode.opencsv.CSVReader;


public class CSVFileReading {
	String CsvPath="C:/Applications/eclipse/17th-of-July/CSVFileReading/dummy_data.csv/";
	WebDriver driver;
	@BeforeTest
	public void setup() throws Exception
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://only-testing-blog.blogspot.com/2014/05/form.html");
		
	}
	@Test
	public void DDTestingBlog() throws Exception{
		CSVReader reader=new CSVReader(new FileReader (CsvPath));
		String[] csvCell;
		while((csvCell =reader.readNext())!=null)
		{
			String FName=csvCell[0];
			String LName=csvCell[1];
			String CName=csvCell[2];
			String MNumb=csvCell[3];
			String Email=csvCell[4];
			driver.findElement(By.name("FirstName")).sendKeys(FName);
			driver.findElement(By.name("LastName")).sendKeys(LName);
			driver.findElement(By.name("EmailID")).sendKeys(Email);
			driver.findElement(By.name("MobNo")).sendKeys(MNumb);
			driver.findElement(By.name("Company")).sendKeys(CName);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			
		}
		reader.close();
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
