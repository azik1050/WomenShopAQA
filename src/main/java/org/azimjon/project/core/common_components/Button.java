package org.azimjon.project.core.common_components;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Button extends BaseElement {
    public Button(By locator) {
        super(locator);
    }

    public Button hover() {
        new Actions(driver)
                .clickAndHold(getElement()).perform();
        return this;
    }
}
