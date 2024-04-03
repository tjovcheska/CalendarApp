package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class NewEventPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"New Event\"`]")
    private RemoteWebElement newEventPageHeader;

    @iOSXCUITFindBy(accessibility = "Title")
    private RemoteWebElement titleField;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[contains(@name, 'Starts')]/XCUIElementTypeButton/XCUIElementTypeButton)[1]")
    private RemoteWebElement startsDatePickerButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[contains(@name, 'Starts')]/XCUIElementTypeOther/XCUIElementTypeButton)[2]")
    private RemoteWebElement startsTimePickerButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[contains(@name, 'Ends')]/XCUIElementTypeButton/XCUIElementTypeButton)[1]")
    private RemoteWebElement endsDatePickerButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[contains(@name, 'Ends')]/XCUIElementTypeOther/XCUIElementTypeButton)[2]")
    private RemoteWebElement endsTimePickerButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[1]")
    private RemoteWebElement hourPicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[2]")
    private RemoteWebElement minutePicker;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Travel Time\"`]")
    private RemoteWebElement travelTimePicker;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`name == \"All-day\"`]")
    private RemoteWebElement allDaySwitchButton;

    @iOSXCUITFindBy(accessibility = "Add")
    private RemoteWebElement addButton;


    public NewEventPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("New event page is loaded")
    public boolean newEventPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newEventPageHeader)).isDisplayed();
    }

    @Step("Add {0} as new event title")
    public void addNewEventTitle(String title) {
        titleField.sendKeys(title);
    }

    @Step("Choose {0} as start date")
    public void chooseStartDate(String startDate) {
        startsDatePickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format("//XCUIElementTypeStaticText[@name='%s']", startDate))))).click();
    }

    @Step("Choose {0}:{1} as start hour")
    public void chooseStartHour(String startHour, String startMinutes) {
        startsTimePickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(hourPicker)).sendKeys(startHour);
        minutePicker.sendKeys(startMinutes);
    }

    @Step("Choose {0} as ends date")
    public void chooseEndDate(String endDate) {
        endsDatePickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format("//XCUIElementTypeStaticText[@name='%s']", endDate))))).click();
    }

    @Step("Choose {0}:{1} as end hour")
    public void chooseEndHour(String endHour, String endMinutes) {
        endsTimePickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(hourPicker)).sendKeys(endHour);
        minutePicker.sendKeys(endMinutes);
    }

    @Step("Choose {0} as travel time")
    public void chooseTravelTime(String travelTime) {
        travelTimePicker.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format("//XCUIElementTypeButton[@name='%s']", travelTime))))).click();
    }

    @Step("Click all day switch button")
    public void clickAllDaySwitchButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(allDaySwitchButton)).click();
    }

    @Step("Validate start time is not visible after clicking `All-day` switch button")
    public boolean validateStartTimeVisibility() {
        try {
            return startsTimePickerButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Validate end time is not visible after clicking `All-day` switch button")
    public boolean validateEndTimeVisibility() {
        try {
            return endsTimePickerButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Click `Add` button")
    public void clickAddButton() {
        addButton.click();
    }
}
