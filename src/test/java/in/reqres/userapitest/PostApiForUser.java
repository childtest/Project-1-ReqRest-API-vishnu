package in.reqres.userapitest;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostApiForUser extends TestBase {

    @Test
    public void createNewUser() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName("new user");
        userPojo.setJob("new job");

        Response response = given()
                .header("Content-Type","application/json")
                .body(userPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void loginSuccessful(){

        UserPojo userPojo = new UserPojo();
        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword("cityslicka");

        Response response = given().log().all()
                .header("Content-Type","application/json")
                .body(userPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
