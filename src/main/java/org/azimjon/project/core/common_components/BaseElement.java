package org.azimjon.project.core.common_components;

import org.azimjon.project.core.driver.Driver;
import org.azimjon.project.core.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElement {
    protected static WebDriver driver = Driver.getDriver();
    protected By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public String getText() {
        return getElement().getText();
    }

    public WebElement getElement() {
        return driver.findElement(locator);
    }

    public void click() {
        WaitUtils.untilClickable(this).click();
    }

    public void click(int seconds) {
        WaitUtils.waitForSeconds(seconds);
        WaitUtils.untilClickable(this).click();
    }

    public boolean isVisible() {
        return WaitUtils.untilVisible(this).isDisplayed();
    }

    public By getLocator() {
        return locator;
    }
}
