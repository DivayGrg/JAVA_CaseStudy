package DataDrivenTesting.CSVFile.Testing;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ChaseLoginPage;
import Utility.BaseTest;
import Utility.CSVDataReader;
import Utility.Helper;

public class ChaseLoginTest extends BaseTest {

    @Test
    public void testChaseBankLoginFailure() throws Exception {
        
        // Wrap everything in a try block
        try {
            driver.get(config.getUrl("ChaseUrl"));
            
            List<String[]> csvData = CSVDataReader.readCsvData("chase_data.csv");
            ChaseLoginPage loginPage = new ChaseLoginPage(driver);

            for (String[] row : csvData) {
                String username = row[0];
                String password = row[1];

                loginPage.login(username, password);

                // This handles Logical Failures
                if (!loginPage.isLoginSuccessful()) {
                    Helper.capturedScreenShot(driver);
                    Assert.fail("Login failed (as expected) for user: " + username);
                }
                
                driver.get(config.getUrl("ChaseUrl"));
            }
            
        } catch (Exception e) {
            // This handles Crashes! If it can't find an element, it jumps here.
            Helper.capturedScreenShot(driver);
            Assert.fail("Test crashed unexpectedly: " + e.getMessage());
        }
    }
}