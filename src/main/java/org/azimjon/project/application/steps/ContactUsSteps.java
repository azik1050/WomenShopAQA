package org.azimjon.project.application.steps;

import io.qameta.allure.Step;
import org.azimjon.project.application.pages.ContactUsPage;
import org.azimjon.project.application.pages.components.Header;


public class ContactUsSteps {
    private final Header header;
    private final ContactUsPage contactUsPage;

    public ContactUsSteps() {
        header = new Header();
        contactUsPage = new ContactUsPage();
    }

    @Step("Fill message form as an authorized user")
    public ContactUsSteps fillMessageForm(String subject, String fileLocation, String mainMessage) {
        contactUsPage
                .selectSubjectHeading(subject)
                .uploadAttachmentFile(fileLocation)
                .fillMessageInput(mainMessage);
        return this;
    }

    @Step("Fill message form as an unauthorized user")
    public ContactUsSteps fillMessageForm(String subject, String fileLocation, String mainMessage, String email) {
        contactUsPage
                .selectSubjectHeading(subject)
                .fillEmailInput(email)
                .uploadAttachmentFile(fileLocation)
                .fillMessageInput(mainMessage);
        return this;
    }

    @Step("Submit form")
    public ContactUsSteps submitMessage() {
        contactUsPage.clickSubmitButton();
        return this;
    }
}
