package page;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.TestDataReader;

public class GettingFellPromoCodePage extends AbstractPage{

    private static final String PromoCode_URL = TestDataReader.getTestData("test.data.PromoCode.link");
    private final Logger logger = LogManager.getRootLogger();


    @FindBy(id="subscriptionEmailfooter")
    private WebElement enteringGmail;

    @FindBy(id="checkbox-agreements-error")
    private WebElement errorReport;

    @FindBy(className="//*[@id=\"footerSubscription\"]/form/div[1]/div[6]/label")
    private WebElement acceptanceTermsPromotion;

    @FindBy(xpath="//*[@id=\"footerSubscription\"]/form/div[1]/button")
    private WebElement buttonForGettingPromoCode;


    public GettingFellPromoCodePage()
    {
        super(DriverSingleton.getDriver());
    }

    @Override
    public GettingFellPromoCodePage openPage()
    {
        this.driver.get(PromoCode_URL);
        return this;
    }

    public GettingFellPromoCodePage gettingPromoCode()
    {
        enteringGmail.sendKeys("hguihggjjh@gmail.com");
        buttonForGettingPromoCode.click();
        logger.error("Email is entered and the button to get a promo code is pressed");

        return this;
    }

    public String checkErrorMessage()
    {
        waitForElementToBeVisibility(this.driver, By.id("checkbox-agreements-error"));
        String userError = errorReport.getText();
        logger.error("Error information: " + errorReport.getText());

        return userError;
    }


}
