package org.azimjon.project.core.utils;

import org.azimjon.project.core.common_components.BaseElement;
import org.azimjon.project.core.driver.Driver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitUtils {
    private static final WebDriver driver = Driver.getDriver();
    private static final int DEFAULT_TIMEOUT = 10;

    public static WebElement untilVisible(BaseElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(element.getLocator()));
    }

    public static WebElement untilClickable(BaseElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element.getLocator()));
    }

    public static void waitForSeconds(int seconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(d -> false);
        } catch (TimeoutException ignored) {
        }
    }
}
