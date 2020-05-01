package infrastructure;

import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class MyListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        reportManager.addPassLog(result.getName() + " test is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        reportManager.addPassLog(result.getName() + " test ended successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            reportManager.addFailLog("Test failed, see details: " +
                                            result.getThrowable()  + reportManager.addScreenshot(takeSS()));
        } catch (IOException | WebDriverException e) {
            reportManager.addFailLog("Could Not take screen shot, see details: " + e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        reportManager.addSkipLog("Skipped test: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}

