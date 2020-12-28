package util;

import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private final Logger logger = LogManager.getRootLogger();

    public void onTestFailure(ITestResult iTestResult){
        saveScreenshot();
    }

    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot)DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenCapture,
                    new File(String.format(".//target/screenshots/%s%s",getCurrentTime(), ".png")));
        } catch (IOException ex){
            logger.error("Failed to save screenshot: " + ex.getMessage());
        }
    }

    private String getCurrentTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return Instant.now().atZone(ZoneId.systemDefault()).format(formatter);
    }
}