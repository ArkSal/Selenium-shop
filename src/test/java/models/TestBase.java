package models;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TestBase {
    protected WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        logger.info("WebDriver initialized");
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        logger.info("Driver initialized with additional options");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("Driver quit done properly");
    }
}
