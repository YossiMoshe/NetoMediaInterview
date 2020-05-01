package helpers.page_objects.automation_practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AutomationPracticeBasePage {

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "passwd")
    public WebElement password;

    @FindBy(id = "SubmitLogin")
    public WebElement signIn;


    public void setEmail(String mail) {
        email.sendKeys(mail);
    }

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickSignIn() {
        waitUntilClickable(signIn).click();
    }

}
