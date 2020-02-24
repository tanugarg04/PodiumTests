package org.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.test.ComponentBase;

import java.util.ArrayList;
import java.util.List;

public class MainNavBarMobile extends ComponentBase {

    private By subsectionBy = By.cssSelector(".responsive-submenu#responsiveSubmenu ul li a.pod-accordion-title");
    private By reviewsBy = By.cssSelector(".pod-accordion-content a[href='/reviews/']");
    private By webchatBy = By.cssSelector(".pod-accordion-content a[href='/webchat/']");
    private By feedbackBy = By.cssSelector(".pod-accordion-content a[href='/feedback/']");
    private By teamchatBy = By.cssSelector(".pod-accordion-content a[href='/teamchat/']");
    private By inboxBy = By.cssSelector(".pod-accordion-content a[href='/interaction-platform/']");
    private By hamburgerBy = By.cssSelector(".mobile-ham");
    private By solutionsBy = By.cssSelector(".responsive-submenu#responsiveSubmenu ul li a.pod-accordion-title[href='/solutions/teams/']");
    private By navstyleBy = By.cssSelector(".pod-accordion-content .strip-nav-style");
    private By ebookBy = By.cssSelector(".pod-accordion-content a[href='/ebooks/']");

    @FindBy(css = ".demo-header a[href='https://accounts.podium.com/']")
    private WebElement login;

    @FindBy(css = ".demo-header .primary-button a")
    private WebElement watchDemoHref;

    @FindBy(css = ".demo-header .primary-button")
    private WebElement watchDemo;

    public MainNavBarMobile(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductsList() {
        getDriver().findElement(hamburgerBy).click();
        getDriver().findElement(subsectionBy).click();
        ArrayList<String> productList = new ArrayList<>();
        productList.add(getDriver().findElement(reviewsBy).getText());
        productList.add(getDriver().findElement(webchatBy).getText());
        productList.add(getDriver().findElement(feedbackBy).getText());
        productList.add(getDriver().findElement(teamchatBy).getText());
        productList.add(getDriver().findElement(inboxBy).getText());
        return productList;
    }

    public List<String> getResourcesList() {
        getDriver().findElement(hamburgerBy).click();
        getDriver().findElement(solutionsBy).click();
        ArrayList<String> resourceList = new ArrayList<>();
        resourceList.add(getDriver().findElement(navstyleBy).getText());
        resourceList.add(getDriver().findElement(ebookBy).getText());
        return resourceList;

    }

    public void clickLogin() {
        getDriver().findElement(hamburgerBy).click();
        login.click();
    }

    public String getURL() {
        return getDriver().getCurrentUrl();
    }

    public String getDemoHref() {
        return watchDemoHref.getAttribute("href");
    }

    public boolean isWatchDemoClickable() {
        return watchDemo.isEnabled();
    }
}