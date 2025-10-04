package org.azimjon.project.core.common_components;

import org.openqa.selenium.By;


public class Input extends BaseElement {
    public Input(By locator) {
        super(locator);
    }

    public void fill(String text) {
        getElement().sendKeys(text);
    }
}
