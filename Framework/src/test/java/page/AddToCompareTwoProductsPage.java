package page;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class AddToCompareTwoProductsPage extends AbstractPage {

    private static final String OneProductForm_URL = "https://store.canon.ru/mnogofunkcional-nyj-strujnyj-printer-pixma-mg2540s.html";
    private static final String TwoProductForm_URL = "https://store.canon.ru/mnogofunkcional-nyj-strujnyj-printer-pixma-mg3640s-chernyj.html";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath="/html/body/div[3]/header/div[3]/div[5]/div[2]/a/div/div")
    private WebElement moveFocusOnDesiredProduct;

    @FindBy(xpath = "//*[@id=\"productInfoToCart\"]/div[2]/div/a[2]")
    private WebElement addProductButton;

    @FindBy(xpath = "/html/body/div[3]/header/div[3]/div[4]/a")
    private WebElement openСomparisonPageButton;

    @FindBy(id = "btn-cookie-allow")
    private WebElement cookieAllowButton;

    public AddToCompareTwoProductsPage()
    {
        super(DriverSingleton.getDriver());
    }

    @Override
    public AddToCompareTwoProductsPage openPage()
    {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        this.driver.get(OneProductForm_URL);
        cookieAllowButton.click();
        logger.error("Successful opening of the first product");
        return this;
    }

    public AddToCompareTwoProductsPage openPageSecondItem()
    {
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        this.driver.get(TwoProductForm_URL);
        logger.error("Successful opening of the second product");
        return this;
    }

    public AddToCompareTwoProductsPage addingCompareFirstProduct()
    {
        waitForElementToBeClickable(this.driver, By.id("productInfoToCart"));
        addProductButton.click();
        logger.error("First product added to compare successfully");

        return this;
    }

    public AddToCompareTwoProductsPage addingCompareSecondProduct()
    {
        waitForElementToBeClickable(this.driver, By.id("productInfoToCart"));
        addProductButton.click();
        logger.error("Second product added to compare successfully");

        return this;
    }

    public ProductComparisonPage openProductComparisonPage()
    {
        openСomparisonPageButton.click();
        logger.error("Transition to the product comparison page");

        return new ProductComparisonPage();
    }




}
