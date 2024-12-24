package in.reqres.userapitest;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteApiForUser extends TestBase {

    @Test
    public void deleteUser() {
        Response response = given().log().all()
                .pathParams("id", 2)
                .when()
                .delete("/users/{id}");
        response.then().statusCode(204);
        response.prettyPrint();

    }
}
