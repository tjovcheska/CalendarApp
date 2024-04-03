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

public class CalendarsPage extends Helpers {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Calendars\"`]")
    private RemoteWebElement calendarsPageToolbar;

    @iOSXCUITFindBy(accessibility = "Add Calendar")
    private RemoteWebElement addCalendarButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Add Calendar\"])[2]")
    private RemoteWebElement addCalendarOption;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"SHOW ALL\"])[2]")
    private RemoteWebElement showAllButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"HIDE ALL\"])[2]")
    private RemoteWebElement hideAllButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"More Info\"`][2]")
    private RemoteWebElement moreInfoButton;

    @iOSXCUITFindBy(accessibility = "Done")
    private RemoteWebElement doneButton;

    public CalendarsPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendar home page is loaded")
    public boolean calendarsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarsPageToolbar)).isDisplayed();
    }

    @Step("Click `Add calendar` button")
    public void clickAddCalendarButton() {
        addCalendarButton.click();
    }

    @Step("Click `Add calendar` option")
    public void clickAddCalendarOption() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addCalendarOption)).click();
    }

    @Step("Validate that {0} calendar is displayed")
    public void validateCalendarDisplayed(String title) {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format("//XCUIElementTypeStaticText[@name='%s']", title))))).isDisplayed();
    }

    @Step("Click `Show all` button")
    public void clickShowAllButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(showAllButton)).click();
    }

    @Step("Click `Hide all` button")
    public void clickHideAllButton() {
        hideAllButton.click();
    }

    @Step("Validate that {0} calendar is selected")
    public boolean validateCalendarSelected(String title) {
        RemoteWebElement element = (RemoteWebElement) driver.findElement(By.xpath(String.format("//XCUIElementTypeStaticText[@name='%s']/preceding-sibling::XCUIElementTypeImage[@name=\"circle\"]", title)));
        String label = element.getAttribute("label");
        System.out.println(label);
        if (label == "selected") {
            return true;
        }
        return false;
    }

    @Step("Click `More info` button")
    public void clickMoreInfoButton() {
        moreInfoButton.click();
    }

    @Step("Click 'Done' button")
    public void clickDoneButton() {
        doneButton.click();
    }
}