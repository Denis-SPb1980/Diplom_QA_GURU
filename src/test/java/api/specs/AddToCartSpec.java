package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static constants.PiterGsmConstants.*;
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
                .headers("Origin", ORIGIN)
                .headers("Referer", REFERER)
                .headers("User-Agent", USER_AGENT)
                .contentType("multipart/form-data")
                .multiPart("id", id)
                .log().uri()
                .log().body()
                .log().headers();
    }

    public static ResponseSpecification responseCartSpec(int expectedStatusCode, boolean expectedSuccess, String expectedIdProduct) {
        return new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .expectBody("success", is(expectedSuccess))
                .expectBody("item.ID", equalTo(expectedIdProduct))
                .log(STATUS)
                .log(BODY)
                .build();
    }

    public static ResponseSpecification responseCartSpec(int expectedStatusCode, boolean expectedSuccess) {
        return new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .expectBody("success", is(expectedSuccess))
                .log(STATUS)
                .log(BODY)
                .build();
    }
}