package com.Framework.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "log_email")
	WebElement Email;

	@FindBy(how = How.ID, using = "log_password")
	WebElement Password;

	@FindBy(how = How.XPATH, using = "//input[@id='log_password']")
	WebElement BtnLogin;

	// Creating and assigning values
	public void login_EasyCal(String uname, String pass) {
		Email.sendKeys(uname);
		Password.sendKeys(pass);
		BtnLogin.click();
	}
}
