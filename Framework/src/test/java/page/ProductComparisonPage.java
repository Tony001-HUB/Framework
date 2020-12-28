package page;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductComparisonPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath="//*[@id=\"product-comparison\"]/thead/tr/td[1]/a")
    private WebElement deleteProductButton;

    @FindBy(xpath="/html/body/div[4]/aside[2]/div[2]/footer/button[2]")
    private WebElement agreeWithDeleteProductButton;

    @FindBy(className = "product-item-photo")
    private List<WebElement> generalSearchResult;


    public ProductComparisonPage()
    {
        super(DriverSingleton.getDriver());
        logger.error("Successful transition to the product comparison page");
    }

    @Override
    public ProductComparisonPage openPage() { return this; }

    public ProductComparisonPage deleteProduct()
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


