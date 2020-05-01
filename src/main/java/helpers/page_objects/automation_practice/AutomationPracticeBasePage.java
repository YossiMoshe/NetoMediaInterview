package helpers.page_objects.automation_practice;

import helpers.page_objects.BasePage;
import org.openqa.selenium.support.PageFactory;
import static infrastructure.BrowserManager.driver;

public class AutomationPracticeBasePage extends BasePage {
    public Header header;
    public Footer footer;

    public AutomationPracticeBasePage() {
        header = PageFactory.initElements(driver,Header.class);
        footer = PageFactory.initElements(driver,Footer.class);
    }
}
