package page;

import driver.DriverSingleton;
import model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SerialNumberVerificationPage extends AbstractPage
{
    private static final String SerialNumberVerificationForm_URL = "https://www.canon.ru/about_us/serial-number-checker/#serial";
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "/html/body/div[6]/div[1]/span[1]/span[1]/span/ul/li/input")
    private WebElement  inputModelName;

    @FindBy(xpath = "//*[@id=\"cps-form-input-serial-number-a\"]")
    private WebElement  inputSerialNumber;

    @FindBy(xpath = "/html/body/div[6]/div[4]/div/div/p/span")
    private WebElement  verificationReport;

    @FindBy(id="btnsubmit")
    private WebElement submitReviewButton;

    @FindBy(id="_evidon-accept-button")
    private WebElement agreeSiteRulesButton;

    public SerialNumberVerificationPage()
    {
        super(DriverSingleton.getDriver());
    }

    public SerialNumberVerificationPage openPage()
    {
        driver.get(SerialNumberVerificationForm_URL);
        return this;
    }

    public SerialNumberVerificationPage fillingDataModel(Product product)
    {
        agreeSiteRulesButton.click();
        inputModelName.sendKeys(product.getProductName());
        inputModelName.sendKeys(Keys.ENTER);
        inputSerialNumber.sendKeys(product.getSerialNumber());
        submitReviewButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.error("Successful completion of serial number data");

        return this;
    }

    public String checkVerificationMessage()
    {
        waitForElementToBeClickable(this.driver, By.xpath("/html/body/div[6]/div[4]/div/div/p/span"));
        String userError = verificationReport.getText();
        logger.error("Serial number information: " + verificationReport.getText());

        return userError;
    }

}
