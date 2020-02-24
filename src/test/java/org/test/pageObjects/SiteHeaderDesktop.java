package org.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.test.ComponentBase;

public class SiteHeaderDesktop extends ComponentBase {

    private By productDropdownHover = By.cssSelector("#wp-megamenu-item-2312");
    private By solutionsDropdownHover = By.cssSelector("#wp-megamenu-item-2423");
    private By resourcesDropdownHover = By.cssSelector("#wp-megamenu-item-2428");
    private By subMenuBy = By.cssSelector("ul.wp-megamenu-sub-menu");

    @FindBy(css = "li#menu-item-1317")
    private WebElement login;

    @FindBy(css = ".demo-header .primary-button a")
    private WebElement watchDemoHref;

    @FindBy(css = ".demo-header .primary-button")
    private WebElement watchDemo;

    public SiteHeaderDesktop(WebDriver driver) {
        super(driver);
    }

    public String getProductsList() {
        return getHoverItems(productDropdownHover);
    }

    public String getSolutionsList() {
        return getHoverItems(solutionsDropdownHover);
    }

    public String getResourcesList() {
        return getHoverItems(resourcesDropdownHover);
    }


    private String getHoverItems(By productDropdownHover) {
        WebDriver driver = getDriver();
        Actions action = new Actions(driver);
        WebElement target = driver.findElement(productDropdownHover);
        action.moveToElement(target).perform();
        return target.getText();
    }

    public void clickLogin() {
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
