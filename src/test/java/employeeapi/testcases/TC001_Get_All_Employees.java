package employeeapi.testcases;

import com.employeeapi.base.TestBase;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import com.sun.xml.xsom.impl.scd.Iterators;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Set;

public class TC001_Get_All_Employees extends TestBase {

    @BeforeClass
    void getAllEmployees() throws InterruptedException {
        logger.info("**********   Get All Employees    **********");
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET,"/employees");
        Thread.sleep(3000);
    }

    @Test
    void checkResponseBody(){
        logger.info("*******    Checking Response Body   *******");
        String responsebody = response.getBody().asString();
        logger.info("Response Body   -->  " + responsebody);
        Assert.assertTrue(responsebody!=null);
    }

    @Test
    void checkStatusCode(){
        logger.info("*******    Checking Status Code   *******");
        int statuscode = response.getStatusCode();
        logger.info("Status Code is  -->  " + statuscode);
        Assert.assertEquals(statuscode,200);
    }

    @Test
    void checkResponseTime(){
        logger.info("*******    Checking Response Time   *******");
        long responsetime = response.getTime();
        logger.info("Response Time is  -->  " + responsetime);
        if (responsetime>2000)
            logger.warn("Response Time is greater than 2000");
        Assert.assertTrue(responsetime<2000);
    }

    @Test
    void checkStatusLine(){
        logger.info("*******    Checking Status Line   *******");
        String statusline = response.getStatusLine();
        logger.info("Status Line is  -->  " + statusline);
        Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
    }

    @Test
    void checkContentType(){
        logger.info("*******    Checking Content Type   *******");
        String contenttype = response.header("Content-Type");
        logger.info("Content Type is  -->  " + contenttype);
        Assert.assertEquals(contenttype, "text/html; charset=UTF-8");
    }

    @Test
    void checkServerType(){
        logger.info("*******    Checking Server Type   *******");
        String servertype = response.header("Server");
        logger.info("Server Type is  -->  " + servertype);
        Assert.assertEquals(servertype, "Apache");
    }

    @Test
    void checkEncoding(){
        logger.info("*******    Checking Encoding   *******");
        String contentencoding = response.header("Content-Encoding");
        logger.info("Content Encoding is  -->  " + contentencoding);
        Assert.assertEquals(contentencoding, null);
    }

    @Test
    void checkContentLength(){
        logger.info("*******    Checking Content Length   *******");
        String contentlength = response.header("Content-Length");
        System.out.println("content length    " +contentlength);
        logger.info("Content Length is  -->  " + contentlength);
        if (Integer.parseInt(contentlength)<100)
            logger.warn("Content Length is less than 100");
       // Assert.assertTrue(Integer.parseInt(contentlength)>100);
    }

    @Test
    void checkCookies(){
        logger.info("*******    Checking Cookies   *******");
        Map<String, String> Checkcookies = response.getCookies();
//        System.out.println(Checkcookies.entrySet().iterator().next().getKey());
//        System.out.println(Checkcookies.entrySet().iterator().next().getValue());
////        for(Cookie allcookies : Checkcookies){
//            System.out.println("Cookie key and values :  " + allcookies.getName() + allcookies.getValue());

//        }
        for(Map.Entry<String,String>allcookies:Checkcookies.entrySet()){
            System.out.println("Cookie key and values :  " + allcookies.getKey() + allcookies.getValue());

        }


    }

    @AfterClass
    void tearDown(){
        logger.info("*******    Completed_TC001_Get_All_Employees   *******");
    }

}
