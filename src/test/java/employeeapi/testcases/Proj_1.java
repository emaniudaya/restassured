import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Proj_1 {
    @BeforeClass
    public void basic(){
        RestAssured.baseURI = "http://api.5min.com";
        RestAssured.basePath = "search";
    }

    @Test
    public void test(){
        RequestSpecification httprequest = RestAssured.given();
        Response httpresponse = httprequest.get("/Hyderabad");
        JsonPath jsonpathevaluator = httpresponse.jsonPath();
        System.out.println("City recieved from response  " + jsonpathevaluator.get("City"));
        String city = jsonpathevaluator.get("City");
        Assert.assertEquals(city,"Hyderabad","City name recieved ");
        System.out.println("Temperature recieved from response  " + jsonpathevaluator.get("Temperature"));
        System.out.println("Weather recieved from response  " + jsonpathevaluator.get("WeatherDescription"));
        System.out.println("Humidity recieved from response  " + jsonpathevaluator.get("Humidity"));
        System.out.println("Windspeed recieved from response  " + jsonpathevaluator.get("WindSpeed"));
        System.out.println("Winddirection recieved from response  " + jsonpathevaluator.get("WindDirectionDegree"));
    }
}
