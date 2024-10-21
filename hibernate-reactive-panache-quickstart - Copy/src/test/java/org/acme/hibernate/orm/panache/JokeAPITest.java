package org.acme.hibernate.orm.panache;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class JokeAPITest {


    @Test
    public void getJokesList() {
        // Perform the GET request and validate the response
        given()
                .when()
                .get("/jokes?count=10")
                .then()
                .statusCode(200)
                .body(notNullValue())
                .body("size()", is(10));
    }
    @Test
    public void getJokesListBadRequest() {
        // Perform the GET request and validate the response
        given()
                .when()
                .get("/jokes?count=-1")
                .then()
                .statusCode(400)
                .body(notNullValue());
              //  .body("size()", is(10));
    }

}
