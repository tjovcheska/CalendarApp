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

public class CalendarColorPage extends Helpers {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Calendar Colour\"`]")
    private RemoteWebElement calendarColorPageToolbar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Add Calendar\"])[2]")
    private RemoteWebElement addCalendarButton;

    public CalendarColorPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendar color page is loaded")
    public boolean calendarColorPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarColorPageToolbar)).isDisplayed();
    }

    @Step("Change calendar color to {0}")
    public void changeCalendarColor(String color) {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format("//XCUIElementTypeStaticText[@name='%s']", color))))).click();
    }

    @Step("Click `Add calendar` button")
    public void clickAddCalendarButton() {
        addCalendarButton.click();
    }
}
