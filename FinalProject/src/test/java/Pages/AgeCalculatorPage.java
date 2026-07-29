package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgeCalculatorPage {
    WebDriver driver;
    public AgeCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "i21")
    WebElement dayInput;
    @FindBy(id = "i22")
    WebElement monthInput;
    @FindBy(id = "i23")
    WebElement yearInput;
    @FindBy(xpath = "//input[@name='but']")
    WebElement calculateBtn;
    
    public void calculateAge(String day, String month, String year) 
    		throws InterruptedException {
        dayInput.clear();
        dayInput.sendKeys(day);
        monthInput.clear();
        monthInput.sendKeys(month);
        yearInput.clear();
        yearInput.sendKeys(year);
        calculateBtn.click();
        Thread.sleep(2000); 
    }
    public String getActualAgeResult() {
        return driver.findElement(By.id("r1")).getAttribute("value").trim();
    }
}