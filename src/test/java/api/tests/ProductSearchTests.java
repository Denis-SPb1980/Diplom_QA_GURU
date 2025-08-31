package api.tests;

import api.models.ProductSearchRequest;
import api.models.ProductSearchResponse;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specs.SearchSpec.requestSearchSpec;
import static api.specs.SearchSpec.responseSearchSpec;
import static api.tests.ApiBaseTest.SEARCH_URI;
import static constants.Owners.DMISHCHENKO;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("all_api")
@Owner(DMISHCHENKO)
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
    @DisplayName("Ошибка при вызове метода без передачи параметра 'apiKey'")
    void missingApiKeyTest() {

        ProductSearchResponse response = step("Вызов метода без передачи парарметра 'apiKey'", () ->
                given(requestSearchSpec(sizeProducts))
                        .multiPart("st", nameProduct)
                        .when()
                        .get(SEARCH_URI)
                        .then()
                        .spec(responseSearchSpec(500))
                        .extract().as(ProductSearchResponse.class));

        step("Проверка полученных ошибок", () -> {
            assertThat(response.getError()).isEqualTo("Internal Server Error");
            assertThat(response.getMessage()).isEqualTo("ApiKey is null or not exist");
        });
    }

    @Test
    @DisplayName("Ошибка при вызове метода без передачи параметра 'SearchTerm'")
    void missingSearchTermTest() {

        ProductSearchResponse response = step("Вызов метода без передачи параметра 'SearchTerm'", () ->
                given(requestSearchSpec(sizeProducts))
                        .multiPart("apiKey", productSearch.getApiKey())
                        .when()
                        .get(SEARCH_URI)
                        .then()
                        .spec(responseSearchSpec(500))
                        .extract().as(ProductSearchResponse.class));

        step("Проверка полученных ошибок", () -> {
            assertThat(response.getError()).isEqualTo("Internal Server Error");
            assertThat(response.getMessage()).isEqualTo("SearchTerm is empty");
        });

    }

    @Test
    @DisplayName("Ошибка при вызове метода с пустым значением")
    void searchQueryWasPassedEmptyTest() {

        ProductSearchResponse response = step("Вызов метода с пустым значением поиска", () ->
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