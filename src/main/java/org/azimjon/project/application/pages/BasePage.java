package org.azimjon.project.application.pages;

import org.azimjon.project.core.driver.Driver;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver = Driver.getDriver();

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void getPageTitle() {
        driver.getTitle();
    }
}
