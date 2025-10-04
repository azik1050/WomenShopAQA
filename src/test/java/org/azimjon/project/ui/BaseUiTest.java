package org.azimjon.project.ui;

import io.qameta.allure.testng.AllureTestNg;
import org.azimjon.project.core.driver.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


@Listeners({AllureTestNg.class})
public class BaseUiTest {
    @BeforeSuite
    public void setUp() {
        Driver.getDriver();
    }

    @AfterSuite
    public void tearDown() {
        Driver.tearDown();
    }
}
