package com.LipiAutomation.pages.pageObjectModel.Katalon;

import com.LipiAutomation.base.CommonToAllPage;
import com.LipiAutomation.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonToAllPage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By MakeAppointmentButton = By.id("btn-make-appointment");
    private By kLoginPageLoaded = By.xpath("//h1[text()='CURA Healthcare Service']");


    public String navigateToLoginPage() {

        //Home Page -> Upon clicking MakeAppointmentButton redirects to LoginPage
        openKatalonUrl();
        ts.takeScreenshot("Home Page");
        clickElement(MakeAppointmentButton);
        WaitHelpers.visibilityOfElement(kLoginPageLoaded);
        return getPageTitle();
    }

}
