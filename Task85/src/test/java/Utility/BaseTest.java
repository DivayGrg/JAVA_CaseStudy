package Utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver; 
    public ConfigDataProvider config;

    @BeforeMethod
    public void setup() {
        config = new ConfigDataProvider();
        // Now it just opens the browser based on config, but doesn't go to a specific URL yet
        driver = BrowserFactory.startApplication(driver, config.getBrowser()); 
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }
}