package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;

@Epic("Regression Tests")
@Feature("Calendar Tests")
public class CalendarTests extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify calendar button actions and validations")
    @Test(testName = "Calendar test 1")
    public void calendarTest1() {

        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");

        calendarHomePage.clickNewEventButton();
        Assert.assertTrue(newEventPage.newEventPageLoaded(), "New event page is not loaded");

        newEventPage.addNewEventTitle("AI Conference");
        newEventPage.chooseStartDate("24");
        newEventPage.chooseStartHour("11", "10");
        newEventPage.chooseEndDate("25");
        newEventPage.chooseEndHour("12", "25");
        newEventPage.chooseTravelTime("30 minutes");
        newEventPage.clickAllDaySwitchButton();
        Assert.assertFalse(newEventPage.validateStartTimeVisibility(), "Time is visible in `Starts`");
        Assert.assertFalse(newEventPage.validateEndTimeVisibility(), "Time is visible in `Ends`");

        newEventPage.clickAllDaySwitchButton();
        newEventPage.clickAddButton();
        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");

        calendarHomePage.clickBackButton("April");
        calendarHomePage.selectDate("Wednesday, 24 April");
        Assert.assertTrue(dayViewPage.dayViewPageLoaded(), "Day view page is not loaded");

        dayViewPage.validateEventDisplayed("AI Conference");
        dayViewPage.clickBackButton("April");
        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");

        calendarHomePage.selectDate("Thursday, 25 April");
        Assert.assertTrue(dayViewPage.dayViewPageLoaded(), "Day view page is not loaded");

//        dayViewPage.validateEventDisplayed("AI Conference");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify calendar button actions and validations")
    @Test(testName = "Calendar test 2")
    public void calendarTest2() {

        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");

        calendarHomePage.clickCalendarsButton();
        Assert.assertTrue(calendarsPage.calendarsPageLoaded(), "Calendars page is not loaded");

        calendarsPage.clickAddCalendarButton();
        calendarsPage.clickAddCalendarOption();
        Assert.assertTrue(addCalendarPage.addCalendarPageLoaded(), "Add calendar page is not loaded");

        addCalendarPage.addCalendarName("Tasks");
        addCalendarPage.clickColorButton();
        Assert.assertTrue(calendarColorPage.calendarColorPageLoaded(),"Calendar color page is not loaded");

        calendarColorPage.changeCalendarColor("Blue");
        calendarColorPage.clickAddCalendarButton();
        Assert.assertTrue(addCalendarPage.addCalendarPageLoaded(), "Add calendar page is not loaded");

        addCalendarPage.clickDoneButton();
        Assert.assertTrue(calendarsPage.calendarsPageLoaded(), "Calendars page is not loaded");

        calendarsPage.validateCalendarDisplayed("Tasks");
//        calendarsPage.clickHideAllButton();

//        calendarsPage.validateCalendarSelected("Tasks");
//        Assert.assertFalse(calendarsPage.validateCalendarSelected("Tasks"), "Calendar is selected");

        calendarsPage.clickMoreInfoButton();
        Assert.assertTrue(editCalendarPage.editCalendarPageLoaded(), "Edit calendar page is not loaded");

        editCalendarPage.clickDeleteCalendarButton();
        editCalendarPage.clickDeleteCalendarPopupButton();
        Assert.assertTrue(calendarsPage.calendarsPageLoaded(), "Calendars page is not loaded");

        calendarsPage.validateCalendarDisplayed("Calendar");
        calendarsPage.clickDoneButton();
        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");
    }
}
