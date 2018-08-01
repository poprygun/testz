package io.microsamples.testz;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

class AutomationE2ETest {

    private static ChromeDriverService service;
    private WebDriver driver;

    @BeforeAll
    static void createAndStartService() throws Exception {

        File driverFile = getResourceAsFile("chromedriver");

        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(driverFile)
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterAll
    static void stopService() {
        service.stop();
    }

    @BeforeEach
    void createDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.setHeadless(true);
        driver = new RemoteWebDriver(service.getUrl(), caps);
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }

    @Test
    public void validateElement() {
        driver.get("http://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>a")));
        assertTrue(firstResult.getText().toLowerCase().contains("cheese"));
    }

    private static File getResourceAsFile(String resourcePath) {
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourcePath);
            if (in == null) {
                return null;
            }

            File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
            tempFile.deleteOnExit();

            try (FileOutputStream out = new FileOutputStream(tempFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            tempFile.setExecutable(true);
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
