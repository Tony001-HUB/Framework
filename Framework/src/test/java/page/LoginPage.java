package page;

import driver.DriverSingleton;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage
{

    private static final String LoginForm_URL = "http://myid.canon/canonid/#/login";
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

    public LoginPage()
    {
        super(DriverSingleton.getDriver());
    }

    @Override
    public LoginPage openPage()
    {
        driver.get(LoginForm_URL);
        return this;
    }

    public LoginPage userLogin(User user)
    {
        buttonTypeOfLogin.click();
        waitForElementToBeClickable(this.driver, By.xpath("//*[@id=\"gcid-button\"]"));
        inputLogin.sendKeys(user.getUserEmail());
        inputPassword.sendKeys(user.getUserPassword());
        enter.click();
        logger.error("Successful completion of user data");

        return this;
    }

    public String checkErrorMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String userError = loginError.getText();
        logger.error("The following errors were received during login: " + userError);

        return userError;
    }

}
