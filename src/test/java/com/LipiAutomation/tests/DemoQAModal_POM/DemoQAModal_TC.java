package com.LipiAutomation.tests.DemoQAModal_POM;

import com.LipiAutomation.base.CommonToAllTest;
import com.LipiAutomation.driver.DriverManager;
import com.LipiAutomation.listeners.RetryAnalyzer;
import com.LipiAutomation.listeners.ScreenshotListener;
import com.LipiAutomation.pages.pageObjectModel.DemoQAModal.DemoQAModalPage;
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
public class DemoQAModal_TC extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(DemoQAModal_TC.class);

    @Owner("Lipi")
    @Description("TC#01 - Validation the Content inside the Small Modal")
    @Test(priority = 1)
    public void test_DemoQA_SmallModal_Content_Validation() {
        logger.info("Starting, TC01 - Validation the Content inside the Small Modal");
        DemoQAModalPage demoQAModalPage = new DemoQAModalPage(DriverManager.getDriver());
        String smallModalContentToValidate = demoQAModalPage.DemoQASmallModalPage();
        System.out.println("Small Modal Content: " + smallModalContentToValidate);
        logger.info("Validating Small Modal");
        Assert.assertEquals(smallModalContentToValidate, PropertiesReader.readKey("smallModalContentVar"));
        logger.info("Small Modal is Validated, Successfully");
        Assert.assertTrue(true);
    }

    @Owner("Lipi")
    @Description("TC#02 - Validation the Content inside the Large Modal")
    @Test(priority = 2)
    public void test_DemoQA_LargeModal_Content_Validation() {
        logger.info("Starting, TC02 - Validation the Content inside the Large Modal");
        DemoQAModalPage demoQAModalPage = new DemoQAModalPage(DriverManager.getDriver());
        String largeModalContentToValidate = demoQAModalPage.DemoQALargeModalPage();
        System.out.println("Large Modal Content: " + largeModalContentToValidate);
        logger.info("Validating Large Modal");
        Assert.assertEquals(largeModalContentToValidate, PropertiesReader.readKey("largeModalContentVar"));
        logger.info("Large Modal is Validated, Successfully");
        Assert.assertTrue(true);
    }
}
