package page;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.TestDataReader;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddToCompareProductsPage extends AbstractPage {

    private static final String OneProductForm_URL = TestDataReader.getTestData("test.data.OneProduct.link");
    private static final String TwoProductForm_URL = TestDataReader.getTestData("test.data.TwoProduct.link");
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath="/html/body/div[3]/header/div[3]/div[5]/div[2]/a/div/div")
    private WebElement moveFocusOnDesiredProduct;

    @FindBy(xpath = "//*[@id=\"productInfoToCart\"]/div[2]/div/a[2]")
    private WebElement addProductButton;

    @FindBy(xpath = "/html/body/div[3]/header/div[3]/div[4]/a")
    private WebElement openСomparisonPageButton;

    @FindBy(xpath="//*[@id=\"product-comparison\"]/thead/tr/td[1]/a")
    private WebElement deleteProductButton;

    @FindBy(xpath="/html/body/div[4]/aside[2]/div[2]/footer/button[2]")
    private WebElement agreeWithDeleteProductButton;

    @FindBy(className = "product-item-photo")
    private List<WebElement> generalSearchResult;

    @FindBy(id = "btn-cookie-allow")
    private WebElement cookieAllowButton;

    public AddToCompareProductsPage()
    {
        super(DriverSingleton.getDriver());
    }

    @Override
    public AddToCompareProductsPage openPage()
    {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        this.driver.get(OneProductForm_URL);
        cookieAllowButton.click();
        logger.error("Successful opening of the first product");
        return this;
    }

    public AddToCompareProductsPage openPageSecondItem()
    {
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        this.driver.get(TwoProductForm_URL);
        logger.error("Successful opening of the second product");
        return this;
    }

    public AddToCompareProductsPage addingCompareFirstProduct()
    {
        waitForElementToBeClickable(this.driver, By.id("productInfoToCart"));
        addProductButton.click();
        logger.error("First product added to compare successfully");

        return this;
    }

    public AddToCompareProductsPage addingCompareSecondProduct()
    {
        waitForElementToBeClickable(this.driver, By.id("productInfoToCart"));
        addProductButton.click();
        logger.error("Second product added to compare successfully");

        return this;
    }

    public AddToCompareProductsPage openProductComparisonPage()
    {
        openСomparisonPageButton.click();
        logger.error("Transition to the product comparison page");

        return this;
    }


    public AddToCompareProductsPage deleteProduct()
    {
        deleteProductButton.click();
        agreeWithDeleteProductButton.click();
        logger.error("The product was successfully deleted");

        return this;
    }

    public int countGeneralNumberOfSearchResults()
    {
        System.out.println("Number of results:" + generalSearchResult.size());
        return  generalSearchResult.size();
    }



}
