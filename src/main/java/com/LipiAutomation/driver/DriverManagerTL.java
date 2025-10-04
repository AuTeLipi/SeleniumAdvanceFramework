package com.LipiAutomation.driver;

import com.LipiAutomation.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class DriverManagerTL {

    // Each thread will have its own WebDriver instance
    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    // Set driver for the current thread
    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    // Get driver for the current thread
    public static WebDriver getDriver() {
        return dr.get();
    }

    // Remove driver reference from ThreadLocal
    public static void unload() {
        dr.remove();
    }


    // Initialize WebDriver based on browser name mentioned in data.properties
    public static void init() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "128.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
        }});
        setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));

        /*
        if (getDriver() == null) {
            String browser = PropertiesReader.readKey("browser").toLowerCase();

            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--guest");
                    chromeOptions.addArguments("--start-maximized");
                    setDriver(new ChromeDriver(chromeOptions));
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--guest");
                    firefoxOptions.addArguments("--start-maximized");
                    setDriver(new FirefoxDriver(firefoxOptions));
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--guest");
                    edgeOptions.addArguments("--start-maximized");
                    setDriver(new EdgeDriver(edgeOptions));
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
         */

    }

    // Quit the browser
    public static void down() {
        WebDriver driver = DriverManagerTL.getDriver();
        if (driver != null) {
            driver.quit();
            DriverManagerTL.unload(); // clears the ThreadLocal for this thread
        }
    }

}
