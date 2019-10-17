import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Proj_2 {
    @BeforeClass
    public void baseurl(){
        //specify base uri

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
    }

    @Test
    public void test1(){
        //specify request object
        RequestSpecification httprequest = RestAssured.given();
        //Response object
        Response httpsresponse = httprequest.request(Method.GET,"Hyderabad");
        String response = httpsresponse.getBody().asString();
        System.out.println("Customer reponse" + response);
        //status code validation
        int statuscode = httpsresponse.getStatusCode();
        System.out.println("status code" + statuscode);
        String statusline = httpsresponse.getStatusLine();
        System.out.println("status line" + statusline);
    }
}
