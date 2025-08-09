package api.specs;

import api.models.ProductSearchResponse;
import io.qameta.allure.Step;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class SearchSpec {

    public static RequestSpecification requestSearchSpec (String st, String size, String apiKey) {
        return with()
                .filter(withCustomTemplates())
                .log().uri()
                .log().body()
                .log().headers()
                .contentType("multipart/form-data")
                .multiPart("st", st)
                .multiPart("size", size)
                .multiPart("apiKey", apiKey);
    }

    @Step("Проверка ответа метода")
    public static ResponseSpecification responseSearchSpec(int expectedStatusCode, String expectedName, int expectedSize) {
        return new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .expectBody("query", is(expectedName))
                .expectBody("correction", is(expectedName))
                .expectBody("products", hasSize(expectedSize))
                .log(STATUS)
                .log(BODY)
                .build();
    }

    @Step("Проверка ответа метода")
    public static ResponseSpecification responseSearchSpec(int expectedStatusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .log(STATUS)
                .log(BODY)
                .build();
    }

//    @Step("Проверка ответа метода")
//    public static ResponseSpecification responseAuthorizationSpec(int expectedStatusCode, boolean expectedSuccess) {
//        return new ResponseSpecBuilder()
//                .expectStatusCode(expectedStatusCode)
//                .expectBody("success", is(expectedSuccess))
//                .log(STATUS)
//                .log(BODY)
//                .build();
//    }

}

//        .body("query", is("iphone 15"))
//        .body("correction", is("iphone 15"))
//        .body("products",hasSize(5))
//        .extract().as(ProductSearchResponse .class);