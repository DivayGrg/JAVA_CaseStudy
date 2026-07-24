package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {
    WebDriver driver;

    @FindBy(name = "username")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(css = "button[type='submit']")
    WebElement btnSubmit;

    // This dropdown only appears after a successful login
    @FindBy(className = "oxd-userdropdown-name")
    WebElement userDropdown;

    public OrangeHRMLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        txtUsername.clear();
        txtUsername.sendKeys(username);
        txtPassword.clear();
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }
    
    public boolean isLoginSuccessful() {
        try {
            return userDropdown.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}