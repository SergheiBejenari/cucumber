package utils;

import Driver.Driver;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class ScreenshotUtil {
    private static String scenarioName;

    public static void setScenario(Scenario scenario) {
        scenarioName = scenario.getName();
    }

    public static void takeScreenshot(String name) {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        byte[] source = ts.getScreenshotAs(OutputType.BYTES);
        String fileName = name + ".png";
        Path scenarioPath = Paths.get(new File(
                "target/screenshot/" + scenarioName + "/").getPath());
        try {
            Files.createDirectories(scenarioPath);
            Files.write(scenarioPath.resolve(fileName), source);
        } catch (IOException e) {
            log.error("Fail to save screenshot" + e.getMessage());
        }
    }

    public static String getCurrentTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = dateTime.format(formatter);
        return time;
    }
}