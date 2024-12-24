package in.reqres.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Vishnu Ahir
 */
public class TestBase {

    @BeforeMethod
    public void inIT(){
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api";
    }

}