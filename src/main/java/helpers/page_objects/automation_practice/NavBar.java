package helpers.page_objects.automation_practice;

import helpers.page_objects.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar extends BasePage {

    @FindBy(className = "login")
    public WebElement signIn;

    public void clickSignIn() {
        waitUntilClickable(signIn).click();
    }
}
