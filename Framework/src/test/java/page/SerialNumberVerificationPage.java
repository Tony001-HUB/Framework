package page;

import model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SerialNumberVerificationPage
{
    private static final String SerialNumberVerificationForm_URL = "https://www.canon.ru/about_us/serial-number-checker/#serial";
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "/html/body/div[6]/div[1]/span[1]/span[1]/span/ul/li/input")
    private WebElement  inputModelName;

    @FindBy(xpath = "//*[@id=\"cps-form-input-serial-number-a\"]")
    private WebElement  inputSerialNumber;

    @FindBy(xpath = "/html/body/div[6]/div[4]/div/div")
    private WebElement  verificationReport;

    @FindBy(id="btnsubmit")
    private WebElement submitReviewButton;

    @FindBy(id="_evidon-accept-button")
    private WebElement agreeSiteRulesButton;


    public SerialNumberVerificationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public SerialNumberVerificationPage openPage()
    {
        this.driver.get(SerialNumberVerificationForm_URL);
        return this;
    }

    public SerialNumberVerificationPage fillingDataModel(Product product)
    {
        agreeSiteRulesButton.click();
        inputModelName.sendKeys(product.getProductName());
        inputSerialNumber.sendKeys(product.getSerialNumber());
        submitReviewButton.click();

        return this;
    }

    public String checkVerificationMessage()
    {
        String userError = verificationReport.getText();
        logger.info("Serial number information: " + verificationReport.getText());

        return userError;
    }



}
