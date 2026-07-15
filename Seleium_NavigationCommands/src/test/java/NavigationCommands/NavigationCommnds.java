package NavigationCommands;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.*;


public class NavigationCommnds {

@Test
public void EdgeTest() {
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://www.google.com");
		String URL=driver.getCurrentUrl();
		System.out.println("The Current URL is : "+ URL);
		String	Title=driver.getTitle();
		
		
		//navigate()
		System.out.println("The title is: "+ Title);
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		URL=driver.getCurrentUrl();
		System.out.println("The Current URL is : "+ URL);
		
		//navigate().back()
		driver.navigate().back();
		URL=driver.getCurrentUrl();
		System.out.println("The Current URL is : "+ URL);
		
		
		//navigate().forward()
		driver.navigate().forward();
		URL=driver.getCurrentUrl();
		System.out.println("The Current URL is : "+ URL);
		
		//navigate().to()
		driver.navigate().to("https://practicetestautomation.com/");
		URL=driver.getCurrentUrl();
		System.out.println("The Current URL is : "+ URL);
		
		//navigate().refresh()
		driver.navigate().refresh();
		URL=driver.getCurrentUrl();
		System.out.println("The Current URL is : "+ URL);
		driver.quit();
}
@Test
public void ChromeTest()
{
	ChromeDriver driver1=new ChromeDriver();
	driver1.get("https://www.google.com");
	String URL=driver1.getCurrentUrl();
	System.out.println("The Current URL is : "+ URL);
	String	Title=driver1.getTitle();
	System.out.println("The title is: "+ Title);
	
	//navigate()
	driver1.navigate().to("https://practicetestautomation.com/practice-test-login/");
	URL=driver1.getCurrentUrl();
	System.out.println("The Current URL is : "+ URL);
	
	//navigate().back()
	driver1.navigate().back();
	URL=driver1.getCurrentUrl();
	System.out.println("The Current URL is : "+ URL);
	
	//navigate().forward()
	driver1.navigate().forward();
	URL=driver1.getCurrentUrl();
	System.out.println("The Current URL is : "+ URL);
	
	//navigate().to()
	driver1.navigate().to("https://practicetestautomation.com/");
	URL=driver1.getCurrentUrl();
	System.out.println("The Current URL is : "+ URL);
	
	
	//navigate().refresh()
	driver1.navigate().refresh();
	URL=driver1.getCurrentUrl();
	System.out.println("The Current URL is : "+ URL);
	driver1.quit();
}
@Test
public void FirefoxTest()
{
	FirefoxDriver driver2=new FirefoxDriver();
	driver2.get("https://www.google.com");
	String URL=driver2.getCurrentUrl();
	System.out.println("The Current URL is : "+ URL);
	String	Title=driver2.getTitle();
	System.out.println("The title is: "+ Title);
	
	//navigate()
	
	driver2.navigate().to("https://practicetestautomation.com/practice-test-login/");
	URL=driver2.getCurrentUrl();
	System.out.println("The Current URL is : "+ URL);
	
	//navigate().back()
	driver2.navigate().back();
	URL=driver2.getCurrentUrl();
	System.out.println("The Current URL is : "+ URL);
	
	//navigate().forward()
	driver2.navigate().forward();
	URL=driver2.getCurrentUrl();
	System.out.println("The Current URL is : "+ URL);
	
	//navigate().to()
		driver2.navigate().to("https://practicetestautomation.com/");
		URL=driver2.getCurrentUrl();
		System.out.println("The Current URL is : "+ URL);
	
	//navigate().refresh()
	driver2.navigate().refresh();
	URL=driver2.getCurrentUrl();
	System.out.println("The Current URL is : "+ URL);
	driver2.quit();
}
}
