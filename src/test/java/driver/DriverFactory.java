package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import utils.PropertyReader;

public class DriverFactory {
    private static final String RESOURCES_PATH = "src/test/resources/";

    public static WebDriver getDriver() {
        String browserName = PropertyReader.applicationProperties().getProperty("browser");
        switch (browserName.toLowerCase()) {
            case BrowserType.CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case BrowserType.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new RuntimeException("ATF is not configured for " + browserName);
        }
    }
}