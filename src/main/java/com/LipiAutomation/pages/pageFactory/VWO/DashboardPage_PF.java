package com.LipiAutomation.pages.pageFactory.VWO;

import com.LipiAutomation.base.CommonToAllPage;
import com.LipiAutomation.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage_PF extends CommonToAllPage {

    WebDriver driver;

    public DashboardPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6")
    private WebElement dashBoardVWO_UserName;

    public String dashBoardPageOfVWO() {
        dashBoardVWOURL();
        WaitHelpers.visibilityOfElement(dashBoardVWO_UserName);
        return dashBoardVWO_UserName.getText();

    }
}
