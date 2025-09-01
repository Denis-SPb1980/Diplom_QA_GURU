package web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.ConfigReader;
import config.WebConfig;
import io.qameta.allure.Step;
import utils.ActionsHelper;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement loginButton = $x("//*[@class='hcontrols__item js_popup_trigger isinit']");
    private final SelenideElement loginWithPasswordButton = $("#loginByPassword");
    private final SelenideElement loginInput = $(by("name", "username"));
    private final SelenideElement passwordInput = $(by("name", "password"));
    private final SelenideElement signInButton = $x("//*[@id='auth_form']/div[2]/div");
    private final SelenideElement priceFilterRadioButton = $x("//*[@class='digi-radio-buttons']/div[4]/label/span[1]");
    private final SelenideElement colorFilterCheckbox =  $x("//span[text()='чёрный']");
    private final ElementsCollection productList = $$x("//*[@class = 'digi-products-grid digi-products-grid_horde']");
    private final SelenideElement basketButton = $x("//*[@class = 'digi-products-grid digi-products-grid_horde']/div[1]/div/div[3]/a");

    ActionsHelper actionsHelper = new ActionsHelper();
    private static final WebConfig webConfig = ConfigReader.Instance.read();

    @Step("Открыть страницу")
    public MainPage openPage() {
        open("https://pitergsm.ru");
        actionsHelper.removeFixedElements();
        return this;
    }

    @Step("Клик на кнопку 'Войти' в хедере")
    public MainPage clickLogin() {
        loginButton.shouldHave(visible);
        loginButton.click();
        return this;
    }

    @Step("Клик на кнопку 'Войти с паролем'")
    public MainPage clickLoginWithPassword() {
        loginWithPasswordButton.click();
        return this;
    }

    @Step("Ввести логин")
    public MainPage setLogin(){
        loginInput.setValue(webConfig.getLogin());
        return this;
    }

    @Step("Ввести пароль")
    public MainPage setPassword(){
        passwordInput.setValue(webConfig.getPassword());
        return this;
    }


    @Step("Проверка отображения найденных товаров")
    public MainPage checkProductList() {
        productList.shouldBe(sizeGreaterThan(0));
        return this;
    }

    @Step("Клик на кнопку 'Войти'")
    public void clickSignIn(){
        signInButton.click();
    }

    @Step("Клик на кнопку 'В корзину'")
    public CatalogPage clickBasket(){
        basketButton.click();
        return new CatalogPage();
    }

    @Step("Клик на фильтр 'Цена'")
    public MainPage clickPriceFilter() {
        priceFilterRadioButton.click();
        return this;
    }

    @Step("Клик на фильтр 'Цвет'")
    public MainPage clickColorFilter() {
        colorFilterCheckbox.click();
        return this;
    }
}