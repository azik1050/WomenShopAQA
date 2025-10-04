package org.azimjon.project.ui;

import io.qameta.allure.*;
import org.azimjon.project.application.entities.User;
import org.azimjon.project.application.entities.UserFactory;
import org.azimjon.project.application.pages.MyAccountPage;
import org.azimjon.project.application.steps.AuthenticationSteps;
import org.azimjon.project.core.config.TestConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("Authorization")
@Story("Sing In")
public class TestSignInFlow {
    private final AuthenticationSteps authenticationSteps = new AuthenticationSteps();
    private final MyAccountPage myAccountPage = new MyAccountPage();
    private final User user = UserFactory.createTestUser();

    @BeforeMethod
    public void openAuthenticationPage() {
        authenticationSteps.getHeader().navigateTo(TestConfig.BASE_UI_URL);
        authenticationSteps.getHeader().clickSignInButton();
        Assert.assertEquals(
                authenticationSteps.getAuthenticationPage().getPageHeadingText(),
                "AUTHENTICATION"
        );
    }

    @Severity(SeverityLevel.CRITICAL)
    @Feature("Successful login")
    @Test(groups = {"ui", "smoke", "positive"})
    public void testSuccessfulSIngIn() {
        authenticationSteps.login(user);
        Assert.assertEquals(myAccountPage.getPageHeadingText(), "MY ACCOUNT");
        authenticationSteps.logout();
    }
}
