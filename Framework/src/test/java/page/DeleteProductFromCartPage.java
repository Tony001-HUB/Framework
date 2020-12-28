package page;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class DeleteProductFromCartPage extends AbstractPage {
    private static final String HomeForm_URL = "https://store.canon.ru/fotokamera-dlja-mgnovennoj-pechati-zoemini-c-cvet-fuksija.html";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath="/html/body/div[3]/header/div[3]/div[5]/div[2]/a/div/div")
    private WebElement openCartButton;

    @FindBy(xpath="/html/body/div[3]/header/div[3]/div[5]/div[2]/div/div/div/div/div[1]/div[1]/div/ul/li/div/div/div[2]/div/a")
    private WebElement deleteProductFromCartButton;

    @FindBy(xpath="/html/body/div[3]/main/div[3]/div/div[2]/div[4]/div[1]/div[1]/div[1]/form/div[2]/div/div/div[2]/button/span")
    private WebElement addToCartButton;

    public DeleteProductFromCartPage()
    {
        super(DriverSingleton.getDriver());
    }

    @Override
    public DeleteProductFromCartPage openPage()
    {
        this.driver.get(HomeForm_URL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return this;
    }

    public void addProductToCart()
    {
        waitForElementToBeVisibility(this.driver, By.id("product-addtocart-button") );
        addToCartButton.click();
    }

    public DeleteProductFromCartPage deleteProductFromCart()
    {
        addProductToCart();
        openCartButton.click();
        deleteProductFromCartButton.click();

        return this;
    }

}
