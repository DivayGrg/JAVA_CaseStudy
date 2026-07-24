package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeTestLoginPage {
	WebDriver driver;
	@FindBy(id="username")
	WebElement txtUsername;
	
	@FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "submit")
    WebElement btnSubmit;
    
    @FindBy(xpath="//h1[normalize-space()='Logged In Successfully']")
    WebElement successHeader;
    
    public PracticeTestLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        txtUsername.clear(); // Clears field in case of a loop
        txtUsername.sendKeys(username);
        txtPassword.clear();
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }
    
    public boolean isLoginSuccessful() {
        try {
            return successHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
