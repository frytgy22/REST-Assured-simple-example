package org.lebedeva;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TestGet {
    @Test
    void test_01() {
        Response response = get("https://reqres.in/api/users?page=2");
//        System.out.println(response.getBody());
//        System.out.println(response.asString());
//        System.out.println(response.getContentType());
//        System.out.println(response.getStatusCode());
        int status = response.getStatusCode();
        Assert.assertEquals(status, 200);
    }

    @Test
    void test_02() {
        given()
                //.header("Content-Type","application/json")

                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7))
                .body("data.first_name",hasItems("Michael","Lindsay"))
                .log().all();
    }
}
