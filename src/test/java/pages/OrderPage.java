package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {

    private final SelenideElement placeAnOrderButton = $x("//*[@class = 'checkout__order-btns']/button");

    public void checkResult() {
        placeAnOrderButton.shouldBe(visible);
    }
}
