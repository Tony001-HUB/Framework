package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private static final String RegistrationForm_URL = "https://myid.canon/canonid/#/login";
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "gcid-email")
    private WebElement inputLogin;

    @FindBy(id = "gcid-password")
    private WebElement inputPassword;

    @FindBy(id = "gcid-email-signin-text")
    private WebElement buttonTypeOfLogin;

    @FindBy(xpath = "//*[@id=\"gcid-error-text\"]")
    private WebElement loginError;

    @FindBy(id = "gcid-button")
    private WebElement enter;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage openPage()
    {
        this.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        this.driver.get(RegistrationForm_URL);

        return this;
    }

    public LoginPage userLogin(User user)
    {
        buttonTypeOfLogin.click();
        waitForElementToBeClickable(this.driver, By.xpath("//*[@id=\"gcid-button\"]"));
        inputLogin.sendKeys(user.getUserEmail());
        inputPassword.sendKeys(user.getUserPassword());
        enter.click();

        return this;
    }

    public String checkErrorMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String userError = loginError.getText();
        logger.error("The following errors were received during login: " + userError);

        return userError;
    }


    private  WebElement waitForElementToBeClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .elementToBeClickable(by));
    }
}
