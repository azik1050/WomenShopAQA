package org.azimjon.project.application.pages;

import org.azimjon.project.core.common_components.BaseElement;
import org.openqa.selenium.By;

public class MyAccountPage extends BasePage {
    private final BaseElement pageHeading;
    private final BaseElement successAlert;

    public MyAccountPage() {
        pageHeading = new BaseElement(By.className("page-heading"));
        successAlert = new BaseElement(By.xpath("//p[@class='alert alert-success']"));
    }

    public String getPageHeadingText() {
        return pageHeading.getText();
    }

    public String getSuccessAlertText() {
        return successAlert.getText();
    }
}
