package org.azimjon.project.core.driver;

import org.azimjon.project.core.utils.enums.BrowserType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;


public class DriverFactory {
    public static void createDriver(BrowserType browser) {
        switch (browser) {
            case CHROME:
                Driver.setDriver(getChromeDriver());
                break;
            case EDGE:
                Driver.setDriver(getEdgeDriver());
                break;
            case FIREFOX:
                Driver.setDriver(getFirefoxDriver());
                break;
            default:
                throw new IllegalArgumentException();
        }
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().manage().window().maximize();
    }

    private static ChromeDriver getChromeDriver() {
        return new ChromeDriver();
    }

    private static EdgeDriver getEdgeDriver() {
        return new EdgeDriver();
    }

    private static FirefoxDriver getFirefoxDriver() {
        return new FirefoxDriver();
    }
}
