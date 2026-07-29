package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[6]/div[2]/div[1]/ul[1]/li[1]/a[1]")
    WebElement ageCalculatorIcon;

    public void clickAgeCalculator() throws InterruptedException {
      
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ageCalculatorIcon);
        
        
        handleGoogleVignetteAd();
    }

   
    private void handleGoogleVignetteAd() throws InterruptedException {
       
        Thread.sleep(3000); 

        try {
           
            WebElement googleAdFrame = driver.findElement(By.xpath("//iframe[contains(@id, 'aswift_')]"));
            driver.switchTo().frame(googleAdFrame);

            
            if (driver.findElements(By.id("ad_iframe")).size() > 0) {
                driver.switchTo().frame("ad_iframe");
            }

            WebElement closeButton = driver.findElement(By.id("dismiss-button"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", closeButton);
            
            System.out.println("Vignette ad forcefully closed using JS.");

        } catch (Exception e) {
            
            System.out.println("No ad found, proceeding to test.");
        } finally {
                 driver.switchTo().defaultContent();
        }
    }
    }