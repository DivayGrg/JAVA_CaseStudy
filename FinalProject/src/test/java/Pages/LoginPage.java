package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(xpath = "//input[@id='log_email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='log_password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@name='persist']")
    WebElement persistCheckbox;

    @FindBy(xpath = "//input[@name='log_submit']")
    WebElement loginButton;

   
    public void loginToApplication(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        emailInput.sendKeys(username);
        Thread.sleep(2000);
        passwordInput.sendKeys(password);
        Thread.sleep(2000);
        persistCheckbox.click();
        Thread.sleep(2000);
        loginButton.click();
        Thread.sleep(2000);
    }
}