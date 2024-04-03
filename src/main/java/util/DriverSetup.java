package util;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

@Listeners({ ITestListenerUtility.class })
public class DriverSetup extends ConfigReader{

    public static IOSDriver driver;

    protected Helpers helpers;

    protected CalendarHomePage calendarHomePage;
    protected NewEventPage newEventPage;
    protected DayViewPage dayViewPage;
    protected CalendarsPage calendarsPage;
    protected AddCalendarPage addCalendarPage;
    protected CalendarColorPage calendarColorPage;
    protected EditCalendarPage editCalendarPage;

    @Step("Driver is started")
    @BeforeMethod
    public void setUp() {

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(getProperty("device.name"))
                .setPlatformVersion(getProperty("platform.version"))
                .setBundleId(getProperty("bundle.id"))
                .setNoReset(false)
                .setAutoAcceptAlerts(true);

        try {
            driver = new IOSDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        helpers = new Helpers();

        calendarHomePage = new CalendarHomePage(driver);
        newEventPage = new NewEventPage(driver);
        dayViewPage = new DayViewPage(driver);
        calendarsPage = new CalendarsPage(driver);
        addCalendarPage = new AddCalendarPage(driver);
        calendarColorPage = new CalendarColorPage(driver);
        editCalendarPage = new EditCalendarPage(driver);
    }

    @Step("Driver is closed")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
