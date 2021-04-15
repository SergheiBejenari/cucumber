package driver;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static WebDriver driver;

    private Driver() {
        driver = DriverFactory.getDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            new Driver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.close();
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}