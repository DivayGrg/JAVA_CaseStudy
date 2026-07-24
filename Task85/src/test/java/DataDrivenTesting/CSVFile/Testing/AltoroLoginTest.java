package DataDrivenTesting.CSVFile.Testing;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AltoroLoginPage;
import Utility.BaseTest;
import Utility.CSVDataReader;
import Utility.Helper;

public class AltoroLoginTest extends BaseTest {

    @Test
    public void testAltoroLogin() throws Exception {
        // 1. Navigate to the URL
        driver.get(config.getUrl("AltoroUrl"));
        
        // 2. Read the CSV data
        List<String[]> csvData = CSVDataReader.readCsvData("altoro_data.csv");
        
        // MISSING LINE ADDED HERE: Initialize your Page Object Model class
        AltoroLoginPage loginPage = new AltoroLoginPage(driver);

        for (String[] row : csvData) {
            String username = row[0];
            String password = row[1];

            // Now it knows what loginPage is!
            loginPage.login(username, password);

            if (!loginPage.isLoginSuccessful()) {
                Helper.capturedScreenShot(driver);
                Assert.fail("Login failed for user: " + username);
            }
            
            driver.get(config.getUrl("AltoroUrl"));
        }
    }
}