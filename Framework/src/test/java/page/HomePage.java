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

import java.util.concurrent.TimeUnit;

public class HomePage {

    private static final String HomeForm_URL = "https://canon.ru/";
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


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public HomePage openPage()
    {
        this.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        this.driver.get(HomeForm_URL);

        return this;
    }

    public SpecificSearchResults searchForTerms()
    {
        waitForElementToBeClickable(this.driver, By.xpath("//*[@id=\"main-header\"]/nav/div[2]"));
        agreeSiteRulesButton.click();
        activateButtonSearch.click();
        inputSearch.sendKeys(Product.getProductName());
        inputSearch.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new SpecificSearchResults(driver);
    }

    private  WebElement waitForElementToBeClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, 30)
                .until(ExpectedConditions
                        .elementToBeClickable(by));
    }
}
