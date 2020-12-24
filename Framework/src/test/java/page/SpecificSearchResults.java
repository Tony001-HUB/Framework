package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        System.out.println("Number of results:" + generalSearchResult.size());
        return  generalSearchResult.size();
    }
}
