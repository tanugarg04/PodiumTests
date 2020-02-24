package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComponentBase {

    private WebDriver driver;
    private PageFactory pageFactory;
    private Wait wait;
    private Actions actions;

    public ComponentBase(WebDriver driver) {
        this.driver = driver;
        this.pageFactory = new PageFactory();
        this.wait = new WebDriverWait(driver, 5);
        this.actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public PageFactory getPageFactory() {
        return pageFactory;
    }

    public Wait getWait() {
        return wait;
    }

    public Actions getActions() {
        return actions;
    }
}
