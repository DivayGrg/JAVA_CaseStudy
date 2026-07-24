package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AltoroLoginPage {
    WebDriver driver;

    @FindBy(id = "uid")
    WebElement txtUsername;

    @FindBy(id = "passw")
    WebElement txtPassword;

    @FindBy(name = "btnSubmit")
    WebElement btnSubmit;

    // If login is successful, the "Sign In" link changes to "Sign Off"
    @FindBy(xpath = "//font[contains(text(),'Sign Off')]")
    WebElement signOffLink;

    public AltoroLoginPage(WebDriver driver) {
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
            return signOffLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}