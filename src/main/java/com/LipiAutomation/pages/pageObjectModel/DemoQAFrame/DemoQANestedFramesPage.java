package com.LipiAutomation.pages.pageObjectModel.DemoQAFrame;

import com.LipiAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQANestedFramesPage extends CommonToAllPage {

    WebDriver driver;

    public DemoQANestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    private String parentBodyTextVar;
    private String childBodyTextVar;

    private By parentFrame = By.xpath("//iframe[@id='frame1']");
    private By parentBody = By.xpath("//body");
    private By childBody = By.xpath("//p");

    public void DemoQANestedFrames_2Frames() {

        DemoQANestedFramesPage();
        switchToFrame(parentFrame);
        parentBodyTextVar = getText(parentBody);

        switchToFrameByIndex(0);
        childBodyTextVar = getText(childBody);

        switchToDefaultContent();
    }

    public String getParentBodyText() {
        return parentBodyTextVar;
    }

    public String getChildBodyText() {
        return childBodyTextVar;
    }


}
