package helpers.page_objects.automation_practice;

import helpers.page_objects.BasePage;
import org.openqa.selenium.support.PageFactory;

import static infrastructure.BrowserManager.driver;

public class Header extends BasePage {
    public NavBar navBar;

    public Header() {
        navBar = PageFactory.initElements(driver,NavBar.class);
    }
}
