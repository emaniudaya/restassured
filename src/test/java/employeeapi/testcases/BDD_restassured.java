import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class BDD_restassured {
    @Test
    public void testStatusCode(){
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/10")
                .then()
                .statusCode(200).log().all();
    }

    @Test(priority = 0)
    public void testSingleContent(){
        given().when()
                .get("https://jsonplaceholder.typicode.com/users/10")
                .then()
                .statusCode(200)
                .body("x.address.street",equalTo("Kattie Turnpike"));
    }

    @Test(priority = 0)
    public void testMultipleContent(){
        given().when()
                .get("http://restapi.demoqa.com/utilities/weather/city")
                .then()
                .statusCode(200)
                .body("x.address.street",hasItems("Kattie Turnpike"));
    }

    @Test(priority = 1)
    public void testParameterHeaders(){
        given().param("name","uday").header("Myheader","iweujf")
                .when()
                .get("http://restapi.demoqa.com/utilities/weather/city")
                .then()
                .statusCode(200)
                .log().all();
    }
}
