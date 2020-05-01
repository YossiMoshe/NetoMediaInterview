package helpers.page_objects.automation_practice;

import org.openqa.selenium.support.PageFactory;

import static infrastructure.BrowserManager.driver;

public class MainPage extends AutomationPracticeBasePage {

    public Slider slider;
    public HomeFeatured homeFeatured;
    public ClearFix clearFix;

    public MainPage() {
        slider = PageFactory.initElements(driver,Slider.class);
        homeFeatured = PageFactory.initElements(driver,HomeFeatured.class);
        clearFix = PageFactory.initElements(driver,ClearFix.class);
    }
}
