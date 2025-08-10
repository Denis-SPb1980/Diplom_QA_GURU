package api.specs;

import io.qameta.allure.Step;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AddToCartSpec {
    public static RequestSpecification requestCartSpec(String id) {
        return with()
                .filter(withCustomTemplates())
                .log().uri()
                .log().body()
                .log().headers()
                .contentType("multipart/form-data")
                .multiPart("id", id);
    }

    @Step("Проверка ответа метода")
    public static ResponseSpecification responseCartSpec(int expectedStatusCode, boolean expectedSuccess, String expectedIdProduct) {
        return new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .expectBody("success", is(expectedSuccess))
                .expectBody("item.ID", equalTo(expectedIdProduct))
                .log(STATUS)
                .log(BODY)
                .build();
    }

    @Step("Проверка ответа метода")
    public static ResponseSpecification responseCartSpec(int expectedStatusCode, boolean expectedSuccess) {
        return new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .expectBody("success", is(expectedSuccess))
                .log(STATUS)
                .log(BODY)
                .build();
    }
}