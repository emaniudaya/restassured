import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class Delete_request {
    @Test(priority = 0)
    public void deleteemprecord(){
        RestAssured.baseURI = "https://reqres.in/api/users";
        RestAssured.basePath = "/delete/2";
        Response response =

        given()
                .when()
                .delete()
                .then()
                .statusCode(204)
                .log().all().extract().response();
    }
}
