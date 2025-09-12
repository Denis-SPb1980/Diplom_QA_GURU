package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static constants.PiterGsmConstants.*;
import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.is;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class AuthorizationSpec {

    public static RequestSpecification requestAuthorizationSpec = with()
            .filter(withCustomTemplates())
            .headers("Origin", ORIGIN)
            .headers("Referer", REFERER)
            .headers("User-Agent", USER_AGENT)
            .contentType("multipart/form-data")
            .log().uri()
            .log().body()
            .log().headers();

    public static ResponseSpecification responseAuthorizationSpec(int expectedStatusCode, boolean expectedSuccess) {
        return new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .expectBody("success", is(expectedSuccess))
                .log(STATUS)
                .log(BODY)
                .build();
    }
}