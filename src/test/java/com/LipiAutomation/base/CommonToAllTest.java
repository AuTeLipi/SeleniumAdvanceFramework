package com.LipiAutomation.base;

import com.LipiAutomation.driver.DriverManagerTL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class CommonToAllTest {

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        DriverManagerTL.init();

    }

    @AfterMethod
    public void tearDown(){

        DriverManagerTL.down();

    }



}
