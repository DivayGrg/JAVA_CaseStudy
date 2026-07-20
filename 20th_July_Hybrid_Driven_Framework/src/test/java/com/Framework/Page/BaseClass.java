package com.Framework.Page;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import Utility.BrowserFactory;
import Utility.ConfigDataProvider;
import Utility.ExcelDataReader;
import Utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataReader excel;
	public ConfigDataProvider config;
	@BeforeSuite
	public void SetUp() {
		excel = new ExcelDataReader();
		config =new ConfigDataProvider();
	}
	@BeforeClass
	public void BrowserTest()
	{
		driver=BrowserFactory.startBrowser(driver, config.getBrowser(),config.getUrl());
	}
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.capturedScreenShot(driver);
		}
	}
	
}
