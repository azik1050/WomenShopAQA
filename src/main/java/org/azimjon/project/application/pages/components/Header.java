package org.azimjon.project.application.pages.components;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.azimjon.project.application.pages.AuthenticationPage;
import org.azimjon.project.application.pages.BasePage;
import org.azimjon.project.application.pages.ContactUsPage;
import org.azimjon.project.core.common_components.BaseElement;
import org.azimjon.project.core.common_components.Button;
import org.openqa.selenium.By;


public class Header extends BasePage {
    private final BaseElement signInButton;
    private final BaseElement logoutButton;
    private final BaseElement contactUsButton;

    @Getter
    private final Button womenCategoryButton;
    @Getter
    private final BaseElement shirtsLink;
    @Getter
    private final BaseElement topsLink;
    @Getter
    private final BaseElement casualDressesLink;
    @Getter
    private final BaseElement eveningDressesLink;
    @Getter
    private final BaseElement summerDressesLink;


    public Header() {
        signInButton = new BaseElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']"));
        logoutButton = new BaseElement(By.className("logout"));
        contactUsButton = new BaseElement(By.id("contact-link"));

        womenCategoryButton = new Button(By.xpath("//a[@title='Women']"));
        shirtsLink = new BaseElement(By.xpath("//a[@title='T-shirts']"));
        topsLink = new BaseElement(By.xpath("//a[@title='Tops']"));
        casualDressesLink = new BaseElement(By.xpath("//a[@title='Casual Dresses']"));
        eveningDressesLink = new BaseElement(By.xpath("//a[@title='Evening Dresses']"));
        summerDressesLink = new BaseElement(By.xpath("//a[@title='Summer Dresses']"));
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
