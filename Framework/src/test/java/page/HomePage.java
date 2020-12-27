package page;

import model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private static final String HomeForm_URL = "https://store.canon.ru/";
    private WebDriver driver;
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


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public HomePage openPage()
    {
        this.driver.get(HomeForm_URL);

        return this;
    }

    public SpecificSearchResultsPage searchForTerms(Product product)
    {
        waitForElementToBeClickable(this.driver, By.xpath("//*[@id=\"main-header\"]/nav/div[2]"));
        agreeSiteRulesButton.click();
        activateButtonSearch.click();
        waitForElementToBeClickable(this.driver, By.xpath("//*[@id=\"nav__search-form-input\"]"));
        inputSearch.sendKeys(product.getProductName());
        inputSearch.sendKeys(Keys.ENTER);


        return new SpecificSearchResultsPage(driver);
    }

    public TestingSearchOptionsPage searchByOptions()
    {
        goToCamerasButton.click();
        return new TestingSearchOptionsPage(driver);
    }

    private  WebElement waitForElementToBeClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .elementToBeClickable(by));
    }
}
