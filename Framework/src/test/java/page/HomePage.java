package page;

import driver.DriverSingleton;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.TestDataReader;

public class HomePage extends AbstractPage{


    private static final String HomeForm_URL = TestDataReader.getTestData("test.data.HomeForm.link");
    private final Logger logger = LogManager.getRootLogger();


    @FindBy(id = "registerEmail")
    private WebElement regEmail;

    @FindBy(id = "registerPassword")
    private WebElement regPassword;

    @FindBy(id = "firstname")
    private WebElement regFirstname;

    @FindBy(id = "lastname")
    private WebElement regLastname;

    @FindBy(id = "registerPassword-error")
    private WebElement regError;

    @FindBy(id = "loginEmail")
    private WebElement logEmail;

    @FindBy(id = "loginPassword")
    private WebElement logPassword;

    @FindBy(xpath = "//*[@class=\"header-top-links__link js-authorization-link\"]")
    private WebElement clickLogIn;

    @FindBy(xpath = "//*[@id=\"page-header\"]/div[2]/div/div[3]/a[2]")
    private WebElement clickRegistration;

    @FindBy(xpath = "//*[@id=\"authorizationPopupContainer\"]/div/div[1]/form/div[4]")
    private WebElement loginError;

    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
    private WebElement clickButtonSearch;

    @FindBy(xpath="//*[@type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(xpath="//*[@id=\"authorizationPopupContainer\"]/div/div[1]/div[1]")
    private WebElement checkLoginLocation;

    @FindBy(xpath="//*[@id=\"authorizationPopupContainer\"]/div/div[2]/div[2]")
    private WebElement checkRegLocation;

    public HomePage()
    {
        super(DriverSingleton.getDriver());
    }

    public HomePage openPage()
    {
        driver.get(HomeForm_URL);
        return this;
    }

    public HomePage openRegistrationForm()
    {
        clickRegistration.click();

        return this;
    }

    public HomePage inputRegFirstname(User user)
    {
        regFirstname.sendKeys(user.getUserName());

        return this;
    }

    public HomePage inputRegLastname(User user)
    {
        regLastname.sendKeys(user.getUserLastName());

        return this;
    }

    public HomePage inputRegLogin(User user)
    {
        regEmail.sendKeys(user.getUserEmail());

        return this;
    }

    public HomePage inputRegPassword(User user)
    {
        regPassword.sendKeys(user.getUserPassword());

        return this;
    }

    public HomePage openLoginForm()
    {
        clickLogIn.click();

        return this;
    }

    public HomePage inputLogin(User user)
    {
        logEmail.sendKeys(user.getUserEmail());

        return this;
    }


    public HomePage inputPassword(User user)
    {
        logPassword.sendKeys(TestDataReader.getTestData("testdata.user.loginPassword"));

        return this;
    }

    public HomePage submitButtonClick()
    {
        submitButton.click();
        waitForElementToBeVisibility(this.driver, By.xpath("//*[@id=\"authorizationPopupContainer\"]/div/div[1]/form/div[4]"));

        return this;
    }

    public String getLoginMessage()
    {
        return loginError.getText();
    }


    public String getRegMessage(){ return regError.getText(); }

    public String getLoginLocation()
    {
        return checkLoginLocation.getText();
    }

    public String getRegLocation()
    {
        return checkRegLocation.getText();
    }

    public String getCurrentUrl(){ return HomeForm_URL; }
}
