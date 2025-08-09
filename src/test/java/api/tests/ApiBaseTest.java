package api.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiBaseTest {

    public static final String SEARCH_URI = "https://sort.diginetica.net/search";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://pitergsm.ru";
        RestAssured.basePath = "/local/php_interface/tools";
    }
}