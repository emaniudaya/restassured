import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Datadriven_addemployee {
    @Test(dataProvider = "empdataprovider")
    void postEmployee(String eid,String ename, String eusername, String eemail){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httprequest = RestAssured.given();

        //created data to send with post request
        JSONObject data = new JSONObject();
        data.put("id",eid);
        data.put("name",ename);
        data.put("username",eusername);
        data.put("email",eemail);
        data.put("street","police co2lony");
        data.put("suite","Flat. 113/72A");
        data.put("city","Hyderabad");
        data.put("zipcode","500284");
        data.put("lat","-37.3152");
        data.put("lng","81.1491");
        data.put("phone","1-77036-8031 x56442");
        data.put("website","udaya2sreeemani.org");

        //Add aheader stating the request body to json
        httprequest.header("Content-Type","application/json");
        httprequest.body(data.toJSONString());

        //post request
        Response response = httprequest.request(Method.POST,"/users");

        //capture response body to perform validations
        String response_body = response.getBody().asString();
        System.out.println("Respone body is  " +  response_body);

        Assert.assertEquals(response_body.contains(eid),true);
        Assert.assertEquals(response_body.contains(ename),true);
        Assert.assertEquals(response_body.contains(eusername),true);
        Assert.assertEquals(response_body.contains(eemail),true);
        Assert.assertEquals(response_body.contains("police co2lony"),true);
        Assert.assertEquals(response_body.contains("Flat. 113/72A"),true);
        Assert.assertEquals(response_body.contains("Hyderabad"),true);
        Assert.assertEquals(response_body.contains("500284"),true);
        Assert.assertEquals(response_body.contains("-37.3152"),true);
        Assert.assertEquals(response_body.contains("81.1491"),true);
        Assert.assertEquals(response_body.contains("1-77036-8031 x56442"),true);
        Assert.assertEquals(response_body.contains("udaya2sreeemani.org"),true);

        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode,201);




    }

    @DataProvider(name="empdataprovider")
    Object[][] getEmpdata() throws IOException {
        String path = System.getProperty("user.dir")+"src/test/java/empdata.xlsx";
        int row_num = XLUtils.getRowCount(path,"empdata");
;        String empData[][] = {{"11","abc","defg","jnfjerkn@kfnv.com"},{"12","ghi","jklm","jdfnjs@rueru.com"},{"13","opq","rstv","iuyi@qwew.com"}};
        return empData;
    }
}
