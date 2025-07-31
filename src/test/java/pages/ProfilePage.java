package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.ActionsHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {
    private final SelenideElement nameInput = $(by("name", "REGISTER[NAME]"));
    private final SelenideElement lastNameInput = $(by("name", "REGISTER[LAST_NAME]"));
    private final SelenideElement loginInput = $(by("name", "REGISTER[LOGIN]"));
    private final SelenideElement passwordInput = $(by("name", "REGISTER[PASSWORD]"));
    private final SelenideElement confirmPasswordInput = $(by("name", "REGISTER[CONFIRM_PASSWORD]"));
    private final SelenideElement emailInput = $(by("name", "REGISTER[EMAIL]"));
    private final SelenideElement registerButton = $(by("name", "register_submit_button"));
    private final SelenideElement registrationButton = $x("//*[@class = 'autorize-block__title nodesktop']/a[2]");
    private final SelenideElement kaptcha = $("#recaptcha-anchor");
    private final SelenideElement errorText = $(".errortext");

    ActionsHelper actionsHelper = new ActionsHelper();

    @Step("Открыть страницу")
    public ProfilePage openPage() {
        open("https://pitergsm.ru/personal/profile");
        actionsHelper.removeFixedElements();
        return this;
    }

    @Step("Клик на кнопку 'Регистрация'")
    public ProfilePage clickRegistration() {
        registrationButton.shouldHave(visible);
        registrationButton.click();
        return this;
    }

    @Step("Ввести имя")
    public ProfilePage setName(String firstName) {
        nameInput.setValue(firstName);
        return this;
    }

    @Step("Ввести фамилию")
    public ProfilePage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Ввести логин")
    public ProfilePage setLogin(String login) {
        loginInput.setValue(login);
        return this;
    }

    @Step("Ввести пароль")
    public ProfilePage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Ввести подтверждение пароля")
    public ProfilePage setConfirmPassword(String confirmPassword) {
        confirmPasswordInput.setValue(confirmPassword);
        return this;
    }

    @Step("Ввести email")
    public ProfilePage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Пройти капчу")
    public ProfilePage passingCaptcha() {
        switchTo().frame(0);
        kaptcha.click();
        switchTo().defaultContent();
        return this;
    }

    @Step("Клик на кнопку 'Зарегистрироваться'")
    public void clickRegister(){
        registerButton.click();
    }

    @Step("Пооверка наличия ошибки {expectedText}")
    public void checkErrorText(String expectedText){
        errorText.shouldHave(text(expectedText));
    }
}