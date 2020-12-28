package page;

import driver.DriverSingleton;
import model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage{

    private static final String HomeForm_URL = "https://canon.ru";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id="_evidon-accept-button")
    private WebElement agreeSiteRulesButton;

    @FindBy(xpath = "//*[@id=\"main-header\"]/nav/div[3]/div/div[2]/button/span[1]/i")
    private WebElement activateButtonSearch;

    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
    private WebElement clickButtonSearch;

    @FindBy(id="nav__search-form-input")
    private WebElement inputSearch;

    @FindBy(xpath="//*[@id=\"groupMenu\"]/li[1]/a/span/span")
    private WebElement goToCamerasButton;


    public HomePage()
    {
        super(DriverSingleton.getDriver());
    }

    public HomePage openPage()
    {
        driver.get(HomeForm_URL);
        return this;
    }

    public SpecificSearchResultsPage searchForTerms(Product product)
    {
        agreeSiteRulesButton.click();
        activateButtonSearch.click();
        waitForElementToBeClickable(this.driver, By.xpath("//*[@id=\"nav__search-form-input\"]"));
        inputSearch.sendKeys(product.getProductName());
        inputSearch.sendKeys(Keys.ENTER);

        return new SpecificSearchResultsPage();
    }

    public TestingSearchOptionsPage searchByOptions()
    {
        goToCamerasButton.click();
        return new TestingSearchOptionsPage();
    }

}
