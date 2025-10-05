package org.azimjon.project.application.pages;

import org.azimjon.project.core.common_components.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {
    private final BaseElement popupMessage;

    public HomePage() {
        popupMessage = new BaseElement(By.xpath("//p[starts-with(@class, 'alert')]"));
    }

    public WebElement getPopupMessage() {
        return popupMessage.getElement();
    }

}
