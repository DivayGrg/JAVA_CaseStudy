package DataDrivenTesting.CSVFile.Testing;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.PracticeTestLoginPage;
import Utility.BaseTest;
import Utility.CSVDataReader;
import Utility.Helper;

public class CSVFileReading extends BaseTest {

    @Test
    public void DDTestingBlog() throws Exception {
        // 1. Go to the Practice URL initially
        driver.get(config.getUrl("PracticeUrl"));
        
        // 2. Get the specific Practice CSV
        List<String[]> csvData = CSVDataReader.readCsvData("practicetest.csv");
        PracticeTestLoginPage loginPage = new PracticeTestLoginPage(driver);

        for (String[] row : csvData) {
            String username = row[0];
            String password = row[1];

            loginPage.login(username, password);

            if (!loginPage.isLoginSuccessful()) {
                Helper.capturedScreenShot(driver);
                Assert.fail("Login failed for user: " + username);
            }

            // 3. FIX: Refresh the specific Practice URL for the next CSV row
            driver.get(config.getUrl("PracticeUrl"));
        }
    }
}