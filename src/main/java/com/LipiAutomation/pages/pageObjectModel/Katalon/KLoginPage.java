package com.LipiAutomation.pages.pageObjectModel.Katalon;

import com.LipiAutomation.base.CommonToAllPage;
import com.LipiAutomation.utils.PropertiesReader;
import com.LipiAutomation.utils.TakeScreenShot;
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

    private By kusername = By.id("txt-username");
    private By kpassword = By.id("txt-password");
    private By kLoginButton = By.id("btn-login");
    private By InvalidErrorMsg = By.xpath("//p[contains(text(), 'Login failed!')]");
    private By kAppointmentPageLoaded = By.xpath("//h2[text()='Make Appointment']");


    public String kLoginWithInvalidCred(String kuser, String kpwd) {

        kLoginPageURL();
        enterInput(kusername, kuser);
        enterInput(kpassword, kpwd);
        ts.takeScreenshot("Login_Invalid_Cred");
        clickElement(kLoginButton);

        WaitHelpers.visibilityOfElement(InvalidErrorMsg);
        ts.takeScreenshot("Login_Invalid_ErrorMsg");
        return getText(InvalidErrorMsg);
    }

    public void kLoginWithValidCred(String kuser, String kpwd) {

        //Login with Valid Username and Password
        kLoginPageURL();
        enterInput(kusername, kuser);
        enterInput(kpassword, kpwd);
        ts.takeScreenshot("Login_Valid_Cred");
        clickElement(kLoginButton);

        WaitHelpers.waitJVM(3000);

        //WaitHelpers.visibilityOfElement(kAppointmentPageLoaded);
        ts.takeScreenshot("Login_Succesfully_Navigate_To_BookAppointmentPage");
    }

}
