package org.vivek.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.vivek.pagelocators.TimePageLocators;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TimePageActions extends TimePageLocators {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public TimePageActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // TIME PAGE ACTION METHODS
    public List<String> getTimePageHeader() {
        List<WebElement> actualHeaderElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(timePageHeader));
        List<String> actualHeadersList = new ArrayList<>();
        for(WebElement actualHeader : actualHeaderElements) {
            actualHeadersList.addAll(List.of(actualHeader.getText().split("\\n")));
        }
        return actualHeadersList;
    }
}
