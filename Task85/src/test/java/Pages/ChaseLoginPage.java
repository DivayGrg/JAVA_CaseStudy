package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChaseLoginPage {
    WebDriver driver;

    @FindBy(id = "userId-input-field-input")
    WebElement txtUsername;

    @FindBy(id = "password-input-field-input")
    WebElement txtPassword;

    @FindBy(id = "signin-button")
    WebElement btnSubmit;

    @FindBy(id = "header-simplerAuth-dropdownoptions-styledselect")
    WebElement postLoginElement;

    public ChaseLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        try {
            txtUsername.clear();
            txtUsername.sendKeys(username);
            txtPassword.clear();
            txtPassword.sendKeys(password);
            btnSubmit.click();
        } catch (Exception e) {
            System.out.println("Chase blocked the automation interaction: " + e.getMessage());
        }
    }
    
    public boolean isLoginSuccessful() {
        try {
            return postLoginElement.isDisplayed();
        } catch (Exception e) {
            return false; // This will return false, triggering your screenshot helper
        }
    }
}