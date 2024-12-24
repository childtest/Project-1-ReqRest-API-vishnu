package in.reqres.userapitest;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

/**
 * Created by Vishnu Ahir
 */
public class GetApiForUser extends TestBase {

    @Test
    public void getAllUsers() {

        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

        //Verify status code is 200
        Assert.assertEquals(response.getStatusCode(), 200);

        //Verify page is 2
        Assert.assertEquals(response.jsonPath().getInt("page"), 2);
        //Verify per page is 6
        Assert.assertEquals(response.jsonPath().getInt("per_page"), 6);
        //Verify data[1].id is 8
        Assert.assertEquals(response.jsonPath().getString("data[1].id"), "8");
        System.out.println(response.jsonPath().getString("data[1].id"));
        //Verify data[3].first_name is Byron
        System.out.println(response.jsonPath().getString("data[3].first_name"));
        Assert.assertEquals(response.jsonPath().getString("data[3].first_name"), "Byron");
        //Verify list of data is 6
        System.out.println(response.jsonPath().getList("data").size());
        Assert.assertEquals(response.jsonPath().getList("data").size(), 6);
        //Verify data[5].avatar URL
        System.out.println(response.jsonPath().getString("data[4].avatar"));
        Assert.assertEquals(response.jsonPath().getString("data[4].avatar"), "https://reqres.in/img/faces/11-image.jpg");
        //Verify support.url is correct
        System.out.println(response.jsonPath().getString("support.url"));
        Assert.assertEquals(response.jsonPath().getString("support.url"), "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral");
        //Verify support.text is correct
        System.out.println(response.jsonPath().getString("support.text"));
        Assert.assertEquals(response.jsonPath().getString("support.text"), "Tired of writing endless social media content? Let Content Caddy generate it for you.");

    }

    @Test
    public void getSingleUser(){

        Response response = given()
                .pathParams("id", 2)
                .when()
                .get("/users/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}