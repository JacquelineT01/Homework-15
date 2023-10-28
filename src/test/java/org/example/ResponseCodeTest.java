package org.example;

import org.apache.http.HttpStatus;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

public class ResponseCodeTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 9, 10})
    public void checkingSuccessResponseCode(int orderId) {

        given()
                .log()
                .all()
                .when()
                .get("http://51.250.6.164:8080/test-orders/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode( HttpStatus.SC_OK);

    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 11, 30,100})
    public void checkingFailureResponseCode(int orderId) {

        given()
                .log()
                .all()
                .when()
                .get("http://51.250.6.164:8080/test-orders/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode( HttpStatus.SC_BAD_REQUEST);

    }
}
