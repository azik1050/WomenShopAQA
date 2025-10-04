package org.azimjon.project.ui;

import io.qameta.allure.*;
import org.azimjon.project.application.entities.User;
import org.azimjon.project.application.entities.UserFactory;
import org.azimjon.project.application.pages.CreateAccountPage;
import org.azimjon.project.application.pages.MyAccountPage;
import org.azimjon.project.application.steps.AuthenticationSteps;
import org.azimjon.project.core.config.TestConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



@Epic("Authorization")
@Story("Sing In")
public class TestSignUpFlow {
    private final AuthenticationSteps authenticationSteps = new AuthenticationSteps();
    private final CreateAccountPage createAccountPage = new CreateAccountPage();

    @BeforeMethod
    public void reachUserCreationPage() {
        authenticationSteps.getHeader().navigateTo(TestConfig.BASE_UI_URL);
        authenticationSteps.getHeader().clickSignInButton();
        Assert.assertEquals(
                authenticationSteps.getAuthenticationPage().getPageHeadingText(),
                "AUTHENTICATION"
        );
    }

    @Severity(SeverityLevel.CRITICAL)
    @Feature("Successful sign up")
    @Test(groups = {"smoke", "ui", "positive"}, priority = 1)
    public void testSuccessfulSignUp() {
        User user = UserFactory.createRandomUser();

        MyAccountPage myAccountPage = authenticationSteps
                .createAccount(user.getEmail())
                .registerUser(user);
        Assert.assertEquals(myAccountPage.getSuccessAlertText(), "Your account has been created.");
        Assert.assertEquals(myAccountPage.getPageHeadingText(), "MY ACCOUNT");
        authenticationSteps.logout();
    }

    @Severity(SeverityLevel.NORMAL)
    @Feature("Unsuccessful sign up")
    @Test(groups = {"smoke", "ui", "negative"}, priority = 0)
    public void testUnsuccessfulSignUp() {
        User user = UserFactory.createRandomUser();
        user.setPassword("");

        authenticationSteps
                .createAccount(user.getEmail())
                .registerUser(user);
        Assert.assertTrue(createAccountPage.getErrorMessage().isVisible());
    }
}
