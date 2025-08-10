package api.specs;

import io.qameta.allure.Step;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.is;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class AuthorizationSpec {

    public static RequestSpecification requestAuthorizationSpec = with()
            .filter(withCustomTemplates())
            .headers("Origin", "https://pitergsm.ru")
            .headers("Referer", "https://pitergsm.ru/")
            .contentType("multipart/form-data")
            .log().uri()
            .log().body()
            .log().headers();


    @Step("Проверка ответа метода")
    public static ResponseSpecification responseAuthorizationSpec(int expectedStatusCode, boolean expectedSuccess) {
        return new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .expectBody("success", is(expectedSuccess))
                .log(STATUS)
                .log(BODY)
                .build();
    }
}