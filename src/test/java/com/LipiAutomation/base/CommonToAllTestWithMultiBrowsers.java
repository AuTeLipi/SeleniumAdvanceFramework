package com.LipiAutomation.base;

import com.LipiAutomation.driver.DriverMangerTLWithMultiBrowsers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CommonToAllTestWithMultiBrowsers {

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browserName) {
        DriverMangerTLWithMultiBrowsers.init(browserName);
    }

    @AfterMethod
    public void tearDown() {
        DriverMangerTLWithMultiBrowsers.down();
    }

}
