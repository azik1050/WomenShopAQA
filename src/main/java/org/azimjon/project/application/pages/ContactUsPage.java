package org.azimjon.project.application.pages;

import lombok.Getter;
import org.azimjon.project.core.common_components.BaseElement;
import org.azimjon.project.core.common_components.Button;
import org.azimjon.project.core.common_components.Dropdown;
import org.azimjon.project.core.common_components.Input;
import org.azimjon.project.core.utils.WaitUtils;
import org.openqa.selenium.By;


public class ContactUsPage extends BasePage {
    private final Dropdown subjectDropdown;
    @Getter
    private final Input emailAddressInput;
    private final Input fileUploadInput;
    private final Input messageInput;
    private final Button submitButton;
    private final BaseElement subjectDescriptionText;
    @Getter
    private final BaseElement popupMessage;

    public ContactUsPage() {
        subjectDropdown = new Dropdown(By.id("id_contact"));
        emailAddressInput = new Input(By.id("email"));
        fileUploadInput = new Input(By.id("fileUpload"));
        messageInput = new Input(By.id("message"));
        submitButton = new Button(By.id("submitMessage"));
        subjectDescriptionText = new BaseElement(By.xpath("//p[@id='desc_contact2']//i"));
        popupMessage = new BaseElement(By.xpath("//p[starts-with(@class, 'alert')]"));
    }

    public BaseElement getSubjectDescription() {
        return subjectDescriptionText;
    }

    public ContactUsPage selectSubjectHeading(String value) {
        subjectDropdown.selectByText(value);
        return this;
    }

    public ContactUsPage selectSubjectHeading(int index) {
        subjectDropdown.selectByIndex(index);
        return this;
    }

    public ContactUsPage uploadAttachmentFile(String fileLocation) {
        fileUploadInput.fill(fileLocation);
        return this;
    }

    public ContactUsPage fillEmailInput(String text) {
        emailAddressInput.fill(text);
        return this;
    }

    public ContactUsPage fillMessageInput(String text) {
        messageInput.fill(text);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
        WaitUtils.waitForSeconds(10);
    }
}
