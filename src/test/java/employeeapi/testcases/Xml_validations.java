import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;

public class Xml_validations {
    @Test(priority = 0)
    public void testMultipleContents(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                .then()
                .body("CUSTOMER.ID",equalTo("15"))
                .body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
                .body("CUSTOMER.LASTNAME",equalTo("Clancy"))
                .body("CUSTOMER.STREET",equalTo("319 Upland Pl."))
                .body("CUSTOMER.CITY",equalTo("Seattle"));
    }

    @Test(priority = 0)
    public void testMultipleContentsAtonce(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                .then()
                .body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"));
    }

    @Test(priority = 0)
    public void testUsingXpath(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                .then()
                .body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")));
    }

    @Test(priority = 1)
    public void testUsingXpath2(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/INVOICE/")
                .then()
                .body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
                .log().all();
    }
}
