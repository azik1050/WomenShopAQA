package org.azimjon.project.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.azimjon.project.application.pages.CategoryPage;
import org.azimjon.project.application.pages.components.Header;
import org.azimjon.project.core.config.TestConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("UI")
@Story("Navigation")
public class TestNavigationPanel {
    private final Header header = new Header();
    private final CategoryPage categoryPage = new CategoryPage();

    @BeforeMethod
    public void openHomePage() {
        header.navigateTo(TestConfig.BASE_UI_URL);
    }


    @Feature("Women category UI")
    @Test(groups = {"ui", "regression", "positive"})
    public void testWomenTabLinksPresence() {
        header.getWomenCategoryButton().hover();
        Assert.assertTrue(header.getShirtsLink().isVisible());
        Assert.assertTrue(header.getTopsLink().isVisible());
        Assert.assertTrue(header.getCasualDressesLink().isVisible());
        Assert.assertTrue(header.getSummerDressesLink().isVisible());
        Assert.assertTrue(header.getEveningDressesLink().isVisible());
    }

    @Feature("Navigation")
    @Test(groups = {"ui", "regression", "positive"})
    public void testNavigationToShirtsCategory() {
        header.getWomenCategoryButton().hover();
        header.getShirtsLink().click();
        Assert.assertTrue(categoryPage.getCategoryTitle().isVisible());
        Assert.assertEquals(categoryPage.getCategoryTitle().getText(), "T-shirts");
    }

    // TODO: finish tests for each link
    @Feature("Navigation")
    @Test(groups = {"ui", "regression", "positive"})
    public void testNavigationToTopsCategory() {
        header.getWomenCategoryButton().hover();
        header.getShirtsLink().click();
        Assert.assertTrue(categoryPage.getCategoryTitle().isVisible());
        Assert.assertEquals(categoryPage.getCategoryTitle().getText(), "T-shirts");
    }
}
