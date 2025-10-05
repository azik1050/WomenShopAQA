package org.azimjon.project.application.pages;

import lombok.Getter;
import org.azimjon.project.core.common_components.BaseElement;
import org.openqa.selenium.By;

public class CategoryPage extends BasePage {
    @Getter
    private final BaseElement categoryTitle;

    public CategoryPage() {
        categoryTitle = new BaseElement(By.className("category-name"));
    }
}
