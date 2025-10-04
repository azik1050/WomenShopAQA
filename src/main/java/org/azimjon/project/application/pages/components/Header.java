package org.azimjon.project.application.pages.components;

import lombok.extern.slf4j.Slf4j;
import org.azimjon.project.application.pages.AuthenticationPage;
import org.azimjon.project.application.pages.BasePage;
import org.azimjon.project.application.pages.ContactUsPage;
import org.azimjon.project.core.common_components.BaseElement;
import org.openqa.selenium.By;


public class Header extends BasePage {
    private final BaseElement signInButton;
    private final BaseElement logoutButton;
    private final BaseElement contactUsButton;

    public Header() {
        signInButton = new BaseElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']"));
        logoutButton = new BaseElement(By.className("logout"));
        contactUsButton = new BaseElement(By.id("contact-link"));
    }

    public ContactUsPage clickContactUsButton() {
        contactUsButton.click();
        return new ContactUsPage();
    }

    public AuthenticationPage clickSignInButton() {
        signInButton.click();
        return new AuthenticationPage();
    }

    public Header clickLogoutButton() {
        logoutButton.click();
        return this;
    }
}
