package tests;

import model.User;
import org.testng.annotations.Test;
import page.LoginPage;
import page.RegistrationPage;
import service.UserCreator;

public class Tests extends CommonConditions
{
    //CD /Framework
    //mvn -Dbrowser=chrome -Denvironment=LowLimitSymbols -Dsurefire.suiteXmlFiles=src\test\resources\testng-all clean test
    //mvn -Dbrowser=chrome -Denvironment=InvalidPassword -Dsurefire.suiteXmlFiles=src\test\resources\testng-all clean test
    //chcp 1251

    //@Test(priority = 1)
    public void registrationWithLowLimitSymbols()
    {
        User userWithInvalidPassword = UserCreator.WithLowLimitSymbols();
        new RegistrationPage(driver)
        .openPage()
        .userRegistration(userWithInvalidPassword)
        .checkErrorMessage();
    }

    @Test
    public void failedLogin()
    {
        User userInvalidPassword = UserCreator.InvalidPassword();
        new LoginPage(driver)
        .openPage()
        .userLogin(userInvalidPassword)
        .checkErrorMessage();
    }

    //@Test
    public void searchByModelName()
    {

    }

    //@Test
    public void addItemInShoppingCart()
    {

    }

    //@Test
    public void deletingFromShoppingCart()
    {

    }

    //@Test
    public void TestingPerformanceFilterSearch()
    {

    }

    //@Test
    public void checkCorrectlyWorkSearchFilter()
    {

    }

    //@Test
    public void createReviewOnProduct()
    {

    }

    //@Test
    public void usePromoCode()
    {

    }

    //@Test
    public void productsComparison()
    {

    }
}
