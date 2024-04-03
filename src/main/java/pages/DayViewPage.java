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

public class DayViewPage extends Helpers {

    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "DayViewContainerView")
    private RemoteWebElement dayViewPageContainer;

    public DayViewPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendar home page is loaded")
    public boolean dayViewPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(dayViewPageContainer)).isDisplayed();
    }

    @Step("Validate event `{0}` is displayed")
    public void validateEventDisplayed(String title) {
        driver.findElement(By.xpath(String.format("//XCUIElementTypeButton[contains(@name, '%s')]", title))).isDisplayed();
    }

    @Step("Click `{0}` back button")
    public void clickBackButton(String month) {
        driver.findElement(By.xpath(String.format("//XCUIElementTypeButton[@name='%s']", month))).click();
    }

}