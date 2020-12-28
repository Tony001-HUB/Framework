package page;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestingSearchOptionsPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "sorter")
    private WebElement sortSelectionButton;

    @FindBy(xpath = "//*[@id=\"sorter\"]/option[3]")
    private WebElement switchPriceDescendingOrderButton;

    @FindBy(xpath = "/html/body/div[3]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[2]/ol/li[7]/a")
    private WebElement selectionByDestinationButton;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[2]")
    private WebElement tmp;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div/div[2]/ol/li[2]/a/span[1]")
    private WebElement selectionByPriceButton;

    @FindBy(className = "item product product-item")
    private List<WebElement> generalSearchResult;

    public TestingSearchOptionsPage()
    {
        super(DriverSingleton.getDriver());
    }

    @Override
    public TestingSearchOptionsPage openPage() { return this; }

    public TestingSearchOptionsPage selectionByPrice() {
        waitForElementToBeClickable(this.driver, By.className("products list items product-items"));
        sortSelectionButton.click();
        switchPriceDescendingOrderButton.click();
        waitForElementToBeClickable(this.driver, By.className("products list items product-items"));
        selectionByPriceButton.click();
        logger.error("Successfully selection by price");

        return this;
    }

    public TestingSearchOptionsPage selectionByDestination() {
        waitForElementToBeClickable(this.driver, By.className("products list items product-items"));
        selectionByDestinationButton.click();
        logger.error("Successfully selection by destination");

        return this;
    }

    public int countGeneralNumberOfSearchResults()
    {
        waitForElementToBeClickable(this.driver, By.xpath("/html/body"));
        System.out.println("Number of results:" + generalSearchResult.size());
        return  generalSearchResult.size();
    }
}
