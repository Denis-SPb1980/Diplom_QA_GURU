package api.tests;

import api.models.AddToCartRequest;
import api.models.AddToCartResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.specs.AddToCartSpec.requestCartSpec;
import static api.specs.AddToCartSpec.responseCartSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class AddToCartTests extends ApiBaseTest {

    AddToCartRequest toCartRequest = new AddToCartRequest();

    @Test
    @DisplayName("Успешное добавление товара в корзину")
    void addValidProductBasketTest() {

        step("Добавление существующего товара в корзину", () ->
                given(requestCartSpec(toCartRequest.getId()))

                        .when()
                        .post("/add2basket.php")

                        .then()
                        .spec(responseCartSpec(200, true, toCartRequest.getId()))
                        .extract());
    }

    @Test
    @DisplayName("Добавление несуществующего товара в корзину")
    void addInvalidProductBasketTest() {

        AddToCartResponse response = step("Добавление некорректного ID товара в корзину", () ->
                given(requestCartSpec("0"))

                        .when()
                        .post("/add2basket.php")

                        .then()
                        .spec(responseCartSpec(200, false))
                        .extract().as(AddToCartResponse.class));

        step("Проверка полученной ошибки", () ->
                assertThat(response.getError()).isEqualTo("Invalid product ID"));
    }
}