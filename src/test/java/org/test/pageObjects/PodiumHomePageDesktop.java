package org.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.test.ComponentBase;

public class PodiumHomePageDesktop extends ComponentBase {

    @FindBy(css = "#theme-white")
    private WebElement rootElement;

    private By siteHeaderID = By.cssSelector("#masthead");
    private By watchDemoSectionID = By.cssSelector(".watch-demo-section");

    public PodiumHomePageDesktop(WebDriver driver) {
        super(driver);
        getPageFactory().initElements(driver, this);
    }

    public SiteHeaderDesktop getSiteHeader() {
        WebElement siteHeaderElement = getRootElement().findElement(siteHeaderID);
        return getPageFactory().initElements(getDriver(), SiteHeaderDesktop.class);
    }

    private WebElement getRootElement() {
        return rootElement;
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public WatchDemoSectionDesktop getWatchDemoSection() {
        WebElement watchDemoSectionElement = getRootElement().findElement(watchDemoSectionID);
        return getPageFactory().initElements(getDriver(), WatchDemoSectionDesktop.class);
    }
}
