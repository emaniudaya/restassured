import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo_Get {
    @Test
    public void getWeatherDetails(){
        given()
                .when()
                .get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
                .then().statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("City",equalTo("Hyderabad")).header("Content-Type","application/json");
    }
}
