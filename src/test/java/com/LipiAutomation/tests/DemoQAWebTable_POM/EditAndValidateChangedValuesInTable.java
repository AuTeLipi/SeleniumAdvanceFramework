package com.LipiAutomation.tests.DemoQAWebTable_POM;

import com.LipiAutomation.base.CommonToAllTest;
import com.LipiAutomation.driver.DriverManager;
import com.LipiAutomation.listeners.RetryAnalyzer;
import com.LipiAutomation.listeners.ScreenshotListener;
import com.LipiAutomation.pages.pageObjectModel.DemoQAWebTables.WebTablePage;
import com.LipiAutomation.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class EditAndValidateChangedValuesInTable extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(EditAndValidateChangedValuesInTable.class);

    @Owner("Lipi")
    @Description("TC - Verify the changed data from the DemoQA WebTable")
    @Test
    public void Test_ChangeDataAndValidateIt() {
        logger.info("Starting DemoQA WebTable TC");
        WebTablePage webTablePage = new WebTablePage(DriverManager.getDriver());
        webTablePage.capturePreviousValues();

        logger.info("Successfully got previous Age and Salary");
        int PreviousAge = webTablePage.getPreviousAge();
        int PreviousSalary = webTablePage.getPreviousSalary();
        System.out.println("Previous Age: " + PreviousAge + " Previous Salary: " +PreviousSalary);

        webTablePage.EditingTheThirdRowData(PropertiesReader.readKey("SalaryAmountToEnter"), PropertiesReader.readKey("AgeToEnter"));

        int UpdatedAge = webTablePage.getAge();
        int UpatedSalary = webTablePage.getSalary();
        logger.info("Successfully got Updated Age and Salary");
        System.out.println("Updated Age: " + UpdatedAge + " Updated Salary: " +UpatedSalary);

        logger.info("Successfully Validated both updated Age and Salary");
        Assert.assertEquals(UpdatedAge, Integer.parseInt(PropertiesReader.readKey("AgeToEnter")));
        Assert.assertEquals(UpatedSalary, Integer.parseInt(PropertiesReader.readKey("SalaryAmountToEnter")));

        Assert.assertTrue(true);
    }
}
