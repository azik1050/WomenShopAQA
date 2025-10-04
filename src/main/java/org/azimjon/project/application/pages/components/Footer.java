package org.azimjon.project.application.pages.components;

import org.azimjon.project.application.pages.BasePage;
import org.azimjon.project.core.common_components.Button;
import org.azimjon.project.core.common_components.Input;
import org.openqa.selenium.By;

public class Footer extends BasePage {
    private final Input emailInput;
    private final Button nextButton;

    public Footer() {
        emailInput = new Input(By.id("newsletter-input"));
        nextButton = new Button(By.xpath("//button[@name='submitNewsletter']"));
    }

    public Footer fillEmailInput(String text) {
        emailInput.fill(text);
        return this;
    }

    public Footer clickNextButton() {
        nextButton.click();
        return this;
    }
}
