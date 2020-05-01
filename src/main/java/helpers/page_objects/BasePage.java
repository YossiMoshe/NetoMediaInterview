package helpers.page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static infrastructure.BaseTest.reportManager;
import static infrastructure.BrowserManager.driver;

public abstract class BasePage {

    protected WebDriverWait wait = new WebDriverWait(driver, 20);
    protected JavascriptExecutor js = (JavascriptExecutor) driver;
    protected Actions action = new Actions(driver);

    protected WebElement waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected void moveToElement(WebElement element) {
        try {
            action.moveToElement(element).build().perform();
        } catch (Exception e) {
            reportManager.addFailLog("failed to move over: " + e);
        }
    }

    protected void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            reportManager.addFailLog("failed to click on element: " + e);
        }
    }

    protected void addReportLog(String message) {
        reportManager.addInfoLog(message);
    }
}
