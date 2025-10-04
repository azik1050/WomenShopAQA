package org.azimjon.project.core.common_components;

import org.openqa.selenium.By;

public class RadioButton extends Button {
    public RadioButton(By locator) {
        super(locator);
    }

    public boolean isSelected() {
        return getElement().isSelected();
    }
}
