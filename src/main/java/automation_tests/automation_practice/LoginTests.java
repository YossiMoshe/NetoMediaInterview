package automation_tests.automation_practice;

import infrastructure.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import static helpers.page_objects.PageObjectManager.*;

public class LoginTests extends BaseTest {

    private final String URL = "http://automationpractice.com//";
    private final String EMAIL = "test@netomedia.com";
    private final String PASSWORD = "123456";

    @Test(description = "Test 1 - login validation")
    public void loginTest() {
        browserManager.navigateToUrl(URL);
        mainPage.header.navBar.clickSignIn();
        signInPage.setEmail(EMAIL);
        signInPage.setPassword(PASSWORD);
        signInPage.clickSignIn();

        Assert.assertTrue(myAccountPage.isPageAppear(),"Failed to login");
    }
}
