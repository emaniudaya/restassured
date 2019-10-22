import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.mapper.factory.GsonObjectMapperFactory;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.objectMapper;
import static org.hamcrest.Matchers.equalTo;

public class Demo_post {

    public static HashMap<String,String> map = new HashMap<String,String>();

    @BeforeClass
    public void postdata(){
        map.put("FirstName",RestUtils.getFirstName());
        map.put("LastName",RestUtils.getLastName());
        map.put("UserName",RestUtils.getUserName());
        map.put("Password",RestUtils.getPassword());
        map.put("Email",RestUtils.getEmail());
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RestAssured.basePath = "/register";
    }

    @Test
    public void testpost(){
        given()
                .contentType("application/json").body(map)
                .when()
                .post()
                .then().statusCode(201).and()
                .body("SuccessCode",equalTo("OPERATION_SUCCESS")).and()
                .body("Message",equalTo("Operation completed successfully"));
    }
}
