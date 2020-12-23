package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
    private final Logger logger = LogManager.getRootLogger();

    public void onTestStart(ITestResult iTestResult) {
        logger.info("Test start");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Test success");
    }

    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Test failure");
    }

    public void onFinish(ITestContext iTestContext) {
        logger.info("Test finish");
    }

}
