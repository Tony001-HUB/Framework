package page;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.TestDataReader;

public class AddProductToCartPage extends AbstractPage {

    private static final String AddingCameraСart_URL = TestDataReader.getTestData("test.data.AddingCameraСart.link");
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath="/html/body/div[3]/main/div[3]/div/div[2]/div[4]/div[1]/div[1]/div[1]/form/div[2]/div/div/div[2]/button/span")
    private WebElement addToCartButton;

    public AddProductToCartPage()
    {
        super(DriverSingleton.getDriver());
    }

    @Override
    public AddProductToCartPage openPage()
    {
        driver.get(AddingCameraСart_URL);
        return this;
    }

    public AddProductToCartPage addProductToCart()
    {
        waitForElementToBeVisibility(this.driver, By.id("product-addtocart-button") );
        addToCartButton.click();
        logger.error("Successful adding to cart");

        return this;
    }

}
