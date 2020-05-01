package infrastructure;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import infrastructure.data_readers.DataReader;

public class ReportManager {

    private ExtentReports extent;
    private ExtentTest test;

    public void instanceReport() {
        extent = new ExtentReports(DataReader.getData("ReportFilePath") + "Execution_" +
                                            BaseTest.timeStamp + "/" + DataReader.getData("ReportFileName") + ".html");
    }

    public void initReportTest(String testName, String testDescription) {
        test = extent.startTest(testName,testDescription);
    }

    public void addInfoLog(String message) {
        test.log(LogStatus.INFO,message);
    }

    public void addPassLog(String message) {
        test.log(LogStatus.PASS,message);
    }

    public void addFailLog(String message) {
        test.log(LogStatus.FAIL,message);
    }

    public void addSkipLog(String message) {
        test.log(LogStatus.FAIL,message);
    }

    public String addScreenshot(String path) { return test.addScreenCapture(path); }

    public void finalizeReportTest()
    {
        extent.endTest(test);
    }

    public void finalizeExtentReport() {
        try {
            extent.flush();
            extent.close();
        } catch (Exception e) {
            BaseTest.logger.fatal("failed to close report: " + e);
        }
    }
}
