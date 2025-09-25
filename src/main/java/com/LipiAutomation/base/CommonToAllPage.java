package com.LipiAutomation.base;

import com.LipiAutomation.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.LipiAutomation.driver.DriverManager.getDriver;

public class CommonToAllPage {
    // Common to All page

    public void openVWOUrl() {

        getDriver().get(PropertiesReader.readKey("url"));
    }

    public  void  dashBoardVWOURL() {
        getDriver().get(PropertiesReader.readKey("dashBoardVWOURL"));
    }

    public void openOrangeHRMUrl(){

        getDriver().get(PropertiesReader.readKey("ohr_url"));
    }

    public void openKatalonUrl(){

        getDriver().get(PropertiesReader.readKey("katalon_url"));
    }

    public void kLoginPageURL(){

        getDriver().get(PropertiesReader.readKey("kloginPageURL"));
    }

    public void kAppointmentPageURL(){

        getDriver().get(PropertiesReader.readKey("kappointmentPageURL"));
    }

    public void kSummaryPage(){

        getDriver().get(PropertiesReader.readKey("ksummaryPage"));
    }


    public void clickElement(By by){

        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by) {

        by.click();
    }

    public void enterInput(By by, String key) {

        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key) {

        by.sendKeys(key);
    }

    public String getText(By by){

        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){

        return by.getText();
    }


}
