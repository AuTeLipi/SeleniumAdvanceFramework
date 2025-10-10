package com.LipiAutomation.tests.DemoQAFrames_POM;

import com.LipiAutomation.base.CommonToAllTest;
import com.LipiAutomation.driver.DriverManager;
import com.LipiAutomation.listeners.RetryAnalyzer;
import com.LipiAutomation.listeners.ScreenshotListener;
import com.LipiAutomation.pages.pageObjectModel.DemoQAFrame.DemoQAFramesPage;
import com.LipiAutomation.pages.pageObjectModel.DemoQAFrame.DemoQANestedFramesPage;
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
public class DemoQAFrames_And_NestedFrames_TC extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(DemoQAFrames_And_NestedFrames_TC.class);

    @Owner("Lipi")
    @Description("TC#01 - Checking whether can navigate back and front from default frame to 2 other frame in it")
    @Test(priority = 1)
    public void test_DemoQAFrames() {
        logger.info("Starting, TC#01 - Checking whether can navigate back and front from default frame to 2 other frame in it");
        DemoQAFramesPage demoQAFramesPage =  new DemoQAFramesPage(DriverManager.getDriver());
        demoQAFramesPage.DemoQAFramesPage_TwoFrames();

        logger.info("Validating Frame1 Text");
        String getFrame1Text = demoQAFramesPage.getTextFrame1();
        System.out.println("Frame1 Text: " + getFrame1Text);
        Assert.assertEquals(getFrame1Text, PropertiesReader.readKey("frameContent"));
        logger.info("Successfully Validated Frame1 Text");

        logger.info("Validating Frame2 Text");
        String getFrame2Text = demoQAFramesPage.getTextFrame2();
        System.out.println("Frame2 Text: " + getFrame2Text);
        Assert.assertEquals(getFrame2Text, PropertiesReader.readKey("frameContent"));
        logger.info("Successfully Validated Frame2 Text");

        Assert.assertTrue(true);
    }

    @Owner("Lipi")
    @Description("TC#02 - Checking whether can navigate back and front from default frame to nested frames in it")
    @Test(priority = 2)
    public void test_DemoQANestedFrames() {
        logger.info("Sarting, TC#02 - Checking whether can navigate back and front from default frame to nested frames in it");
        DemoQANestedFramesPage demoQANestedFramesPage = new DemoQANestedFramesPage(DriverManager.getDriver());
        demoQANestedFramesPage.DemoQANestedFrames_2Frames();

        logger.info("Validating Parent Body Text");
        String parentBodyText = demoQANestedFramesPage.getParentBodyText();
        System.out.println("Parent BodyText: " +parentBodyText);
        Assert.assertEquals(parentBodyText, PropertiesReader.readKey("Parentframe"));
        logger.info("Successfully Validated the Parent Body Text");

        logger.info("Validating Child Body Text");
        String childBodyText = demoQANestedFramesPage.getChildBodyText();
        System.out.println("Child BodyText: " +childBodyText);
        Assert.assertEquals(childBodyText, PropertiesReader.readKey("Childframe"));
        logger.info("Successfully Validated the Child Body Text");

        Assert.assertTrue(true);
    }


}
