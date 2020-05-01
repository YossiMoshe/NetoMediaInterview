package infrastructure;

import helpers.page_objects.PageObjectManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static infrastructure.BrowserManager.driver;
import static infrastructure.data_readers.DataReader.getData;
import static infrastructure.utils.GeneralUtils.getUUID;

@Listeners(MyListener.class)
public abstract class BaseTest {

    protected static BrowserManager browserManager = new BrowserManager();
    public static ReportManager reportManager = new ReportManager();
    public static Logger logger = LogManager.getLogger(BaseTest.class);
    protected static PageObjectManager pageObjectManager;
    protected static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());


    @BeforeSuite(alwaysRun = true)
    public void startSession() {
        reportManager.instanceReport();
    }

    @AfterSuite(alwaysRun = true)
    public void closeSession() {
        reportManager.finalizeExtentReport();
    }

    @BeforeMethod
    public void doBeforeMethod(Method method,ITestResult test) {
        browserManager.initBrowser();
        pageObjectManager = new PageObjectManager();
        reportManager.initReportTest(method.getName(),test.getMethod().getDescription());
    }

    @AfterMethod
    public void doAfterMethod() {
        browserManager.closeBrowser();
        reportManager.finalizeReportTest();
    }

    protected void sleep(int mili) {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            logger.error("failed to sleep: " + e);
        }
    }

    public static String takeSS() throws IOException, WebDriverException {
        String SSPath = getData("ReportFilePath") + "Execution_" + timeStamp + "/" + "screenshot_" + getUUID() + ".png";
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(SSPath));

        return SSPath;
    }

}
