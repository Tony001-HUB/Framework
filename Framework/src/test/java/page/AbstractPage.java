package page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected final int WAIT_TIMEOUT_SECONDS = 30;

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected abstract AbstractPage openPage();

    public WebElement waitUntilPresenceOfElement(By location){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(location));
    }

    public WebElement waitUntilVisibilityOf(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilElementIsClickable(By location){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(location));
    }

    public void waitUntilElementIsClickableAndClickAvoidModalWindow(By location){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.elementToBeClickable(location)).click();
        } catch (ElementClickInterceptedException exception){
            driver.navigate().refresh();
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.elementToBeClickable(location)).click();
        }
    }

    public WebElement waitUntilElementIsClickable(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementIsClickableAndClickAvoidModalWindow(WebElement element){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException exception){
            driver.navigate().refresh();
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }

    public void waitUntilFieldIsChanged(WebElement element, String startValue){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, startValue)));
    }

    public  WebElement waitForElementToBeVisibility(WebDriver driver, By by) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public  WebElement waitForElementToBeClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .elementToBeClickable(by));
    }

}
