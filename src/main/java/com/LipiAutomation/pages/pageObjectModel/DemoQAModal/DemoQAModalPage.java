package com.LipiAutomation.pages.pageObjectModel.DemoQAModal;

import com.LipiAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQAModalPage extends CommonToAllPage {

    WebDriver driver;

    public DemoQAModalPage(WebDriver driver) {
        this.driver = driver;
    }

    private By smallModalButton = By.id("showSmallModal");
    private By smallModalContent = By.xpath("//div[@class='modal-body']");
    private By smallModalCloseButton = By.id("closeSmallModal");
    private By largeModalButton = By.id("showLargeModal");
    private By largeModalContent = By.xpath("//div[@class='modal-body']/p");
    private By largeModalCloseButton = By.id("closeLargeModal");

    public String DemoQASmallModalPage() {
        DemoQAModalPage();
        clickElement(smallModalButton);
        ts.takeScreenshot("Small Modal Content");
        String smallModalContentText = getText(smallModalContent);
        clickElement(smallModalCloseButton);
        ts.takeScreenshot("Small Modal Closed");
        return smallModalContentText;
    }

    public String DemoQALargeModalPage() {
        DemoQAModalPage();
        clickElement(largeModalButton);
        ts.takeScreenshot("Large Modal Content");
        String largeModalContentText = getText(largeModalContent);
        clickElement(largeModalCloseButton);
        ts.takeScreenshot("Large Modal Closed");
        return largeModalContentText;
    }

}
