package org.azimjon.project.core.common_components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class Dropdown extends BaseElement {
    public Dropdown(By locator) {
        super(locator);
    }

    public void selectByIndex(int index) {
        Select select = new Select(getElement());
        select.selectByIndex(index);
    }

    public void selectByText(String text) {
        Select select = new Select(getElement());
        select.selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        Select select = new Select(getElement());
        select.selectByValue(value);
    }
}
