package com.Framework.TestCase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Framework.Page.BaseClass;
import com.Framework.Page.LoginPage;

import Utility.ExcelDataReader;

public class LoginEasyCalculation extends BaseClass {
	@Test
	public void loginApp() throws Exception {
		ExcelDataReader excel = new ExcelDataReader();
		excel.getStringData("LoginEC", 0, 0);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.login_EasyCal(excel.getStringData("LoginEC", 0, 0), excel.getStringData("LoginEC", 0, 1));
		Thread.sleep(10000);
	}
}
