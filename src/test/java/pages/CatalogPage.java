package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    private final SelenideElement buyButton = $x("//*[@class ='product__btns']/div");
    private final SelenideElement addToFavoritesButton = $x("//*[@class = 'product__control-btns']/button[1]");
    private final SelenideElement goToBasketButton = $x("//*[@class = 'popup__prodbtns']/a");
    private final SelenideElement priceFilterRadioButton = $("#price-range-3");

    public CatalogPage clickBuy() {
        buyButton.click();
        return this;
    }

    public CartPage clickGoToBasket() {
        goToBasketButton.click();
        return new CartPage();
    }

    public CatalogPage clickAddToFavorites() {
        addToFavoritesButton.click();
        return this;
    }

    public CatalogPage clickPriceFilter() {
        priceFilterRadioButton.click();
        return this;
    }
}
