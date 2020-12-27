package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteProductFromCartPage {
    private static final String HomeForm_URL = "https://store.canon.ru/fotokamera-dlja-mgnovennoj-pechati-zoemini-c-cvet-fuksija.html";
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath="/html/body/div[3]/header/div[3]/div[5]/div[2]/a/div/div")
    private WebElement openCartButton;

    @FindBy(xpath="/html/body/div[3]/header/div[3]/div[5]/div[2]/div/div/div/div/div[1]/div[1]/div/ul/li/div/div/div[2]/div/a")
    private WebElement deleteProductFromCartButton;

    @FindBy(xpath="/html/body/div[3]/main/div[3]/div/div[2]/div[4]/div[1]/div[1]/div[1]/form/div[2]/div/div/div[2]/button/span")
    private WebElement addToCartButton;

    public DeleteProductFromCartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public DeleteProductFromCartPage openPage()
    {
        this.driver.get(HomeForm_URL);
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


    private  WebElement waitForElementToBeVisibility(WebDriver driver, By by) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(by));
    }
}