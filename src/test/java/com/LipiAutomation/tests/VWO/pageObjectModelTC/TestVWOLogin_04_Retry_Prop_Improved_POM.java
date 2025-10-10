package com.LipiAutomation.tests.VWO.pageObjectModelTC;

import com.LipiAutomation.base.CommonToAllTest;
import com.LipiAutomation.listeners.RetryAnalyzer;
import com.LipiAutomation.utils.TakeScreenShot;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.LipiAutomation.driver.DriverManager.getDriver;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_04_Retry_Prop_Improved_POM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_04_Retry_Prop_Improved_POM.class);

    @Owner("LIPI")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
//        Allure.addAttachment("Log output", "text/plain", "This is some log text");
        Assert.assertTrue(false);
    }

    @Owner("LIPI")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        new TakeScreenShot().takeScreenshot("testPass_1"); // Manually taken screenshot
        Assert.assertTrue(true);
    }


}
