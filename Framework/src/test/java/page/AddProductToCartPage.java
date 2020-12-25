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

public class AddProductToCartPage {

    private static final String HomeForm_URL = "https://store.canon.ru/fotokamera-dlja-mgnovennoj-pechati-zoemini-c-cvet-fuksija.html";
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();
    //*[@id="product-addtocart-button"]/span
    //*[@id="maincontent"]/div[3]/div[1]/div[2]/ol/li[2]/div/div/div[3]/div[1]/form/button/span
    //*[@id="maincontent"]/div[3]/div[1]/div[2]/ol/li[1]/div/div/div[3]/div[1]/form/button/span

    @FindBy(xpath="/html/body/div[3]/main/div[3]/div/div[2]/div[4]/div[1]/div[1]/div[1]/form/div[2]/div/div/div[2]/button/span")
    private WebElement addToCartButton;

    public AddProductToCartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public AddProductToCartPage openPage()
    {
        this.driver.get(HomeForm_URL);
        return this;
    }

    public AddProductToCartPage addProductToCart()
    {
        waitForElementToBeVisibility(this.driver, By.id("product-addtocart-button") );
        addToCartButton.click();

        return this;
    }

    private  WebElement waitForElementToBeVisibility(WebDriver driver, By by) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(by));
    }

}
