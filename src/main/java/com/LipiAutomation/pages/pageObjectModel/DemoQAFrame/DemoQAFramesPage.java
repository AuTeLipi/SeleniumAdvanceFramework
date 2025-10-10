package com.LipiAutomation.pages.pageObjectModel.DemoQAFrame;

import com.LipiAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQAFramesPage extends CommonToAllPage {

    private String frame1ContentVar;
    private String frame2ContentVar;

    WebDriver driver;

    public DemoQAFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By frame1 = By.id("frame1");
    private By frame2 = By.id("frame2");
    private By frameContent = By.id("sampleHeading");

    public void DemoQAFramesPage_TwoFrames() {

        DemoQAiFramesPage();

        // Switching to Frame1
        driver.switchTo().frame(driver.findElement(frame1));
        frame1ContentVar = getText(frameContent);
        // Switching back to Default Frame
        driver.switchTo().defaultContent();

        // Switching to Frame2
        driver.switchTo().frame(driver.findElement(frame2));
        frame2ContentVar = getText(frameContent);
        // Switching back to Default Frame
        driver.switchTo().defaultContent();

    }

    public String getTextFrame1() {
        return frame1ContentVar;
    }

    public String getTextFrame2() {
        return frame2ContentVar;
    }

}
