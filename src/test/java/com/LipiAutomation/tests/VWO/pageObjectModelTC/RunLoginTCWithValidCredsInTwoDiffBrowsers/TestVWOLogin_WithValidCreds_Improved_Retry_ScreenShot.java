package com.LipiAutomation.tests.VWO.pageObjectModelTC.RunLoginTCWithValidCredsInTwoDiffBrowsers;

import com.LipiAutomation.base.CommonToAllTestWithMultiBrowsers;
import com.LipiAutomation.driver.DriverMangerTLWithMultiBrowsers;
import com.LipiAutomation.listeners.RetryAnalyzer;
import com.LipiAutomation.listeners.ScreenshotListener;
import com.LipiAutomation.pages.pageObjectModel.VWO.Improved_POM_WithDriverTLMultiBrowsers.VWO_DashBoardPage;
import com.LipiAutomation.pages.pageObjectModel.VWO.Improved_POM_WithDriverTLMultiBrowsers.VWO_LoginPage;
import com.LipiAutomation.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_WithValidCreds_Improved_Retry_ScreenShot extends CommonToAllTestWithMultiBrowsers {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_WithValidCreds_Improved_Retry_ScreenShot.class);

    @Owner("LIPI")
    @Description("TC#1 Verify that valid creds dashboard page is loaded")
    @Test
    public void test_LoginPositiveVWO() {

        logger.info("Starting, TC#1 Verify that valid creds dashboard page is loaded");
        // Login with Valid Credentials
        VWO_LoginPage loginPage_VWO = new VWO_LoginPage(DriverMangerTLWithMultiBrowsers.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
        logger.info("Successfully Logged In");

        // Navigated to DashBoard Page and fetching the Usernam
        VWO_DashBoardPage dashBoardPage  = new VWO_DashBoardPage(DriverMangerTLWithMultiBrowsers.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();
        System.out.println("Username: " + usernameLoggedIn);

        // Validating the Username
        logger.info("Validating the Username");
        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
        logger.info("Successfully Validated the Username");
        logger.info("Done the Test cases");
        Assert.assertTrue(true);
    }

}
