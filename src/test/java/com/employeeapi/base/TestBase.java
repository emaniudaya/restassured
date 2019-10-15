package com.employeeapi.base;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public static RequestSpecification httpRequest;
    public static Response response;
    public String empid="212307";

    public Logger logger;

    @BeforeClass
    public void setup() throws IOException {
        logger = Logger.getLogger("rest_framework");
        PropertyConfigurator.configure("D://rest_framework/test-output/log4j.properties");
        logger.setLevel(Level.DEBUG);
    }
}
