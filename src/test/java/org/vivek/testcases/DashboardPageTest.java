package org.vivek.testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import org.vivek.pageobjects.DashboardPageActions;
import org.vivek.pageobjects.TimePageActions;

import java.util.List;

public class DashboardPageTest extends BaseClass{

    protected DashboardPageActions dashboardPage;
    protected TimePageActions timePage;

    @BeforeMethod
    public void initPageObject() {
        dashboardPage = new DashboardPageActions(driver);
        timePage = new TimePageActions(driver);
    }

    @Test(priority = 0)
    public void verifyUserLoginSuccessful() {
        Assert.assertEquals(dashboardPage.getDashboardLabel(), "Dashboard", "User login failed - Incorrect dashboard label");
        log.info("User login successful");
    }

    @Test(priority = 1)
    public void verifyMyTimesheetIsAccessible() {
        dashboardPage.clickMyTimesheetInQuickLaunchSection();
        log.info("'My Timesheet' option clicked");
        List<String> expectedHeadersList = List.of("Time", "Timesheets");
        List<String> actualHeadersList = timePage.getTimePageHeader();
        Assert.assertEquals(actualHeadersList, expectedHeadersList, "Failed to load 'Time/Timesheet' page");
        log.info("'Time/Timesheet' page is loaded");
    }
}
