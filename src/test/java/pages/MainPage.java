package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
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
//    private final SelenideElement searchInput = $(by("placeholder", "Поиск"));
    private final ElementsCollection productList = $$x("//*[@class = 'digi-products-grid digi-products-grid_horde']");
    private final SelenideElement basketButton = $x("//*[@class = 'digi-products-grid digi-products-grid_horde']/div[1]/div/div[3]/a");


//    private final ElementsCollection checkResult = $$("table tr");

    ActionsHelper actionsHelper = new ActionsHelper();

    public MainPage openPage() {
        open("https://pitergsm.ru/");
        actionsHelper.removeFixedElements();
        return this;
    }

    public MainPage clickLogin() {
        loginButton.shouldHave(visible);
        loginButton.click();
        return this;
    }

    public MainPage clickLoginWithPassword() {
        loginWithPasswordButton.click();
        return this;
    }

    public MainPage setLogin(){
        loginInput.setValue("5z6zx@mechanicspedia.com");
        return this;
    }

    public MainPage setPassword(){
        passwordInput.setValue("123456");
        return this;
    }

//    public MainPage setSearch(String nameProduct) {
//        searchInput.setValue(nameProduct).pressEnter();
//        return this;
//    }

    public MainPage checkProductList() {
        productList.shouldBe(sizeGreaterThan(0));
        return this;
    }

    public void clickSignIn(){
        signInButton.click();
    }

    public CatalogPage clickBasket(){
        basketButton.click();
        return new CatalogPage();
    }

    public MainPage clickPriceFilter() {
        priceFilterRadioButton.click();
        return this;
    }

    public MainPage clickColorFilter() {
        colorFilterCheckbox.click();
        return this;
    }




//    public AutomationPracticeFormPage setFirstName(String firstName) {
//        firstNameInput.setValue(firstName);
//        return this;
//    }
//
//    public AutomationPracticeFormPage setLastName(String lastName) {
//        lastNameInput.setValue(lastName);
//        return this;
//    }
//
//    public AutomationPracticeFormPage setEmail(String email) {
//        emailInput.setValue(email);
//        return this;
//    }
//
//    public AutomationPracticeFormPage setGender(String value) {
//        genderRadioButton.$(byText(value)).click();
//        return this;
//    }
//
//    public AutomationPracticeFormPage setPhoneNumber(String phoneNumber) {
//        phoneNumberInput.setValue(phoneNumber);
//        return this;
//    }
//
//    public AutomationPracticeFormPage setDateOfBirth(String day, String month, String year) {
//        dateOfBirth.click();
//        calendarComponent.setDate(day, month, year);
//        return this;
//    }
//
//    public AutomationPracticeFormPage setSubjects(String subjects) {
//        subjectsInput.setValue(subjects).pressEnter();
//        return this;
//    }
//
//    public AutomationPracticeFormPage setHobbies(String hobbies) {
//        hobbiesCheckBox.$(byText(hobbies)).click();
//        return this;
//    }
//
//    public AutomationPracticeFormPage uploadProfile(String classpath) {
//        uploadPicture.uploadPicture(classpath);
//        return this;
//    }
//
//    public AutomationPracticeFormPage setCurrentAddress(String currentAddress) {
//        currentAddressInput.setValue(currentAddress);
//        return this;
//    }
//
//    public AutomationPracticeFormPage setState(String state) {
//        stateSelect.scrollIntoView(true).click();
//        stateSelectInput.setValue(state).pressEnter();
//        return this;
//    }
//
//    public AutomationPracticeFormPage setCity(String city) {
//        citySelect.scrollIntoView(true).click();;
//        citySelectInput.setValue(city).pressEnter();
//        return this;
//    }

//    public void clickSubmit() {
//        submitButton.click();
//    }
//
//    public void checkResult(String key, String value) {
//        checkResult.findBy(text(key)).shouldHave(text(value));
//    }
//
//    public void verifyFormSubmittedSuccessfully(){
//        formSubmitted.shouldHave(text("Thanks for submitting the form"));
//    }
//
//    public void checkUnsubmitedForm(){
//        modal.shouldNotBe(visible);
//    }
}
