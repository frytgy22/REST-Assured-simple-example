package org.lebedeva;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class TestPost {
    @Test
    void test_1() {
        JSONObject request = new JSONObject();

        request.put("name", "Raghav");
        request.put("job", "teacher");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }

    @Test
    void test_2() {
        JSONObject request = new JSONObject();

        request.put("name", "Raghav");
        request.put("job", "teacher");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void test_3() {
        JSONObject request = new JSONObject();

        request.put("name", "Raghav");
        request.put("job", "teacher");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void test_4() {
        when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }
}
