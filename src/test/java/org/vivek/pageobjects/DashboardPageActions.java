package org.vivek.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.vivek.pagelocators.DashboardPageLocators;

import java.time.Duration;

public class DashboardPageActions extends DashboardPageLocators {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public DashboardPageActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // DASHBOARD PAGE ACTION METHODS
    public String getDashboardLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).getText();
    }

    public void clickMyTimesheetInQuickLaunchSection() {
        driver.findElement(quickLaunchMyTimesheet).click();
    }
}
