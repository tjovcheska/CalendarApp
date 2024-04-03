package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;
import util.Helpers;

public class CalendarHomePage extends Helpers {

    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Calendar")
    private RemoteWebElement calendarHomePageContainer;

    @iOSXCUITFindBy(accessibility = "Add")
    private RemoteWebElement newEventButton;

    @iOSXCUITFindBy(accessibility = "Calendars")
    private RemoteWebElement calendarsButton;

    public CalendarHomePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendar home page is loaded")
    public boolean calendarHomePageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarHomePageContainer)).isDisplayed();
    }

    @Step("Click `New event` button")
    public void clickNewEventButton() {
        newEventButton.click();
    }

    @Step("Click `{0}` back button")
    public void clickBackButton(String month) {
        driver.findElement(By.xpath(String.format("//XCUIElementTypeButton[@name='%s']", month))).click();
    }

    @Step("Select {0}")
    public void selectDate(String date) {
        driver.findElement(By.xpath(String.format("//XCUIElementTypeButton[@name='%s']", date))).click();
    }

    @Step("Click `Calendars` button")
    public void clickCalendarsButton() {
        calendarsButton.click();
    }
}
