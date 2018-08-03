package io.microsamples.testz.automation;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

class E2EUsingRemoteGridServerTest {

    private WebDriver driver;
    private static final String SELENIUM_GRID_URL = "http://seleium-server.cfapps.io/wd/hub";


    @BeforeEach
    void createDriver() throws MalformedURLException {
        ChromeOptions caps = new ChromeOptions();
        caps.setHeadless(true);
        driver = new RemoteWebDriver(getSeleniumServiceUrl(), caps);
    }

    protected URL getSeleniumServiceUrl() throws MalformedURLException {
        return new URL(SELENIUM_GRID_URL);
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }

    @Test
    public void shouldFindCheese() {
        driver.get("http://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>a")));
        assertTrue(firstResult.getText().toLowerCase().contains("cheese"));
    }
}
