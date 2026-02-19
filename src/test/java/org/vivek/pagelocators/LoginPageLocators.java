package org.vivek.pagelocators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    protected By usernameField = By.xpath("//input[@name='username']");
    protected By passwordField = By.xpath("//input[@name='password']");
    protected By loginButton = By.xpath("//button[@type='submit']");
}
