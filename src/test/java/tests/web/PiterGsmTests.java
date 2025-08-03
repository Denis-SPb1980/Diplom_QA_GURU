package tests.web;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.TestData;

import static com.codeborne.selenide.Selenide.sleep;

@Epic("Web")
@Tag("web")
public class PiterGsmTests {

    MainPage mainPage = new MainPage();
    ProfilePage profilePage = new ProfilePage();
    CartPage cartPage = new CartPage();
    TestData testData = new TestData();
    OrderPage orderPage = new OrderPage();
    HeaderPage headerPage = new HeaderPage();
    String password = testData.password;

    //Успешная автоизация в магазине PiterGSM  5z6zx@mechanicspedia.com 123456
    @Test
    @DisplayName("Успешная авторизация по почте и паролю")
    public void authorizationMarketTest() {
        mainPage.openPage()
                .clickLogin()
                .clickLoginWithPassword()
                .setLogin()
                .setPassword()
                .clickSignIn();

        headerPage.checkLogoutText("Выйти");
    }

    @Test
    @DisplayName("Успешная регистрация с заполнением всех полей")
    public void registrationMarketTest() {
        profilePage.openPage()
                .clickRegistration()
                .setName(testData.firstName)
                .setLastName(testData.lastName)
                .setLogin(testData.login)
                .setPassword(password)
                .setConfirmPassword(password)
                .setEmail(testData.email)
                .passingCaptcha()
                .clickRegister();

        headerPage.checkLogoutText("Выйти");
    }

    @Test
    @DisplayName("Ошибка регистрации при непрохождении капчи")
    public void registrationErrorMarketTest() {
        profilePage.openPage()
                .clickRegistration()
                .setName(testData.firstName)
                .setLastName(testData.lastName)
                .setLogin(testData.login)
                .setPassword(password)
                .setConfirmPassword(password)
                .setEmail(testData.email)
                .clickRegister();

        profilePage.checkErrorText("Вы не прошли проверку.");
    }

    @Test
    @DisplayName("Успешный поиск продукта")
    public void productSearchTest() {
        mainPage.openPage();
        headerPage.setSearch("sony playstation 5");

        mainPage.checkProductList();
    }

    @Test
    public void addProductBasketTest() {
        mainPage.openPage();
        headerPage.setSearch("macbook air m4")
                .clickBasket();

        sleep(5000);

//        mainPage.checkProductList();
    }

    @Test
    @DisplayName("Успешное оформление заказа")
    public void orderProductTest() {
        mainPage.openPage();
        headerPage.setSearch("macbook air m4")
                .clickBasket()
                .clickBuy()
                .clickGoToBasket()
                .clickGoToCheckout();

        orderPage.checkingTheIssuedGoods();
    }

    @Test
    @DisplayName("Успешное удаление товара из корзины")
    public void removeItemFromCartTest() {
        mainPage.openPage();
        headerPage.setSearch("apple iphone 16 pro")
                .clickBasket()
                .clickBuy()
                .clickGoToBasket()
                .clickDelete();

        cartPage.checkingEmptyCart("Ваша корзина пуста");
    }

    @Test
    @DisplayName("Успешное добавление товара в избранное")
    public void addItemToFavoritesTest() {
        mainPage.openPage();
        headerPage.setSearch("apple ipad")
                .clickBasket()
                .clickAddToFavorites();

        headerPage.checkingTheFavoritesCounter("1");
    }

    @Test
    @DisplayName("Успешное оформление заказа с фильтрами")
    public void orderProductWithFiltersTest() {
        mainPage.openPage();
        headerPage.setSearch("Apple Watch")
                .clickPriceFilter()
                .clickColorFilter()
                .clickBasket()
                .clickBuy()
                .clickGoToBasket()
                .clickGoToCheckout();

        orderPage.checkingTheIssuedGoods();
    }
}