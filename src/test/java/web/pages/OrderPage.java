package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {

    private final SelenideElement placeAnOrderButton = $x("//*[@class = 'checkout__order-btns']/button");

    @Step("Проверка оформленного товара")
    public void checkingTheIssuedGoods() {
        placeAnOrderButton.shouldBe(visible);
    }
}