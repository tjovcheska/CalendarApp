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

public class EditCalendarPage extends Helpers {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Edit Calendar\"`]")
    private RemoteWebElement editCalendarPageToolbar;

    @iOSXCUITFindBy(accessibility = "Delete Calendar")
    private RemoteWebElement deleteCalendarButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Delete Calendar\"`]")
    private RemoteWebElement deleteCalendarPopupButton;

    public EditCalendarPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Edit calendar page is loaded")
    public boolean editCalendarPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(editCalendarPageToolbar)).isDisplayed();
    }

    @Step("Click `Delete calendar` button")
    public void clickDeleteCalendarButton() {
        deleteCalendarButton.click();
    }

    @Step("Confirm `Delete calendar`")
    public void clickDeleteCalendarPopupButton() {
        deleteCalendarPopupButton.click();
    }
}
