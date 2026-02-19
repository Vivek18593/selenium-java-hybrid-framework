package org.vivek.pageobjects;

import org.openqa.selenium.WebDriver;
import org.vivek.pagelocators.LoginPageLocators;

public class LoginPageActions extends LoginPageLocators {

    protected WebDriver driver;

    public LoginPageActions(WebDriver driver) {
        this.driver = driver;
    }

    // LOGIN PAGE ACTION METHODS
    private void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    private void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
