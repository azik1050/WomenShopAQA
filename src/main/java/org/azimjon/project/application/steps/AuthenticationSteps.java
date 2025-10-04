package org.azimjon.project.application.steps;

import io.qameta.allure.Step;
import org.azimjon.project.application.pages.components.Header;
import org.azimjon.project.application.entities.User;
import org.azimjon.project.application.pages.AuthenticationPage;


public class AuthenticationSteps {
    private final Header header;
    private final AuthenticationPage authenticationPage;

    public AuthenticationSteps() {
        header = new Header();
        authenticationPage = new AuthenticationPage();
    }

    @Step("Create account with {email} email")
    public CreateAccountSteps createAccount(String email) {
        authenticationPage
                .fillEmailCreationInput(email)
                .clickCreateAccountButton();
        return new CreateAccountSteps();
    }

    @Step("Login as {user.firstName}")
    public AuthenticationSteps login(User user) {
        authenticationPage
                .fillEmailConfirmationInput(user.getEmail())
                .fillPasswordConfirmationInput(user.getPassword())
                .clickSingInButton();
        return this;
    }

    @Step("Logout")
    public AuthenticationSteps logout() {
        header.clickLogoutButton();
        return this;
    }

    public Header getHeader() {
        return header;
    }

    public AuthenticationPage getAuthenticationPage() {
        return authenticationPage;
    }

}
