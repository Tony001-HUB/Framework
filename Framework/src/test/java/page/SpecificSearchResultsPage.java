package page;

import driver.DriverSingleton;
import model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.TestDataReader;

import java.util.List;

public class SpecificSearchResultsPage extends AbstractPage {

    private static final String HomeForm_URL = TestDataReader.getTestData("test.data.HomeForm.link");
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "sorter")
    private WebElement sortSelectionButton;

    @FindBy(xpath = "//*[@id=\"sorter\"]/option[3]")
    private WebElement switchPriceDescendingOrderButton;

    @FindBy(xpath = "/html/body/div[3]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[2]/ol/li[7]/a")
    private WebElement selectionByDestinationButton;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div/div[2]/ol/li[2]/a/span[1]")
    private WebElement selectionByPriceButton;

    @FindBy(xpath="//*[@id=\"groupMenu\"]/li[1]/a/span/span")
    private WebElement goToCamerasButton;

    @FindBy(className = "item product product-item")
    private List<WebElement> generalOptionsSearchResult;

    @FindBy(id="_evidon-accept-button")
    private WebElement agreeSiteRulesButton;

    @FindBy(xpath = "//*[@id=\"main-header\"]/nav/div[3]/div/div[2]/button/span[1]/i")
    private WebElement activateButtonSearch;

    @FindBy(id="nav__search-form-input")
    private WebElement inputSearch;

    @FindBy(className = "onsite-search__result-item")
    private List<WebElement> generalSpecificSearchResult;

    public SpecificSearchResultsPage()
    {
        super(DriverSingleton.getDriver());
    }

    @Override
    public SpecificSearchResultsPage openPage() {  driver.get(HomeForm_URL); return this; }

    public SpecificSearchResultsPage searchForTerms(Product product)
    {
        agreeSiteRulesButton.click();
        activateButtonSearch.click();
        waitForElementToBeClickable(this.driver, By.xpath("//*[@id=\"nav__search-form-input\"]"));
        inputSearch.sendKeys(product.getProductName());
        inputSearch.sendKeys(Keys.ENTER);
        logger.error("Successful product search");

        return new SpecificSearchResultsPage();
    }


    public SpecificSearchResultsPage searchByOptions()
    {
        goToCamerasButton.click();
        logger.error("Go to cameras products");

        return this;
    }

    public SpecificSearchResultsPage selectionByPrice() {
        waitForElementToBeClickable(this.driver, By.className("products list items product-items"));
        sortSelectionButton.click();
        switchPriceDescendingOrderButton.click();
        waitForElementToBeClickable(this.driver, By.className("products list items product-items"));
        selectionByPriceButton.click();
        logger.error("Successfully selection by price");

        return this;
    }

    public SpecificSearchResultsPage selectionByDestination() {
        waitForElementToBeClickable(this.driver, By.className("products list items product-items"));
        selectionByDestinationButton.click();
        logger.error("Successfully selection by destination");

        return this;
    }

    public int countGeneralNumberOfSpecificSearchResults()
    {
        waitForElementToBeClickable(this.driver, By.xpath("/html/body"));
        System.out.println("Number of results:" + generalSpecificSearchResult.size());
        return  generalSpecificSearchResult.size();
    }
    public int countGeneralNumberOfSearchOptionsResults()
    {
        waitForElementToBeClickable(this.driver, By.xpath("/html/body"));
        System.out.println("Number of results:" + generalOptionsSearchResult.size());
        return  generalOptionsSearchResult.size();
    }

}
