package Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
public class Helper {
	
	
	public static void capturedScreenShot(WebDriver driver) throws Exception
	{
		try {
			TakesScreenshot ts= (TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			String path="./ScreenShots/"+getCurrentDateTime()+".png";
			FileUtils.copyFile(source, new File(path));
			
			byte[] screenshotBytes=ts.getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Screenshot on Failure", "image/png",new ByteArrayInputStream(screenshotBytes),".png");
			
			System.out.println("Captured ScreenShot - On Failure");
		} catch (Exception e) {
			System.out.println("Exception while Taking Screeen Shot"+e.getMessage());
	
		}
	}
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
	}

}

