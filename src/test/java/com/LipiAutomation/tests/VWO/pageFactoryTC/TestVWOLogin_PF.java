package com.LipiAutomation.tests.VWO.pageFactoryTC;

import com.LipiAutomation.base.CommonToAllTest;
import com.LipiAutomation.driver.DriverManager;
import com.LipiAutomation.pages.pageFactory.VWO.DashboardPage_PF;
import com.LipiAutomation.pages.pageFactory.VWO.LoginPage_PF;
import com.LipiAutomation.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestVWOLogin_PF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);

    @Owner("LIPI")
    @Description("TC#1-Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the testLoginNegativeVWO_PF Testcases Page Factory");

        LoginPage_PF loginPage_PF = new LoginPage_PF(DriverManager.getDriver());
        String error_msg = loginPage_PF.loginToVWOInvalidCreds();

        logger.info("Error msg I got "+ error_msg);

        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));

        logger.info("Finished the testLoginNegativeVWO_PF Testcases Page Factory");
    }

    @Owner("LIPI")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPostiveVWO_PF() {
        logger.info("Starting the testLoginPostiveVWO_PF Testcases Page Factory");

        LoginPage_PF loginPagePf = new LoginPage_PF(DriverManager.getDriver());

        loginPagePf.loginToVWOValidCreds();
        loginPagePf.dashBoardVWOURL();

        DashboardPage_PF dashboardPagePf = new DashboardPage_PF(DriverManager.getDriver());
        String actualUserName =  dashboardPagePf.dashBoardPageOfVWO();
        String expectedUserName = PropertiesReader.readKey("expected_username");

        Assert.assertEquals(actualUserName, expectedUserName);

        logger.info("Finished the testLoginPostiveVWO_PF Testcases Page Factory");

    }

}
