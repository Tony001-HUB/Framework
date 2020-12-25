package tests;

import model.Product;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.AddProductToCartPage;
import page.HomePage;
import page.LoginPage;
import page.RegistrationPage;
import service.ProductCreator;
import service.UserCreator;

public class Tests extends CommonConditions
{
    //CD /Framework
    //mvn -Dbrowser=chrome -Denvironment=CommonToAllTests -Dsurefire.suiteXmlFiles=src\test\resources\testng-all clean test
    //mvn -Dbrowser=chrome -Denvironment=InvalidPassword -Dsurefire.suiteXmlFiles=src\test\resources\testng-all clean test
    //chcp 1251

   // @Test(priority = 1)
    public void registrationWithLowLimitSymbols()
    {
        User userWithInvalidPassword = UserCreator.WithLowLimitSymbols();
        new RegistrationPage(driver)
        .openPage()
        .userRegistration(userWithInvalidPassword)
        .checkErrorMessage();
    }

   // @Test(priority = 2)
    public void failedLogin()
    {
        User userInvalidPassword = UserCreator.InvalidPassword();
        new LoginPage(driver)
        .openPage()
        .userLogin(userInvalidPassword)
        .checkErrorMessage();
    }

    //@Test(priority = 3)
    public void searchByModelName()
    {
        Product productName = ProductCreator.EnterProductName();
        int expectedSearchResult = new HomePage(driver)
        .openPage()
        .searchForTerms(productName)
        .countGeneralNumberOfSearchResults();

        Assert.assertTrue(expectedSearchResult > 0, "search result are empty!");
    }

    @Test(priority = 4)
    public void addItemInShoppingCart()
    {
       new AddProductToCartPage(driver)
               .openPage()
               .addProductToCart();

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
