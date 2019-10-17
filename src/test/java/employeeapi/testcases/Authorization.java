import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Authorization {
    @BeforeClass
    public void basic(){
        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
    }

    @Test
    public void test() {

        PreemptiveBasicAuthScheme authorscheme = new PreemptiveBasicAuthScheme();
        authorscheme.setUserName("udayemani");
        authorscheme.setPassword("udayemani");
        RestAssured.authentication = authorscheme;

        RequestSpecification httprequest = RestAssured.given();



        //Response object
        Response httpsresponse = httprequest.request(Method.GET,"/");
        String response = httpsresponse.getBody().asString();
        System.out.println("Customer reponse" + response);
        //status code validation
        int statuscode = httpsresponse.getStatusCode();
        System.out.println("status code" + statuscode);
        String statusline = httpsresponse.getStatusLine();
        System.out.println("status line" + statusline);


    }
}
