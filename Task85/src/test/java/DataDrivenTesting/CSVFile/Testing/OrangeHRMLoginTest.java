package DataDrivenTesting.CSVFile.Testing;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.OrangeHRMLoginPage;
import Utility.BaseTest;
import Utility.CSVDataReader;
import Utility.Helper;

public class OrangeHRMLoginTest extends BaseTest {

    @Test
    public void testOrangeHRMLogin() throws Exception {
    	driver.get(config.getUrl("OrangeUrl"));
        
        List<String[]> csvData = CSVDataReader.readCsvData("orangehrm_data.csv");
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(driver);

        for (String[] row : csvData) {
            // Note: Use Admin / admin123 in your CSV for a successful login
            String username = row[0];
            String password = row[1];

            loginPage.login(username, password);

            if (!loginPage.isLoginSuccessful()) {
                Helper.capturedScreenShot(driver);
                Assert.fail("Login failed for user: " + username);
            }

            // Refresh or navigate back so the next CSV row starts on the login screen
            driver.get(config.getUrl("OrangeUrl"));
        }
    }
}