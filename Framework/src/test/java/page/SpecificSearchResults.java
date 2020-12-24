package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SpecificSearchResults {

    private static final String RegistrationForm_URL = "https://canon.ru/";
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(className = "onsite-search__result-item")
    private List<WebElement> generalSearchResult;

    public SpecificSearchResults(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int countGeneralNumberOfSearchResults()
    {
        waitForElementToBeClickable(this.driver, By.xpath("/html/body"));
        System.out.println("Number of results:" + generalSearchResult.size());
        return  generalSearchResult.size();
    }


    private  WebElement waitForElementToBeClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(by));
    }
}
