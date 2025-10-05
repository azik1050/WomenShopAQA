package org.azimjon.project.core.common_components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class Dropdown extends BaseElement {
    public Dropdown(By locator) {
        super(locator);
    }

    public void selectByIndex(int index) {
        new Select(getElement())
                .selectByIndex(index);
    }

    public void selectByText(String text) {
        new Select(getElement())
                .selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        new Select(getElement())
                .selectByValue(value);
    }
}
