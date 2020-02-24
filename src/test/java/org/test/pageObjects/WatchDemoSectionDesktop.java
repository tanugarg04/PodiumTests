package org.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.test.ComponentBase;

public class WatchDemoSectionDesktop extends ComponentBase {

    private By firstNameBy = By.cssSelector("#FirstName");
    private By lastNameBy = By.cssSelector("#LastName");
    private By emailBy = By.cssSelector("#Email");
    private By companyBy = By.cssSelector("#Company");
    private By mobileBy = By.cssSelector("#MobilePhone");

    public WatchDemoSectionDesktop(WebDriver driver) {
        super(driver);
    }


    public void enterName(String firstName, String lastName) {
        getDriver().findElement(firstNameBy).sendKeys(firstName);
        getDriver().findElement(lastNameBy).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        getDriver().findElement(emailBy).sendKeys(email);
    }

    public void enterCompany(String companyName) {
        getDriver().findElement(companyBy).sendKeys(companyName);
    }

    public void enterMobile(String phoneNumber) {
        getDriver().findElement(mobileBy).sendKeys(phoneNumber);
    }
}
