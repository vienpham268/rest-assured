/*
* Auther: Shoaib Shaikh
* Class Information: This is a base class which is is extended by all the Test classes.
* */

package com.petstore.tests;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.baseURI;


public class TestBase {
	
    public static Response response;
    ValidatableResponse validatableResponse;
    public static final String ROOT_FOLDER =  System.getProperty("user.dir");
    public static final String UPLOAD_FOLDER = ROOT_FOLDER + "/uploadImage";
	public static final String CAT_IMAGES = "/cuteCat.jpg";

    //public static Faker fake = new Faker();

    public TestBase()
    {
        baseURI = "https://petstore.swagger.io/v2";
      
    }
    
	public void sleepInSecond(int timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	


}
