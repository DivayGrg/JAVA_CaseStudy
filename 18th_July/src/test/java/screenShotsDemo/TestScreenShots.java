package screenShotsDemo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestScreenShots {
	@Test
	public void Browser() throws Exception{
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/campaign/landing.php");
		driver.manage().window().maximize();
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/FacebookHomepage.png"));
		System.out.println("Captured Screenshot");
		driver.quit();
	}

}
