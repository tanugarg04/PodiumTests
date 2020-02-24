package org.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.test.ComponentBase;

public class PodiumHomePageMobile extends ComponentBase {

    @FindBy(css = "#theme-white")
    private WebElement rootElement;

    private By navBarID = By.cssSelector(".main-navigation#site-navigation");

    public PodiumHomePageMobile(WebDriver driver) {
        super(driver);
        getPageFactory().initElements(driver, this);
    }


    public String getTitle() {
        return getDriver().getTitle();
    }

    public MainNavBarMobile getMainNavBar() {
        WebElement siteHeaderElement = getRootElement().findElement(navBarID);
        return getPageFactory().initElements(getDriver(), MainNavBarMobile.class);
    }

    private WebElement getRootElement() {
        return rootElement;
    }
}
