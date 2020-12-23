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

public class RegistrationPage
{
    private static final String RegistrationForm_URL = "https://myid.canon/canonid/#/registration";
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "regEmail")
    private WebElement inputLogin;

    @FindBy(id = "pw-input")
    private WebElement inputPassword;

    @FindBy(id = "regFirstName")
    private WebElement inputUserName;

    @FindBy(id = "regLastName")
    private WebElement inputUserLastName;

    @FindBy(id = "regButton")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//*[@id=\"site-container\"]/registration-container/div/user-registration/md-content[2]/div/form/password-field/md-input-container/div[2]/div[2]")
    private WebElement registerError;

    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public RegistrationPage openPage()
    {
        this.driver.get(RegistrationForm_URL);
        this.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        return this;
    }

    public RegistrationPage userRegistration(User user)
    {
        waitForElementToBeClickable(this.driver, By.id("site-container"));
        inputLogin.sendKeys(user.getUserEmail());
        inputPassword.sendKeys(user.getUserPassword());
        inputUserName.sendKeys(user.getUserName());
        inputUserLastName.sendKeys(user.getUserLastName());
        buttonSubmit.click();

        return this;
    }

    public String checkErrorMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"site-container\"]/registration-container/div/user-registration/md-content[2]/div/form/password-field/md-input-container/div[2]/div[2]")));
        String userError = registerError.getText();
        logger.error("The following errors were received during registration: " + userError);

        return userError;
    }


    private  WebElement waitForElementToBeClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .elementToBeClickable(by));
    }


}

