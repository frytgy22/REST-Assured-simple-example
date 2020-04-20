package org.lebedeva;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Tester {
    @Test
    void test_01() {

        baseURI = "https://reqres.in/api/";

        given()
                //.header("Content-Type","application/json")

                .get("/users")
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7))
                .body("data.first_name", hasItems("Michael", "Lindsay"))
                .log().all();
    }

    @Test
    void test_02() {

        baseURI = "https://reqres.in/api/";

        given()
                //.header("Content-Type","application/json")
                .param("email", "emma.wong@reqres.in")
                .get("/users")
                .then()
                .statusCode(200)
                .body("data.id[2]", equalTo(3))
                .body("data.first_name", hasItems("Emma"))
                .log().all();
    }
}
