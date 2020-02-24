package org.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.test.TestBase;
import org.test.pageObjects.PodiumHomePageDesktop;
import org.test.pageObjects.SiteHeaderDesktop;
import org.test.pageObjects.WatchDemoSectionDesktop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PodiumDesktopTest extends TestBase {
    public static final String PRODUCT_DROPDOWN_ITEMS = "Products\n" +
            "Reviews\n" +
            "Webchat\n" +
            "Feedback\n" +
            "Teamchat\n" +
            "Inbox";
    public static final String SOLUTIONS_DROPDOWN_ITEMS = "Solutions\n" +
            "Win More Leads\n" +
            "Earn Repeat Customers\n" +
            "Do More as a Team\n" +
            "Centralize Interactions";
    public static final String RESOURCES_DROPDOWN_ITEMS = "Resources\n" +
            "Customer Stories\n" +
            "Ebooks";

    private WebDriver driver;
    private PodiumHomePageDesktop homePageDesktop;

    @Before
    public void setUp() {
        driver = getWebDriver(false);
        driver.get(baseUrl);
        homePageDesktop = new PodiumHomePageDesktop(driver);
    }

    @Test
    public void testHomePageLoad() {
        String pageTitle = homePageDesktop.getTitle();
        assertTrue("Got empty page Title", StringUtils.isNotBlank(pageTitle));
        assertTrue("Title different than expectation",
                pageTitle.equals("Interaction Management for Local Business | Reviews, SMS, Feedback | Podium"));
        assertTrue("Page URL not same, probably got redirected", driver.getCurrentUrl().equals(baseUrl));
    }

    @Test
    public void testProductDropDown() {
        String productNames = homePageDesktop.getSiteHeader().getProductsList();
        assertTrue(StringUtils.isNotBlank(productNames));
        assertTrue(productNames.equals(PRODUCT_DROPDOWN_ITEMS));
    }

    @Test
    public void testSolutionsDropDown() {
        String soultionsNames = homePageDesktop.getSiteHeader().getSolutionsList();
        assertTrue(StringUtils.isNotBlank(soultionsNames));
        assertTrue(soultionsNames.equals(SOLUTIONS_DROPDOWN_ITEMS));
    }

    @Test
    public void testResourcesDropDown() {
        String resourcesNames = homePageDesktop.getSiteHeader().getResourcesList();
        assertTrue(StringUtils.isNotBlank(resourcesNames));
        assertTrue(resourcesNames.equals(RESOURCES_DROPDOWN_ITEMS));
    }

    @Test
    public void testWatchDemo() {
        SiteHeaderDesktop siteHeader = homePageDesktop.getSiteHeader();
        String expected = "https://learn.podium.com/watch3now";
        assertEquals("Incorrect demo href", expected, siteHeader.getDemoHref());
        assertTrue("Watch Demo is not enabled", siteHeader.isWatchDemoClickable());
    }

    @Test
    public void testLogin() {
        SiteHeaderDesktop siteHeader = homePageDesktop.getSiteHeader();
        siteHeader.clickLogin();
        String expected = "https://auth.podium.com/";
        assertTrue("Did not navigate to the correct URL", expected.equals(siteHeader.getURL()));
    }

    @Test
    public void testDemoForm() {
        WatchDemoSectionDesktop watchDemoSectionDesktop = homePageDesktop.getWatchDemoSection();
        watchDemoSectionDesktop.enterName("John", "Smith");
        watchDemoSectionDesktop.enterEmail("johnsmith@gmail.com");
        watchDemoSectionDesktop.enterCompany("Podium");
        watchDemoSectionDesktop.enterMobile("201-000-0000");
        //Form submission not done purposely
    }
}
