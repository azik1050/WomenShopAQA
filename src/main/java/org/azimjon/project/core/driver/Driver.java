package org.azimjon.project.core.driver;

import org.azimjon.project.core.config.TestConfig;
import org.azimjon.project.core.utils.enums.BrowserType;
import org.openqa.selenium.WebDriver;


public class Driver {
    private static WebDriver driver;

    private Driver() {}

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            DriverFactory.createDriver(BrowserType.fromString(TestConfig.BROWSER));
        }
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Driver.driver = driver;
    }
}
