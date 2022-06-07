package com.restapiExample.dummy.testbase;



import com.restapiExample.dummy.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;


/**
 * Created by Jay
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init(){
        propertyReader = propertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = propertyReader.getProperty("path");
    }
    }

