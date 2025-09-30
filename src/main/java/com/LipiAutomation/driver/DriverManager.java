package com.LipiAutomation.driver;

import com.LipiAutomation.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver() {

        return driver;
    }

    public static void setDriver(WebDriver driver) {

        DriverManager.driver = driver;
    }

    // When we want to start the browser
    public static void init() {
        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                setDriver(new ChromeDriver(chromeOptions));
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                setDriver(new FirefoxDriver(firefoxOptions));
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                setDriver(new EdgeDriver(edgeOptions));
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }


    }


    // When we want to close the browser
    public static void down() {
        if (getDriver() != null) {
            driver.quit();
            driver = null;
        }

    }


}
