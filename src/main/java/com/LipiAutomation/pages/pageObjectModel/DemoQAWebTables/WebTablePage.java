package com.LipiAutomation.pages.pageObjectModel.DemoQAWebTables;

import com.LipiAutomation.base.CommonToAllPage;
import com.LipiAutomation.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablePage extends CommonToAllPage {

    WebDriver driver;

    private int AgeIs;
    private int SalaryIs;
    private int BeforeAgeIs;
    private int BeforeSalaryIs;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    // 3rd row editbutton
    private By EditButton = By.xpath("(//*[name()='svg']/*[name()='path'][starts-with(@d, 'M880 836H144c')])[3]");
    private By SalaryField = By.xpath("//input[@id='salary']");
    private By AgeField = By.xpath("//input[@id='age']");
    private By SubmitButton = By.xpath("//button[@id='submit']");
    private By ValidateAge = By.xpath("(//div[@class='rt-td'])[17]");
    private By ValidateSalary = By.xpath("(//div[@class='rt-td'])[19]");

    public void capturePreviousValues() {
        DemoQAWebTablePage();
        ts.takeScreenshot("Before Updating the 3rd Row Data");

        String beforeAgeStr = getText(ValidateAge);
        BeforeAgeIs = Integer.parseInt(beforeAgeStr);

        String beforeSalaryStr = getText(ValidateSalary);
        BeforeSalaryIs = Integer.parseInt(beforeSalaryStr);
    }

    public void EditingTheThirdRowData(String EnterSalary, String EnterAge) {
        clickElement(EditButton);

        clickElement(SalaryField);
        WebElement salary = getElementById(SalaryField);
        salary.sendKeys(Keys.CONTROL + "a");
        salary.sendKeys(Keys.DELETE);
        enterInput(SalaryField, EnterSalary);

        clickElement(AgeField);
        WebElement Age = getElementById(AgeField);
        Age.sendKeys(Keys.CONTROL + "a");
        Age.sendKeys(Keys.DELETE);
        enterInput(AgeField, EnterAge);

        clickElement(SubmitButton);

        ts.takeScreenshot("After Updating the 3rd Row Data");

        WaitHelpers.waitJVM(3000);

        String AgeStr = getText(ValidateAge);
        AgeIs = Integer.parseInt(AgeStr);

        String  SalaryStr = getText(ValidateSalary);
        SalaryIs = Integer.parseInt(SalaryStr);

    }

    public int getAge() {
        return AgeIs;
    }

    public  int getSalary() {
        return SalaryIs;
    }

    public  int getPreviousAge() {
        return BeforeAgeIs;
    }

    public int getPreviousSalary() {
        return BeforeSalaryIs;
    }
}
