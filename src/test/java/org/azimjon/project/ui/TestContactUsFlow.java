package org.azimjon.project.ui;

import org.azimjon.project.application.entities.UserFactory;
import org.azimjon.project.application.pages.ContactUsPage;
import org.azimjon.project.application.pages.HomePage;
import org.azimjon.project.application.pages.components.Footer;
import org.azimjon.project.application.pages.components.Header;
import org.azimjon.project.application.steps.AuthenticationSteps;
import org.azimjon.project.application.steps.ContactUsSteps;
import org.azimjon.project.core.config.TestConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestContactUsFlow {
    private final Header header = new Header();
    private final ContactUsPage contactUsPage = new ContactUsPage();
    private final ContactUsSteps contactUsSteps = new ContactUsSteps();
    private final AuthenticationSteps authenticationSteps = new AuthenticationSteps();

    @DataProvider(name = "formData")
    public Object[][] geFormData() {
        Path fileLocation = Paths.get("src", "test", "resources", "files", "fiol.jpeg");
        return new Object[][]{
                {"test@gmail.ru", fileLocation.toAbsolutePath().toString(), "Customer service", "Lorem ipsum dolor"},
                {"test@gmail.ru", fileLocation.toAbsolutePath().toString(), "Customer service", "Lorem ipsum dolor"}
        };
    }

    @BeforeClass
    public void login() {
        header.navigateTo(TestConfig.BASE_UI_URL);
        header.clickSignInButton();
        authenticationSteps.login(UserFactory.createTestUser());
    }

    @BeforeMethod
    public void reachContactUsPage() {
        header.navigateTo(TestConfig.BASE_UI_URL);
        header.clickContactUsButton();
    }

    @Test(groups = {"regression", "ui", "positive"}, priority = 0, dataProvider = "formData")
    public void testSubmitFormAsAuthorizedUser(
            String email,
            String fileLocation,
            String subject,
            String mainMessage
    ) {
        contactUsSteps
                .fillMessageForm(subject, fileLocation, mainMessage)
                .submitMessage();
        Assert.assertTrue(contactUsPage.getPopupMessage().isVisible());
    }

    @Test(groups = {"regression", "ui", "positive"}, priority = 1, dataProvider = "formData")
    public void testSubmitFormAsUnauthorizedUser(
            String email,
            String fileLocation,
            String subject,
            String mainMessage
    ) {
        authenticationSteps.logout();
        contactUsSteps
                .fillMessageForm(subject, fileLocation, mainMessage, email)
                .submitMessage();
        Assert.assertTrue(contactUsPage.getPopupMessage().isVisible());
    }

    @Test(groups = {"regression", "ui", "negative"}, priority = 2, dataProvider = "formData")
    public void testSubmitFormWithoutSubject(
            String email,
            String fileLocation,
            String subject,
            String mainMessage
    ) {
        contactUsPage
                .fillEmailInput(email)
                .uploadAttachmentFile(fileLocation)
                .fillMessageInput(mainMessage);
        Assert.assertTrue(contactUsPage.getPopupMessage().isVisible());
    }

}
