import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Post_Get {
    public int id;
    Response response;
    JsonPath jpath;
    RequestSpecification httprequest;

    @Test
    public void addemployee(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        httprequest = RestAssured.given();
        JSONObject data = new JSONObject();
        data.put("name","abc1");
        data.put("salary","9991");
        data.put("age","1002");

        httprequest.header("Content-Type","application/xml");
        System.out.println(data.toJSONString());
        httprequest.body(data.toJSONString());
        response = httprequest.request(Method.POST,"/posts");

        String response_body = response.getBody().asString();
        System.out.println("Response body is  " + response_body);
        String status_line = response.getStatusLine();
        System.out.println("Status line is  " + status_line);
        int status_code = response.getStatusCode();
        System.out.println("Status code is  " + status_code);
        jpath = response.jsonPath();
        id = jpath.get("id");
        System.out.println("Created EmpId is  " + id);
    }

    @Test
    public void getcreatedempdata(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        httprequest = RestAssured.given();

        httprequest.header("Content-Type","application/xml");

        response = httprequest.request(Method.GET,"/posts/"+id);

        String get_response = response.getBody().asString();

        System.out.println("Response body is  " + get_response);
        String get_status_line = response.getStatusLine();
        System.out.println("Status line is  " + get_status_line);
        int get_status_code = response.getStatusCode();
        System.out.println("Status code is  " + get_status_code);
    }
}
