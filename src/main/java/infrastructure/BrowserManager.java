package infrastructure;

import infrastructure.data_readers.ConfigPropertiesReader;
import infrastructure.data_readers.DataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class BrowserManager {

    public static WebDriver driver;
    private static String browserType;

    public BrowserManager() {
        browserType = new ConfigPropertiesReader().getBrowserType();
    }

    public void initBrowser() {
        String startUrl = DataReader.getData("URL");
        switch(browserType.toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFFDriver();
                break;
        }
        driver.get(startUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        driver.quit();
    }

    private static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", DataReader.getData("ChromeDriverPath"));
        return new ChromeDriver(createChromeOptions());
    }

    private static ChromeOptions createChromeOptions() {
        return new ChromeOptions().addArguments("--no-sandbox");
    }

    private static WebDriver initFFDriver() {
        System.setProperty("webdriver.gecko.driver", DataReader.getData("FFDriverPath"));
        return new FirefoxDriver();
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }
}
