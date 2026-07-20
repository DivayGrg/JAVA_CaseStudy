package library;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Reusability {
	
	
	public static void capturedScreenShot(WebDriver driver, String screenShotName) throws Exception
	{
		try {
			TakesScreenshot ts= (TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			String path="./ScreenShots/"+screenShotName+".png";
			FileUtils.copyFile(source, new File(path));
			System.out.println(screenShotName);
		} catch (Exception e) {
			System.out.println("Exception while Taking Screeen Shot"+e.getMessage());
	
		}
	}

}
