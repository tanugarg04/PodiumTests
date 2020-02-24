package org.test;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.test.TestBase;
import org.test.pageObjects.MainNavBarMobile;
import org.test.pageObjects.PodiumHomePageMobile;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PodiumMobileTest extends TestBase {
    public static final List<String> PRODUCT_DROPDOWN_ITEMS = Lists.newArrayList("Reviews",
            "Webchat",
            "Feedback",
            "Teamchat",
            "Inbox");

    private WebDriver driver;
    private PodiumHomePageMobile homePageMobile;

    @Before
    public void setUp() {
        driver = getWebDriver(true);
        driver.get(baseUrl);
        homePageMobile = new PodiumHomePageMobile(driver);
    }

    @Test
    public void testHomePageLoad() {
        String pageTitle = homePageMobile.getTitle();
        assertTrue("Got empty page Title", StringUtils.isNotBlank(pageTitle));
        assertTrue("Title different than expectation",
                pageTitle.equals("Interaction Management for Local Business | Reviews, SMS, Feedback | Podium"));
        assertTrue("Page URL not same, probably got redirected", driver.getCurrentUrl().equals(baseUrl));
    }

    @Test
    public void testProductDropDown() {
        PodiumHomePageMobile podiumHomePageMobile = new PodiumHomePageMobile(driver);
        List<String> productNames = podiumHomePageMobile.getMainNavBar().getProductsList();
        assertEquals(productNames.size(), PRODUCT_DROPDOWN_ITEMS.size());
        assertTrue("Resource dropdown items not matching. Expected: " + PRODUCT_DROPDOWN_ITEMS + " Actual: "
                + productNames, productNames.containsAll(PRODUCT_DROPDOWN_ITEMS));
    }

    @Test
    public void testWatchDemo() {
        PodiumHomePageMobile podiumHomePageMobile = new PodiumHomePageMobile(driver);
        MainNavBarMobile mainNavBarMobile = podiumHomePageMobile.getMainNavBar();

        String expected = "https://learn.podium.com/watch3now";
        assertEquals("Incorrect demo href", expected, mainNavBarMobile.getDemoHref());
        assertTrue("Watch Demo is not enabled", mainNavBarMobile.isWatchDemoClickable());
    }

    @Test
    public void testLogin() {
        PodiumHomePageMobile podiumHomePageMobile = new PodiumHomePageMobile(driver);
        MainNavBarMobile mainNavBarMobile = podiumHomePageMobile.getMainNavBar();
        mainNavBarMobile.clickLogin();
        String expected = "https://auth.podium.com/";
        assertTrue("Did not navigate to the correct URL", expected.equals(mainNavBarMobile.getURL()));
    }
}
