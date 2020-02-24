package org.test;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    public static String baseUrl = "https://www.podium.com/";
    private static String DEFAULT_MOBILE_USER_AGENT_STRING = "Mozilla/5.0 (iPhone; CPU iPhone OS 6_0 like Mac OS X)" +
            " AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5376e Safari/8536.25";
    private WebDriver driver;

    protected WebDriver getWebDriver(boolean mobileBrowser) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver-80.mac");

        if (mobileBrowser) {
            Map<String, Object> deviceMetrics = new HashMap<>();
            deviceMetrics.put("width", 360);
            deviceMetrics.put("height", 640);
            deviceMetrics.put("pixelRatio", 3.0);

            Map<String, Object> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceMetrics", deviceMetrics);
            mobileEmulation.put("userAgent", DEFAULT_MOBILE_USER_AGENT_STRING);

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

            driver = new ChromeDriver(chromeOptions);
        } else {
            driver = new ChromeDriver();
        }
        return driver;
    }

    @After
    public void closeDriverObjects() {
        driver.quit();
    }
}
