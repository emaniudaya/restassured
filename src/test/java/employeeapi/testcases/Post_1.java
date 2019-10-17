import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Post_1 {
    @BeforeClass
    public void baseurl(){
        //specify base uri
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
    }

    @Test
    public void test1(){
        //specify request object
        RequestSpecification httprequest = RestAssured.given();
        JSONObject requestparams = new JSONObject();
        requestparams.put("FirstName","uday0");
        requestparams.put("LastName","eman0");
        requestparams.put("UserName","udayema0");
        requestparams.put("Password","emaniud0");
        requestparams.put("Email","udayem0@gmail.com");

        httprequest.header("Content-Type","application/json");

        httprequest.body(requestparams.toJSONString());

        //Response object
        Response httpsresponse = httprequest.request(Method.POST,"/register");

        String response = httpsresponse.getBody().asString();
        System.out.println("Customer reponse" + response);
        //status code validation
        int statuscode = httpsresponse.getStatusCode();
        System.out.println("status code" + statuscode);
        String statusline = httpsresponse.getStatusLine();
        System.out.println("status line" + statusline);
    }
}

