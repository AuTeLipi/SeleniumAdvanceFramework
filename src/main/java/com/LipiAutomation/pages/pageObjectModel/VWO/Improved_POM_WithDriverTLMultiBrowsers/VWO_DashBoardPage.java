package com.LipiAutomation.pages.pageObjectModel.VWO.Improved_POM_WithDriverTLMultiBrowsers;

import com.LipiAutomation.base.CommonToAllPage;
import com.LipiAutomation.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VWO_DashBoardPage extends CommonToAllPage {
    WebDriver driver;

    public VWO_DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameOnDashboard = By.xpath("//h6");

    // Page Actions
    public String loggedInUserName() {
        WaitHelpers.visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }

}