package org.vivek.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import org.vivek.pageobjects.LoginPageActions;
import org.vivek.utilities.ReadConfigFiles;

import java.time.Duration;

public class BaseClass {

    ReadConfigFiles readConfig = new ReadConfigFiles();
    protected WebDriver driver;
    protected Logger log;
    protected LoginPageActions loginPage;

    @Parameters(value = "browser")
    @BeforeMethod
    public void setup(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(readConfig.getBaseUrl());

        log = LogManager.getLogger(getClass());
        log.info("Successfully launched: {}", readConfig.getBaseUrl());

        // LOGIN
        loginMethod();
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            log.info("Driver quit successfully after test execution!");
        } else {
            log.warn("Driver instance was null during teardown execution!");
        }
        log.info("-------------------------------------------------------------");
    }

    // LOGIN METHOD
    public void loginMethod() {
        loginPage = new LoginPageActions(driver);
        loginPage.login(readConfig.getUsername(), readConfig.getPassword());
        log.info("Login successful for the user: {}", readConfig.getUsername());
    }
}
