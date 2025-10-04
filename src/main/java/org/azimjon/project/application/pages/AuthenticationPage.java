package org.azimjon.project.application.pages;

import org.azimjon.project.application.pages.CreateAccountPage;
import org.azimjon.project.application.steps.CreateAccountSteps;
import org.azimjon.project.core.common_components.BaseElement;
import org.azimjon.project.core.common_components.Button;
import org.azimjon.project.core.common_components.Input;
import org.openqa.selenium.By;


public class AuthenticationPage extends BasePage {
    private final Input emailCreationInput;
    private final Input emailConfirmationInput;
    private final Input passwordConfirmaitonInput;
    private final Button signInButton;
    private final Button createAccountButton;
    private final BaseElement pageHeading;

    public AuthenticationPage() {
        emailCreationInput = new Input(By.id("email_create"));
        emailConfirmationInput = new Input(By.id("email"));
        passwordConfirmaitonInput = new Input(By.id("passwd"));
        signInButton = new Button(By.id("SubmitLogin"));
        createAccountButton = new Button(By.id("SubmitCreate"));
        pageHeading = new BaseElement(By.className("page-heading"));
    }

    public String getPageHeadingText() {
        return pageHeading.getText();
    }

    public AuthenticationPage fillEmailCreationInput(String text) {
        emailCreationInput.fill(text);
        return this;
    }

    public AuthenticationPage fillEmailConfirmationInput(String text) {
        emailConfirmationInput.fill(text);
        return this;
    }

    public AuthenticationPage fillPasswordConfirmationInput(String text) {
        passwordConfirmaitonInput.fill(text);
        return this;
    }

    public AuthenticationPage clickSingInButton() {
        signInButton.click();
        return this;
    }

    public CreateAccountPage clickCreateAccountButton() {
        createAccountButton.click();
        return new CreateAccountPage();
    }
}
