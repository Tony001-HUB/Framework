package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductComparisonPage {

    private WebDriver driver;

    @FindBy(xpath="//*[@id=\"product-comparison\"]/thead/tr/td[1]/a")
    private WebElement deleteProductButton;

    @FindBy(xpath="/html/body/div[4]/aside[2]/div[2]/footer/button[2]")
    private WebElement agreeWithDeleteProductButton;

    @FindBy(className = "product-item-photo")
    private List<WebElement> generalSearchResult;


    public ProductComparisonPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public ProductComparisonPage deleteProduct()
    {
        deleteProductButton.click();
        agreeWithDeleteProductButton.click();
        return this;
    }

    public int countGeneralNumberOfSearchResults()
    {
        System.out.println("Number of results:" + generalSearchResult.size());
        return  generalSearchResult.size();
    }

}


