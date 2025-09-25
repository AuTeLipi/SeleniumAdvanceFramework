package com.LipiAutomation.pages.pageObjectModel.Katalon;

import com.LipiAutomation.base.CommonToAllPage;
import com.LipiAutomation.utils.PropertiesReader;
import com.LipiAutomation.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KLoginPage extends CommonToAllPage {

    // WebDriver
    // Page Class
    // Page Locators
    // Page Actions

    WebDriver driver;

    public KLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By MakeAppointmentButton = By.id("btn-make-appointment");
    private By kLoginPageLoaded = By.xpath("//h1[text()='CURA Healthcare Service']");
    private By kusername = By.id("txt-username");
    private By kpassword = By.id("txt-password");
    private By kLoginButton = By.id("btn-login");
    private By InvalidErrorMsg = By.xpath("//p[contains(text(), 'Login failed!')]");
    private By kAppointmentPageLoaded = By.xpath("//h2[text()='Make Appointment']");
    private By kAppointConfirmPageLoaded = By.xpath("//h2[text()='Appointment Confirmation']");

    public String kLoginWithInvalidCred(String kuser, String kpwd) {
        openKatalonUrl();
        clickElement(MakeAppointmentButton);
        WaitHelpers.visibilityOfElement(kLoginPageLoaded);
        enterInput(kusername, kuser);
        enterInput(kpassword, kpwd);
        clickElement(kLoginButton);
        WaitHelpers.visibilityOfElement(InvalidErrorMsg);
        return getText(InvalidErrorMsg);
    }

    public  void kLoginWithValidCred(String kuser, String kpwd) {
        openKatalonUrl();
        clickElement(MakeAppointmentButton);
        WaitHelpers.visibilityOfElement(kLoginPageLoaded);
        enterInput(kusername, kuser);
        enterInput(kpassword, kpwd);
        clickElement(kLoginButton);
        WaitHelpers.visibilityOfElement(kAppointmentPageLoaded);

    }
}
