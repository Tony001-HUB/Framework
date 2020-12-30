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

    @Test(priority = 1)
    public void registrationWithLowLimitSymbols()
    {
        User user = UserCreator.WithLowLimitSymbols();
        HomePage homePage = new HomePage()
                .openPage()
                .openRegistrationForm()
                .inputRegFirstname(user)
                .inputRegLastname(user)
                .inputRegLogin(user)
                .inputRegPassword(user)
                ;

        String currentUrl= "https://store.canon.ru/#";

        assertThat(homePage.getCurrentUrl()).isEqualTo(currentUrl);
        assertThat(homePage.getRegLocation()).isEqualTo("Регистрация");
        assertThat(homePage.getRegMessage()).isEqualTo("Введите 7 или больше символов");
    }

    @Test(priority = 2)
    public void failedLogin()
    {
        User user = UserCreator.InvalidPassword();
        HomePage homePage = new HomePage()
                .openPage()
                .openLoginForm()
                .inputLogin(user)
                .inputPassword(user)
                .submitButtonClick();

        String currentUrl= "https://store.canon.ru/#";

        assertThat(homePage.getCurrentUrl()).isEqualTo(currentUrl);
        assertThat(homePage.getLoginLocation()).isEqualTo("Вход");
        assertThat(homePage.getLoginMessage()).isEqualTo("Неверный логин или пароль.");
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
        SerialNumberVerificationPage serialNumberInformation = new SerialNumberVerificationPage()
                .openPage()
                .fillingDataModel(product)
                ;

        assertThat(serialNumberInformation.checkVerificationMessage()).isEqualTo("По вашей покупке требуется дополнительная проверка. Свяжетесь, пожалуйста, с центром поддержки клиентов компании Canon через веб-форму для отправки сообщений.");
    }

    @Test(priority = 8)
    public void getPromoCodeWithoutRequiredField()
    {
        GettingFellPromoCodePage errorMessage = new GettingFellPromoCodePage()
                .openPage()
                .gettingPromoCode()
        ;

        assertThat(errorMessage.checkErrorMessage()).isEqualTo("Данная электронная почта уже используется");
    }

    @Test(priority = 9)
    public void productsComparison()
    {
        int expectedSearchResult = new AddToCompareProductsPage()
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
        int expectedSearchResult = new AddToCompareProductsPage()
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
