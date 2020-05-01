package helpers.page_objects.automation_practice;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AutomationPracticeBasePage {

    @FindBy(xpath = "//a[@title='Orders']")
    public WebElement orders;

    public boolean isPageAppear() {
        boolean isDisplayed = false;
        try {
            isDisplayed = orders.isDisplayed();
        } catch (ElementNotVisibleException e) {
           isDisplayed = false;
        }
        return isDisplayed;
    }
}
