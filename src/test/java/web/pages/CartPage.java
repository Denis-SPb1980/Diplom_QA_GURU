package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    private final SelenideElement goToCheckoutButton = $x("//*[@class = 'total__btns']/a");
    private final SelenideElement deleteButton = $x("//*[@class = 'cart-prodcard__controls']/a");
    private final SelenideElement emptyCartText = $(".bx-sbb-empty-cart-text");

    @Step("Клик на кнопку 'Перейти к оформлению'")
    public void clickGoToCheckout() {
        goToCheckoutButton.click();
    }

    @Step("Клик на кнопку 'Удалить'")
    public void clickDelete() {
        deleteButton.click();
    }

    @Step("Проверка отсутствия товаров в корзине")
    public void checkingEmptyCart(String expectedText) {
        emptyCartText.shouldHave(exactText(expectedText));
    }
}