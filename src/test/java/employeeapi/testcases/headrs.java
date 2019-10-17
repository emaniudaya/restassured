import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class headrs {
    @BeforeClass
    public void basic(){
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
    }

    @Test
    public void test(){
        //specify request object
        RequestSpecification httprequest = RestAssured.given();
        //Response object
        Response httpsresponse = httprequest.request(Method.GET,"Hyderabad");
        String response = httpsresponse.getBody().asString();
        String contentType = httpsresponse.header("Content-Type");
        Assert.assertEquals(contentType, "application/json");
        System.out.println("Content Type is:"+contentType);
        String contentEncoding=httpsresponse.header("Content-Encoding");// capture details of Content-Encoding  header
        System.out.println("Content Encoding is:"+contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");
        Headers header = httpsresponse.headers();
        for(Header head: header){
            System.out.println("Name attribute:  " + head.getName() + "Value of attribute  "+ head.getValue());
        }
        //status code validation
        int statuscode = httpsresponse.getStatusCode();
        System.out.println("status code" + statuscode);
        String statusline = httpsresponse.getStatusLine();
        System.out.println("status line" + statusline);
    }
}
