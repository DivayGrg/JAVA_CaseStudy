package com.EasyCalculation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginEasyCal {
	WebDriver driver;
	
	//Constructor
	public LoginEasyCal(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(id="log_email")
	WebElement email;
	
	@FindBy(name="log_password")
	WebElement password;
	
	@FindBy(xpath="//input[@id='log_password']")
	WebElement LoginBtn;
	
	//Creating and assigning values
	public void login_EasyCal(String uname, String pass) {
		email.sendKeys(uname);
		password.sendKeys(pass);
		LoginBtn.click();
	}
}
