package com.LipiAutomation.pages.pageObjectModel.Katalon;

import com.LipiAutomation.base.CommonToAllPage;
import com.LipiAutomation.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.LipiAutomation.driver.DriverManagerTL.getDriver;

public class KAppoinmentPage extends CommonToAllPage {

    WebDriver driver;

    public KAppoinmentPage(WebDriver driver) {
        this.driver = driver;
    }


    private By kDropDownFacility = By.id("combo_facility");
    private By kRadioButtonHospReadMission = By.name("hospital_readmission");
    private By kValidDate = By.id("txt_visit_date");
    private By kComment = By.id("txt_comment");
    private By kBookAppointmentButton = By.id("btn-book-appointment");
    private By kAppointConfirmPageLoaded = By.xpath("//h2[text()='Appointment Confirmation']");

    public String fillAndSubmitAppointmentForm(String Date, String Comment) {

        //Filling and Submitting the Appontment Form
        selectOptionByVisibleText(kDropDownFacility, "Seoul CURA Healthcare Center");
        WaitHelpers.elementToBeClickable(kRadioButtonHospReadMission);
        clickElement(kRadioButtonHospReadMission);

        clickElement(kValidDate);
        enterInput(kValidDate, Date);

        enterInput(kComment, Comment);

        ts.takeScreenshot("Appointment_InputDetails_Entered");

        clickElement(kBookAppointmentButton);

        //WaitHelpers.waitJVM(3000);
        WaitHelpers.visibilityOfElement(kAppointConfirmPageLoaded);
        ts.takeScreenshot("Appointment_Confirmation");
        return getCurrentPageUrl();

    }
}
