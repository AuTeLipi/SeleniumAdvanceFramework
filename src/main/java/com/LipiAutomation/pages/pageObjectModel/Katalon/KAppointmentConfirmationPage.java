package com.LipiAutomation.pages.pageObjectModel.Katalon;

import com.LipiAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KAppointmentConfirmationPage extends CommonToAllPage {

    WebDriver driver;

    public KAppointmentConfirmationPage(WebDriver driver){
        this.driver = driver;
    }

    private By kAllLabelsTextToCheck = By.xpath("//div[@class='col-xs-offset-2 col-xs-8']//div[@class='col-xs-4']//label");
    private By kFacilityCheck = By.id("facility");
    private By kReadmissionCheck = By.id("hospital_readmission");
    private By kHealthcareProgramCheck = By.id("program");
    private By kVisitDateCheck = By.id("visit_date");
    private By kKCommentCheck = By.id("comment");


    public String getFacility() {
        return getText(kFacilityCheck);
    }

    public String getApplyForHospitalReadmission() {
        return getText(kReadmissionCheck);
    }

    public String getHealthcareProgram() {
        return getText(kHealthcareProgramCheck);
    }

    public String getVisitDate() {
        return getText(kVisitDateCheck);
    }

    public String getKComment() {
        return getText(kKCommentCheck);
    }


}
