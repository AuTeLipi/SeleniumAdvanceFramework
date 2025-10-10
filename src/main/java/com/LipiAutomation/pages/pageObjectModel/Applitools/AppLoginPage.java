package com.LipiAutomation.pages.pageObjectModel.Applitools;

import com.LipiAutomation.base.CommonToAllPage;
import com.LipiAutomation.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppLoginPage extends CommonToAllPage {

    WebDriver driver;

    public AppLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By Ausername = By.id("username");
    private By Apassword = By.id("password");
    private By SignInButton = By.id("log-in");
    private By AccountHolderName = By.className("logged-user-name");

    public String PositiveLoginScenario(String Auser, String Apass) {
        ApplitoolsLoginPage();
        enterInput(Ausername, Auser);
        enterInput(Apassword, Apass);
        ts.takeScreenshot("Login Credentials Entered");
        clickElement(SignInButton);

        WaitHelpers.visibilityOfElement(AccountHolderName);
        ts.takeScreenshot("Succesfully Login");
       // WaitHelpers.waitJVM(3000);
        return getCurrentPageUrl();
    }
}
