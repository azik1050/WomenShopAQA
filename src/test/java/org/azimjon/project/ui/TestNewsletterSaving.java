package org.azimjon.project.ui;

import org.azimjon.project.application.pages.HomePage;
import org.azimjon.project.application.pages.components.Footer;
import org.azimjon.project.core.config.TestConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.*;


@Epic("Newsletter saving")
@Story("Sing In")
public class TestNewsletterSaving {
    private final HomePage homePage = new HomePage();
    private final Footer footer = new Footer();

    private final String SUCCESS_MESSAGE = "Newsletter : You have successfully subscribed to this newsletter.";
    private final String INVALID_EMAIL_MESSAGE = "Newsletter : Invalid email address.";
    private final String ALREADY_REGISTERED_MESSAGE = "Newsletter : This email address is already registered.";

    @BeforeMethod
    public void openHomePage() {
        homePage.navigateTo(TestConfig.BASE_UI_URL);
    }

    @DataProvider(name = "data")
    public Object[][] testData() {
        return new Object[][] {
                {"vaslka@mail.ru", SUCCESS_MESSAGE},
                {"kuzmichek@gmail.com", SUCCESS_MESSAGE},
                {"kuzmich@gmail.com", ALREADY_REGISTERED_MESSAGE},
                {"vasya", INVALID_EMAIL_MESSAGE},
                {"@gmail", INVALID_EMAIL_MESSAGE}
        };
    }

    @Severity(SeverityLevel.MINOR)
    @Feature("Save email")
    @Test(groups = {"ui", "regression"}, dataProvider = "data")
    public void testSaveEmail(String email, String message) {
        homePage.navigateTo(TestConfig.BASE_UI_URL);
        footer.fillEmailInput(email)
                .clickNextButton();

        Assert.assertTrue(homePage.getPopupMessage().isDisplayed());
        Assert.assertEquals(homePage.getPopupMessage().getText(), message);
    }
}
