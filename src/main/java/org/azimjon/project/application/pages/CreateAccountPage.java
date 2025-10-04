package org.azimjon.project.application.pages;

import org.azimjon.project.core.common_components.*;
import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage {
    private final BaseElement pageHeading;
    private final RadioButton maleRadioButton;
    private final RadioButton femaleRadioButton;
    private final Input firstNameInput;
    private final Input lastNameInput;
    private final Input emailInput;
    private final Input passwordInput;
    private final Dropdown daysDropdown;
    private final Dropdown monthsDropdown;
    private final Dropdown yearsDropdown;
    private final Button registerButton;
    private final BaseElement errorMessage;

    public CreateAccountPage() {
        pageHeading = new BaseElement(By.className("page-heading"));
        maleRadioButton = new RadioButton(By.id("id_gender1"));
        femaleRadioButton = new RadioButton(By.id("id_gender2"));
        firstNameInput = new Input(By.id("customer_firstname"));
        lastNameInput = new Input(By.id("customer_lastname"));
        emailInput = new Input(By.id("email"));
        passwordInput = new Input(By.id("passwd"));
        daysDropdown = new Dropdown(By.id("days"));
        monthsDropdown = new Dropdown(By.id("months"));
        yearsDropdown = new Dropdown(By.id("years"));
        registerButton = new Button(By.id("submitAccount"));
        errorMessage = new BaseElement(By.xpath("//div[@class='alert alert-danger']"));
    }

    public String getPageHeadingText() {
        return pageHeading.getText();
    }

    public CreateAccountPage clickMaleRadioButton() {
        maleRadioButton.click();
        return this;
    }

    public CreateAccountPage clickFemaleRadioButton() {
        femaleRadioButton.click();
        return this;
    }

    public CreateAccountPage fillFirstNameInput(String text) {
        firstNameInput.fill(text);
        return this;
    }

    public CreateAccountPage fillLastNameInput(String text) {
        lastNameInput.fill(text);
        return this;
    }

    public CreateAccountPage fillEmailInput(String text) {
        emailInput.fill(text);
        return this;
    }

    public CreateAccountPage fillPasswordInput(String text) {
        passwordInput.fill(text);
        return this;
    }

    public CreateAccountPage selectBirthDay(String day) {
        daysDropdown.selectByValue(day);
        return this;
    }

    public CreateAccountPage selectBirthMonth(String month) {
        monthsDropdown.selectByValue(month);
        return this;
    }

    public CreateAccountPage selectBirthYear(String year) {
        yearsDropdown.selectByValue(year);
        return this;
    }

    public CreateAccountPage clickRegisterButton() {
        registerButton.click();
        return this;
    }

    public BaseElement getErrorMessage() {
        return errorMessage;
    }
}
