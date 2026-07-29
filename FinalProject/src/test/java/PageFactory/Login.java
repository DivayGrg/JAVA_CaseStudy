package PageFactory; 

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Pages.AgeCalculatorPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utility.BrowserFactory;
import Utility.ConfigDataProvider;
import Utility.ExcelDataProvider;
import Utility.Helper;

import org.testng.ITestResult;


public class Login {
    public WebDriver driver; 
    public ConfigDataProvider config;
    public ExcelDataProvider excel;

    @BeforeClass
    public void setup() {
        config = new ConfigDataProvider();
        excel = new ExcelDataProvider(); 
        
        driver = BrowserFactory.startApplication(driver, config.getBrowser()); 
        driver.get("https://www.login.hiox.com/login?referrer=easycalculation.com");
    }

    @Test(priority=1)
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication("chaudharyharshit1310@gmail.com", "8755185366@aQ");
    }

    @Test(priority=2)
    public void navigateToAgeCalculator() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickAgeCalculator();
    }

    // The DataProvider grabs the 4 rows of data from Excel

        

    
    @Test(priority=3)
    public void testAgeCalculation() throws InterruptedException {
    	String day=excel.getCellData("AgeData", 0, 0);
    	String month=excel.getCellData("AgeData", 0, 1);
    	String year=excel.getCellData("AgeData", 0, 2);
    	String expectedResult=excel.getCellData("AgeData", 0, 3);
        AgeCalculatorPage calcPage = new AgeCalculatorPage(driver);
        
        calcPage.calculateAge(day, month, year);
        
       
        String actualResult = calcPage.getActualAgeResult();
        
       
        System.out.println("Validating Input: " + day + "/" + month + "/" + year);
        Assert.assertEquals(actualResult, expectedResult, "Age calculation mismatch!");
    }
    @Test(priority=4)
    public void testAgeCalculation1() throws InterruptedException {
    	String day=excel.getCellData("AgeData", 1, 0);
    	String month=excel.getCellData("AgeData", 1, 1);
    	String year=excel.getCellData("AgeData", 1, 2);
    	String expectedResult=excel.getCellData("AgeData", 1, 3);
        AgeCalculatorPage calcPage = new AgeCalculatorPage(driver);
        
        calcPage.calculateAge(day, month, year);
        
       
        String actualResult = calcPage.getActualAgeResult();
        
       
        System.out.println("Validating Input: " + day + "/" + month + "/" + year);
        Assert.assertEquals(actualResult, expectedResult, "Age calculation mismatch!");
    }

    // Make sure to add this import

 // ... your @Test methods ...

     @AfterMethod
     public void tearDownMethod(ITestResult result) throws Exception {
         // ITestResult.FAILURE is automatically triggered if an assertion fails or an element isn't found
         if (result.getStatus() == ITestResult.FAILURE) {
             
             System.out.println("Test failed: " + result.getMethod().getMethodName());
             
             // This calls the exact method from the Helper class you pasted
             Helper.capturedScreenShot(driver);
         }
     }
}