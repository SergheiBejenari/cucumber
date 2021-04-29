package hooks;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Hooks {

    @Before
    public void setupWebDriver(Scenario scenario) {
        log.debug("Driver is Set UP");
        WebDriver driver = Driver.getDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        log.info("Window is maximized");
        ScreenshotUtil.setScenario(scenario);
    }

    @After(order = 1)
    public void onFail(Scenario scenario) {
        if (scenario.isFailed()) ;
        ScreenshotUtil.takeScreenshot("Step failed" + " " + ScreenshotUtil.getCurrentTime());
        log.error("Step Failed");
        Driver.quitDriver();
    }

    @After(order = 2)
    public void tearDown() {
        Driver.quitDriver();
    }
}
