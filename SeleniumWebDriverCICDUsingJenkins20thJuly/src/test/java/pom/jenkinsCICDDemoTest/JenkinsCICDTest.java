package pom.jenkinsCICDDemoTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class JenkinsCICDTest 
	{

@Test(priority=0)
public void ChromeBrowserTest()
{
	ChromeDriver driver=new ChromeDriver();
	String ExpectedTitle="Test Login | Practice Test Automation";
	String ExpectedBrowserURL="https://practicetestautomation.com/practice-test-login/";
	driver.get("https://practicetestautomation.com/practice-test-login/");
	driver.manage().window().maximize();
	String ActualTitle=driver.getTitle();
	System.out.println(ActualTitle);
	if(ActualTitle.equals(ExpectedTitle))
	{
		System.out.println("The test case has passed.The Actual Value Matches the Expected Value.");
	}
	else {
		System.out.println("The test case has failed. The Actual Value does not matches the Expected Value");
	}
	String ActualBrowserURL=driver.getCurrentUrl();
	System.out.println("The Current Url is : " + ActualBrowserURL);
	if(ActualBrowserURL.equals(ExpectedBrowserURL))
	{
		System.out.println("The test case has passed.The Actual URL Matches the Expected URL.");
	}
	else {
		System.out.println("The test case has failed. The Actual URL does not matches the Expected URL");
	}
//	String PagesSource=driver.getPageSource();
//	System.out.println("The Page Source : "+PagesSource);
	driver.quit();
}
@Test(priority=1)
public void EdgeBrowser()
{
	String ExpectedBrowserURL="https://mvnrepository.com/";
	String ExpectedTitle="Maven Repository: Search/Browse/Explore";
	EdgeDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://mvnrepository.com/");
	String ActualTitle=driver.getTitle();
	System.out.println(ActualTitle);
	if(ActualTitle.equals(ExpectedTitle))
	{
		System.out.println("The test case has passed.The Actual Value Matches the Expected Value.");
	}
	else {
		System.out.println("The test case has failed. The Actual Value does not matches the Expected Value");
	}
	String ActualBrowserURL=driver.getCurrentUrl();
	System.out.println("The Current Url is : " + ActualBrowserURL);
	if(ActualBrowserURL.equals(ExpectedBrowserURL))
	{
		System.out.println("The test case has passed.The Actual URL Matches the Expected URL.");
	}
	else {
		System.out.println("The test case has failed. The Actual URL does not matches the Expected URL");
	}
//	String BrowserTitle=driver.getTitle();
//	System.out.println(BrowserTitle);
//	String BrowserURL=driver.getCurrentUrl();
//	System.out.println("The Current Url is : " + BrowserURL);
//	String PagesSource=driver.getPageSource();
//	System.out.println("The Page Source : "+PagesSource);
	driver.quit();
					
}
@Test(priority=2)
public void FirefoxBrowser()
{
	String ExpectedBrowserURL="https://www.selenium.dev/";
	FirefoxDriver driver=new FirefoxDriver();
	 String ExpectedTitle="Selenium";
	driver.manage().window().maximize();
	driver.get("https://www.selenium.dev/");
	String ActualTitle=driver.getTitle();
	System.out.println(ActualTitle);
	if(ActualTitle.equals(ExpectedTitle))
	{
		System.out.println("The test case has passed.The Actual Value Matches the Expected Value.");
	}
	else {
		System.out.println("The test case has failed. The Actual Value does not matches the Expected Value");
	}
	String ActualBrowserURL=driver.getCurrentUrl();
	System.out.println("The Current Url is : " + ActualBrowserURL);
	if(ActualBrowserURL.equals(ExpectedBrowserURL))
	{
		System.out.println("The test case has passed.The Actual URL Matches the Expected URL.");
	}
	else {
		System.out.println("The test case has failed. The Actual URL does not matches the Expected URL");
	}
//	String BrowserTitle=driver.getTitle();
//	System.out.println(BrowserTitle);
//	String BrowserURL=driver.getCurrentUrl();
//	System.out.println("The Current Url is : " + BrowserURL);
//	String PagesSource=driver.getPageSource();
//	System.out.println("The Page Source : "+PagesSource);
	driver.quit();
//					
}

	@Test(priority=3)
	public void VitaminsSupplement() throws Exception
	{
		String BaseURL="https://www.hollandandbarrett.com/shop/vitamins-supplements/vitamins/";
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


//		@Test(priority=4)
//		public void navigationTest() throws InterruptedException
//		{
//			WebDriver driver;
//			driver=new ChromeDriver();
//			driver.get("https://practicetestautomation.com/practice-test-login/");
//			Thread.sleep(2000);
//			driver.findElement(By.id("sumbit")).click();
//			Thread.sleep(2000);
//			driver.navigate().back();
//			Thread.sleep(2000);
//			driver.navigate().forward();
//			Thread.sleep(2000);
//			driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
//			Thread.sleep(2000);
//			driver.navigate().refresh();
//			Thread.sleep(2000);
//			driver.quit();
//			
//		}
		
	@Test(priority=5)
	public void VitaminsLink() throws Exception
	{
		WebDriver driver;
		String BaseURL="https://www.hollandandbarrett.com";
		int total=0;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(BaseURL);
		
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		}
		catch(Exception e){
			System.out.println("Cookie popup not displayed");	
		}
		
		//driver.findElement(By.xpath("//a[contains(text(),'Vitamins & Supplements')]")).click();
		driver.findElement(By.linkText("Vitamins & Supplements")).click();
		List<WebElement> Links= driver.findElements(By .xpath("//a"));
		int linkCount=Links.size();
		total=total+Links.size();
		System.out.println("Number of Links :"+ linkCount);
		for(int i=0;i<Links.size();i++)
		{
			System.out.println(Links.get(i).getText());
		}
	}


	
	
	@Test(priority=6)
	public void DropDownList() throws Exception
	{
		WebDriver driver;
		String url="https://testautomationpractice.blogspot.com/";
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement Country_Dropdown=driver.findElement(By.id("country"));
		Select Country_list=new Select(Country_Dropdown);
		//selectByIndex()
		Country_list.selectByIndex(3);
		Thread.sleep(1000);
		
		//selectByVisibleText
		Country_list.selectByVisibleText("India");
		Thread.sleep(1000);
		
		//getFirstSelectedOption();
		WebElement option=Country_list.getFirstSelectedOption();
		String countryindex=option.getText();
		System.out.println(countryindex);
		
		//getOptions();
		List<WebElement> c_list =  Country_list.getOptions();
		int total_month=c_list.size();
		System.out.println("Total months count in List : " +total_month);
		for(WebElement e:c_list)
		{
			String coun_name=e.getText();
			System.out.println("Country Names in List : "+coun_name);
		}
		
	}

	@Test(priority=7)
	public void IDLocator() {
		WebDriver driver;
		String BaseURL="https://practicetestautomation.com/practice-test-login/";
		driver=new ChromeDriver();
		driver.navigate().to(BaseURL);
		driver.manage().window().maximize();
		
		//Locator ID Name and Xpath
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		String Title=driver.getTitle();
		String Message=driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
		if(Title.equals(Message))
		{
			System.out.println("The test case passed.");
		}
		else {
			System.out.println("The test case failed.");
		}
	}

 
	@Test(priority=8)
	public void iframe() throws Exception
	{
		WebDriver driver;
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

