package page;

import driver.DriverSingleton;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractPage
{
    private static final String RegistrationForm_URL = "https://myid.canon/canonid/#/registration";
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

    public RegistrationPage()
    {
        super(DriverSingleton.getDriver());
    }

    public RegistrationPage openPage()
    {
        driver.get(RegistrationForm_URL);
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
        logger.error("Successful completion of user data");

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

}

