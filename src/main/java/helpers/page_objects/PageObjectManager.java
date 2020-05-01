package helpers.page_objects;

import helpers.page_objects.automation_practice.MainPage;
import helpers.page_objects.automation_practice.MyAccountPage;
import helpers.page_objects.automation_practice.SignInPage;
import infrastructure.BrowserManager;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

    public static MainPage mainPage;
    public static SignInPage signInPage;
    public static MyAccountPage myAccountPage;

    public PageObjectManager() {
        initPageObjects();
    }

    public void initPageObjects() {
        mainPage = PageFactory.initElements(BrowserManager.driver, MainPage.class);
        signInPage = PageFactory.initElements(BrowserManager.driver, SignInPage.class);
        myAccountPage = PageFactory.initElements(BrowserManager.driver, MyAccountPage.class);
    }
}
