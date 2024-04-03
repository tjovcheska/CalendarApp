package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.qameta.allure.Step;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;
import util.Helpers;

public class AddCalendarPage extends Helpers {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Add Calendar\"`]")
    private RemoteWebElement addCalendarPageToolbar;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Calendar Name\"`]")
    private RemoteWebElement calendarNameField;

    @iOSXCUITFindBy(accessibility = "chevron")
    private RemoteWebElement changeCalendarColorButton;

    @iOSXCUITFindBy(accessibility = "Done")
    private RemoteWebElement doneButton;


    public AddCalendarPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Add calendar page is loaded")
    public boolean addCalendarPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addCalendarPageToolbar)).isDisplayed();
    }

    @Step("Add {0} as calendar name")
    public void addCalendarName(String name) {
        calendarNameField.sendKeys(name);
    }

    @Step("Click `Color` button")
    public void clickColorButton() {
        changeCalendarColorButton.click();
    }

    @Step("Click `Done` button")
    public void clickDoneButton() {
        doneButton.click();
    }
}
