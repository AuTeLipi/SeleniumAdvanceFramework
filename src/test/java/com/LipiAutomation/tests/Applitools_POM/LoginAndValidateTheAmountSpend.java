package com.LipiAutomation.tests.Applitools_POM;

import com.LipiAutomation.base.CommonToAllTest;
import com.LipiAutomation.driver.DriverManager;
import com.LipiAutomation.listeners.RetryAnalyzer;
import com.LipiAutomation.listeners.ScreenshotListener;
import com.LipiAutomation.pages.pageObjectModel.Applitools.AppDashBoardPage;
import com.LipiAutomation.pages.pageObjectModel.Applitools.AppLoginPage;
import com.LipiAutomation.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class LoginAndValidateTheAmountSpend extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(LoginAndValidateTheAmountSpend.class);

    @Owner("Lipi")
    @Description("Validating Login Function and Calculating Total Amount Spend from Table")
    @Test
    public void test_LoginAndCalculateTotalAmountSpent() {
        logger.info("Starting Applitools Login TC");

        AppLoginPage loginPage = new AppLoginPage(DriverManager.getDriver());
        String getDashBoardURL = loginPage.PositiveLoginScenario(
                PropertiesReader.readKey("Ausername"),
                PropertiesReader.readKey("Apassword")
        );
        Assert.assertEquals(getDashBoardURL, PropertiesReader.readKey("Dashboard_url"));
        logger.info("app.html page successfully loaded");

        logger.info("Starting Applitools Dashboard TC where need to calculate Total Amount Spent");
        AppDashBoardPage dashBoardPage = new AppDashBoardPage(DriverManager.getDriver());
        double TotalSpentAmount = dashBoardPage.ADashBoardPage();

        // Parse expected amount from properties (String -> double)
        double expectedAmount = Double.parseDouble(PropertiesReader.readKey("TotalAmountSpent"));

        // Assert with a small delta for floating point comparison
        Assert.assertEquals(TotalSpentAmount, expectedAmount, 0.01, "Total spent amount does not match expected value");

        logger.info("Successfully verified the Total Spent Amount");
        Assert.assertTrue(true);
    }

    @Owner("Lipi")
    @Description("Validating Login Function and Calculating Total Amount Spend from Table")
    @Test
    public void test_LoginFailToRetry() {
        logger.info("Starting Applitools Login Fail To Retry TC");

        AppLoginPage loginPage = new AppLoginPage(DriverManager.getDriver());
        String getDashBoardURL = loginPage.PositiveLoginScenario(
                PropertiesReader.readKey("Ausername"),
                PropertiesReader.readKey("LIPI") // Will be unable to fing the LIPI key in data.properties file
        );
    }
}
