package com.LipiAutomation.tests.Katalon.pageObjectModelTC;

import com.LipiAutomation.base.CommonToAllTest;
import com.LipiAutomation.driver.DriverManager;
import com.LipiAutomation.pages.pageObjectModel.Katalon.KAppoinmentPage;
import com.LipiAutomation.pages.pageObjectModel.Katalon.KAppointmentConfirmationPage;
import com.LipiAutomation.pages.pageObjectModel.Katalon.KLoginPage;
import com.LipiAutomation.pages.pageObjectModel.Katalon.HomePage;
import com.LipiAutomation.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KatalonLogIn_ConfirmingAppointment extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(KatalonLogIn_ConfirmingAppointment.class);

    @Owner("LIPI")
    @Description("TC#1_Katalon_Login(With Invalid Creds)")
    @Test
    public void test_Katalon_Invalid_Login() {
        logger.info("Starting Katalon Invalid Login TC");
        // Step - 01 Navigating to LoginPage and LoginPage Loaded
        HomePage homePage = new HomePage(DriverManager.getDriver());
        String loginPageTitle = homePage.navigateToLoginPage();
        Assert.assertEquals(loginPageTitle, PropertiesReader.readKey("kTitle"));

        //Step - 02 Logging In with Invalid Credentials
        KLoginPage kLoginPage = new KLoginPage(DriverManager.getDriver());
        String kError_Msg = kLoginPage.kLoginWithInvalidCred(PropertiesReader.readKey("invalid_kusername"), PropertiesReader.readKey("invalid_kpassword"));

        //Step - 03 Validating Error Message
        Assert.assertEquals(kError_Msg, PropertiesReader.readKey("kerror_message"));
        logger.info("Katalon Invalid Login TC - Done");
    }

    @Owner("LIPI")
    @Description("TC#2_Katalon_Login_MakeAppointment_ConformAppointment")
    @Test
    public void test_Katalon_Valid_Login() {
        logger.info("Starting Katalon Valid Login TC");
        // Step - 01 Navigating to LoginPage and LoginPage Loaded
        HomePage homePage = new HomePage(DriverManager.getDriver());
        String loginPageTitle = homePage.navigateToLoginPage();
        Assert.assertEquals(loginPageTitle, PropertiesReader.readKey("kTitle"));

        //Step - 02 Logging In with Valid Credentials
        KLoginPage kLoginPage = new KLoginPage(DriverManager.getDriver());
        kLoginPage.kLoginWithValidCred(PropertiesReader.readKey("kusername"), PropertiesReader.readKey("kpassword"));
        logger.info("Login Successfully Done");

        //Step - 03 Appointment Page Loaded
        String kAppointmentPageURLCheck = kLoginPage.getCurrentPageUrl();
        Assert.assertEquals(kAppointmentPageURLCheck, PropertiesReader.readKey("kappointmentPageURL"));
        logger.info("Appointment Page Loaded Successfully");

        //Step - 04 Entered the Appointment details
        KAppoinmentPage kAppoinmentPage = new KAppoinmentPage(DriverManager.getDriver());
        kAppoinmentPage.fillAndSubmitAppointmentForm(PropertiesReader.readKey("Date"), PropertiesReader.readKey("Comment"));
        logger.info("Entered the Appointment details Successfully");

        // Step - 04 Finally Confirmation of Appointment
        String ConfirmationPageURLCheck = kAppoinmentPage.getCurrentPageUrl();
        Assert.assertEquals(ConfirmationPageURLCheck, PropertiesReader.readKey("ksummaryPage"));
        logger.info("Appointment Confirmation Successfully");

        // Step - 05 Validation all details of Appointment Confirmation
        KAppointmentConfirmationPage page = new KAppointmentConfirmationPage(DriverManager.getDriver());
        Assert.assertEquals(page.getFacility(), PropertiesReader.readKey("Facility"));
        Assert.assertEquals(page.getApplyForHospitalReadmission(), PropertiesReader.readKey("ApplyForHospitalReadmission"));
        Assert.assertEquals(page.getHealthcareProgram(), PropertiesReader.readKey("HealthcareProgram"));
        Assert.assertEquals(page.getVisitDate(), PropertiesReader.readKey("VisitDate"));
        Assert.assertEquals(page.getKComment(), PropertiesReader.readKey("KComment"));
        logger.info("Appointment Confirmation Validated");
    }

}
