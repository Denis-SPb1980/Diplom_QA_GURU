package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {

    private final SelenideElement logoutButton = $("a[href='/personal/profile/?logout=yes']");
    private final SelenideElement searchInput = $(by("placeholder", "Поиск"));
    private final SelenideElement favoritesCounter = $("#header__favorites-counter");

    public void checkLogoutText(String expectedText){
        logoutButton.shouldHave(text(expectedText));
    }

    public MainPage setSearch(String nameProduct) {
        searchInput.setValue(nameProduct).pressEnter();
        return new MainPage();
    }

    public void checkingTheFavoritesCounter(String number) {
        favoritesCounter.shouldHave(attribute("data-counter", number));

    }
}
