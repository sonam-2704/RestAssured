package com.restassured.basic;

import io.restassured.RestAssured;

public class SimpleGetTest1 {

	
	public void getCityDetails(){
		
		 String originalText = "test";
		    String expectedMd5CheckSum = "098f6bcd4621d373cade4e832627b4f6";
		    
//		    RestAssured.given().
//        param("text",originalText).
//    when().
//        get("http://md5.jsontest.com").
//    then().
//        assertThat().
//        body("md5",equalTo(expectedMd5CheckSum));
		
		
	}
}
