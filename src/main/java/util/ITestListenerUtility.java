package util;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerUtility extends ScreenshotUtility implements ITestListener {

    public void onTestSuccess(ITestResult tr) {
        captureScreenshot(tr, "pass");
    }

    public void onTestFailure(ITestResult tr) {
        captureScreenshot(tr, "fail");
    }
}
