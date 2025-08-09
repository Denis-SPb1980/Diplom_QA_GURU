package api.tests;

import api.models.ProductSearchRequest;
import api.models.ProductSearchResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.specs.SearchSpec.requestSearchSpec;
import static api.specs.SearchSpec.responseSearchSpec;
import static api.tests.ApiBaseTest.SEARCH_URI;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductSearchTests {

    ProductSearchRequest productSearch = new ProductSearchRequest();
    String nameProduct = "iphone 15";
    String sizeProducts = "5";

    @Test
    @DisplayName("Успешный поиск товара")
    void successfulProductSearchTest() {

        step(String.format("Поиск товара с передачей квери параметра size %s", sizeProducts), () ->
                given(requestSearchSpec(nameProduct, sizeProducts, productSearch.getApiKey()))

                .when()
                .get(SEARCH_URI)

                .then()
                .spec(responseSearchSpec(200, nameProduct, 5))
                .extract());
    }

    @Test
    @DisplayName("Вызов метода без передачи в параметрах apiKey")
    void missingSearchTermTest() {
//        String authData = "{\"username\": \"5z6zx@mechanicspedia.com\", \"password\": \"123456\"}";

        ProductSearchResponse response = given()
                .multiPart("st", "iphone 15")
                .multiPart("size", "5")
//                .multiPart("apiKey", "9750TN84X6")
                .log().uri()

                .when()
                .get(SEARCH_URI)

                .then()
                .log().status()
                .log().body()
                .statusCode(500)
                .body("error", is("Internal Server Error"))
                .body("status", is(500))
                .body("message", is("ApiKey is null or not exist"))
                .extract().as(ProductSearchResponse.class);

//        System.out.println("Response: " + response.asString());
    }

    @Test
    void missingApiKeyTest() {
//        String authData = "{\"username\": \"5z6zx@mechanicspedia.com\", \"password\": \"123456\"}";

        Response response = given()
                .multiPart("size", "5")
                .multiPart("apiKey", "9750TN84X6")
                .log().uri()

                .when()
                .get(SEARCH_URI)

                .then()
                .log().status()
                .log().body()
                .statusCode(500)
                .body("error", is("Internal Server Error"))
                .body("status", is(500))
                .body("message", is("SearchTerm is empty"))
                .extract().response();

        System.out.println("Response: " + response.asString());
    }

    @Test
    @DisplayName("Ошибка при вызове метода с пустым значением")
    void searchQueryWasPassedEmptyTest() {

        ProductSearchResponse response =  step("Вызов метода с пустым значением поиска", () ->
                given(requestSearchSpec("", sizeProducts, productSearch.getApiKey()))

                .when()
                .get(SEARCH_URI)

                .then()
                .spec(responseSearchSpec(500))
                .extract().as(ProductSearchResponse.class));

        step("Проверка полученных ошибок", () -> {
                assertThat(response.getError()).isEqualTo("Internal Server Error");
                assertThat(response.getMessage()).isEqualTo("Normalized search term is empty");
                });
    }
}