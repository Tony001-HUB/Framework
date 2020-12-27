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

public class GettingFellPromoCodePage {

    private static final String PromoCode_URL = "https://store.canon.ru";
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();


    @FindBy(id="subscriptionEmailfooter")
    private WebElement enteringGmail;

    @FindBy(id="checkbox-agreements-error")
    private WebElement errorReport;

    @FindBy(className="//*[@id=\"footerSubscription\"]/form/div[1]/div[6]/label")
    private WebElement acceptanceTermsPromotion;

    @FindBy(xpath="//*[@id=\"footerSubscription\"]/form/div[1]/button")
    private WebElement buttonForGettingPromoCode;


    public GettingFellPromoCodePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public GettingFellPromoCodePage openPage()
    {
        this.driver.get(PromoCode_URL);
        return this;
    }

    public GettingFellPromoCodePage gettingPromoCode()
    {
        enteringGmail.sendKeys("hguihggjjh@gmail.com");
        buttonForGettingPromoCode.click();
        return this;
    }

    public String checkErrorMessage()
    {
        waitForElementToVisibility(this.driver, By.id("checkbox-agreements-error"));
        String userError = errorReport.getText();
        logger.error("Error information: " + errorReport.getText());

        return userError;
    }

    private  WebElement waitForElementToVisibility(WebDriver driver, By by) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(by));
    }


}
