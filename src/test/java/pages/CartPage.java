package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    private final SelenideElement goToCheckoutButton = $x("//*[@class = 'total__btns']/a");
    private final SelenideElement deleteButton = $x("//*[@class = 'cart-prodcard__controls']/a");
    private final SelenideElement emptyCartText = $(".bx-sbb-empty-cart-text");

    public OrderPage clickGoToCheckout() {
        goToCheckoutButton.click();
        return new OrderPage();
    }

    public void clickDelete() {
        deleteButton.click();
    }

    public void checkingEmptyCart(String expectedText) {
        emptyCartText.shouldHave(exactText(expectedText));
    }

}