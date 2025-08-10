package api.tests;

import api.models.AuthorizationRequest;
import api.models.AuthorizationResponse;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specs.AuthorizationSpec.requestAuthorizationSpec;
import static api.specs.AuthorizationSpec.responseAuthorizationSpec;
import static core.constants.Owners.DMISHCHENKO;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("all_api")
@Owner(DMISHCHENKO)
public class AuthorizationTests extends ApiBaseTest {

    AuthorizationRequest loginRequest = new AuthorizationRequest();

    @Test
    @DisplayName("Успешная авторизация пользователя")
    void successfulLoginTest() {

        step("Авторизация с указанием логина и пароля", () ->
                given(requestAuthorizationSpec)
                        .multiPart("username", loginRequest.getUsername())
                        .multiPart("password", loginRequest.getPassword())

                        .when()
                        .post("/login.php")

                        .then()
                        .spec(responseAuthorizationSpec(200, true))
                        .extract());
    }

    @Test
    @DisplayName("Ошибка авторизации пользователя")
    void loginFailedTest() {

        AuthorizationResponse response = step("Авторизация c некорректным паролем", () ->
                given(requestAuthorizationSpec)
                        .multiPart("username", loginRequest.getUsername())
                        .multiPart("password", loginRequest.getIncorrectPassword())

                        .when()
                        .post("/login.php")

                        .then()
                        .spec(responseAuthorizationSpec(200, false))
                        .extract().as(AuthorizationResponse.class));

        step("Проверка полученной ошибки", () ->
                assertThat(response.getMessage()).isEqualTo("Неверный логин или пароль."));
    }

    @Test
    @DisplayName("Ошибка авторизации пользователя, не передан пароль")
    void missingPasswordTest() {

        AuthorizationResponse response = step("Авторизация без передачи пароля", () ->
                given(requestAuthorizationSpec)
                        .multiPart("username", loginRequest.getUsername())

                        .when()
                        .post("https://pitergsm.ru/local/php_interface/tools/login.php")

                        .then()
                        .spec(responseAuthorizationSpec(200, false))
                        .extract().as(AuthorizationResponse.class));

        step("Проверка полученной ошибки", () ->
                assertThat(response.getMessage()).isEqualTo("Логин и пароль обязательны для заполнения."));
    }

    @Test
    @DisplayName("Ошибка авторизации пользователя, не передан email")
    void missingUsernameTest() {

        AuthorizationResponse response = step("Авторизация без передачи email", () ->
                given(requestAuthorizationSpec)
                        .multiPart("password", loginRequest.getPassword())

                        .when()
                        .post("/login.php")

                        .then()
                        .spec(responseAuthorizationSpec(200, false))
                        .extract().as(AuthorizationResponse.class));

        step("Проверка полученной ошибки", () ->
                assertThat(response.getMessage()).isEqualTo("Логин и пароль обязательны для заполнения."));
    }
}