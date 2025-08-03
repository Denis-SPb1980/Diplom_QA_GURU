package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    private final SelenideElement buyButton = $x("//*[@class ='product__btns']/div");
    private final SelenideElement addToFavoritesButton = $x("//*[@class = 'product__control-btns']/button[1]");
    private final SelenideElement goToBasketButton = $x("//*[@class = 'popup__prodbtns']/a");

    @Step("Клик на кнопку 'Купить'")
    public CatalogPage clickBuy() {
//        Configuration.timeout = 60000;
//        waitForPageToLoad();
//        buyButton.shouldBe(visible).shouldBe(enabled).click();
        buyButton.click();
        return this;
    }

    private void waitForPageToLoad() {
        executeJavaScript("return document.readyState").equals("complete");
    }

    @Step("Клик на кнопку 'Перейти в корзину'")
    public CartPage clickGoToBasket() {
        goToBasketButton.click();
        return new CartPage();
    }

    @Step("Клик на кнопку 'Добавить в избранное'")
    public CatalogPage clickAddToFavorites() {
        addToFavoritesButton.click();
        return this;
    }
}