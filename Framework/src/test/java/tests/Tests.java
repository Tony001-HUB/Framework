package tests;

import model.Product;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import service.ProductCreator;
import service.UserCreator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class Tests extends CommonConditions
{
    //CD /Framework
    //mvn -Dbrowser=chrome -Denvironment=CommonToAllTests -Dsurefire.suiteXmlFiles=src\test\resources\testng-all clean test
    //mvn -Dbrowser=gecko -Denvironment=CommonToAllTests -Dsurefire.suiteXmlFiles=src\test\resources\testng-all clean test
    //mvn -Dbrowser=chrome -Denvironment=InvalidPassword -Dsurefire.suiteXmlFiles=src\test\resources\testng-all clean test
    //chcp 1251

    @Test(priority = 1)
    public void registrationWithLowLimitSymbols()
    {
        User userWithInvalidPassword = UserCreator.WithLowLimitSymbols();
        new RegistrationPage()
        .openPage()
        .userRegistration(userWithInvalidPassword)
        .checkErrorMessage();

        //assertThat(registrationPage.checkErrorMessage()).isEqualTo("Пароль должен включать не менее 8 знаков и может содержать буквы латинского алфавита, цифры и следующие символы ! \" # $ % & ' ( ) * + , - . / : ; < = > ? @ [ \\ ] ^ _ ` { | } ~");
    }

    @Test(priority = 2)
    public void failedLogin()
    {
        User userInvalidPassword = UserCreator.InvalidPassword();
        String errorMessage = new LoginPage()
        .openPage()
        .userLogin(userInvalidPassword)
        .checkErrorMessage();

        //assertThat(errorMessage.checkErrorMessage()).isEqualTo("Неправильный адрес электронной почты или пароль");
    }

    @Test(priority = 3)
    public void searchByModelName()
    {
        Product productName = ProductCreator.EnterProductName();
        int expectedSearchResult = new HomePage()
        .openPage()
        .searchForTerms(productName)
        .countGeneralNumberOfSearchResults();

        Assert.assertTrue(expectedSearchResult > 0, "search result are empty!");
    }

    @Test(priority = 4)
    public void addItemInShoppingCart()
    {
        AddProductToCartPage addProductToCartPage = new AddProductToCartPage()
               .openPage()
               .addProductToCart();

        assertThat(addProductToCartPage.getPrice()).isEqualTo("7 499");
        assertThat(addProductToCartPage.getArticul()).isEqualTo("3884C005");
    }

    @Test(priority = 5)
    public void deletingFromShoppingCart()
    {
        new DeleteProductFromCartPage()
                .openPage()
                .deleteProductFromCart();
    }

    @Test(priority = 6)
    public void TestingPerformanceFilterSearch()
    {
        int expectedSearchResult = new HomePage()
                .openPage()
                .searchByOptions()
                .selectionByPrice()
                .selectionByDestination()
                .countGeneralNumberOfSearchResults();

        Assert.assertTrue(expectedSearchResult > 0, "search result are empty!");
    }

    //wait.until(stalenessOf(switchPriceDescendingOrderButton));
    @Test(priority = 7)
    public void checkingSerialNumber()
    {
        Product product = ProductCreator.EnterProductNameAndSerialNumber();
        String serialNumberInformation = new SerialNumberVerificationPage()
                .openPage()
                .fillingDataModel(product)
                .checkVerificationMessage();

        //assertThat(serialNumberInformation.checkVerificationMessage()).isEqualTo("По вашей покупке требуется дополнительная проверка. Свяжетесь, пожалуйста, с центром поддержки клиентов компании Canon через веб-форму для отправки сообщений.");
    }

    @Test(priority = 8)
    public void getPromoCodeWithoutRequiredField()
    {
       String errorMessage = new GettingFellPromoCodePage()
                .openPage()
                .gettingPromoCode()
                .checkErrorMessage()
        ;

        //assertThat(errorMessage.checkErrorMessage()).isEqualTo("Данная электронная почта уже используется");
    }

    @Test(priority = 9)
    public void productsComparison()
    {
        int expectedSearchResult = new AddToCompareTwoProductsPage()
                .openPage()
                .addingCompareFirstProduct()
                .openPageSecondItem()
                .addingCompareSecondProduct()
                .openProductComparisonPage()
                .countGeneralNumberOfSearchResults()
                ;

        Assert.assertTrue(expectedSearchResult > 0, "search result are empty!");
    }

    @Test(priority = 10)
    public void deleteProductsComparisonFromList()
    {
        int expectedSearchResult = new AddToCompareTwoProductsPage()
                .openPage()
                .addingCompareFirstProduct()
                .openPageSecondItem()
                .addingCompareSecondProduct()
                .openProductComparisonPage()
                .deleteProduct()
                .countGeneralNumberOfSearchResults()
                ;

        Assert.assertTrue(expectedSearchResult > 0, "search result are empty!");
    }
}
