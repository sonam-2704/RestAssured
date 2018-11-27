package com.restassured.basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SimpleGetTest2 {

	
	@Test
	public void getCityDetails(){
	
	Response resp = RestAssured.get("https://www.cleartrip.com/places/airports/search?string=BOM");
	
	int statusCode = resp.getStatusCode();
	
	System.out.println("status code: "+statusCode);
	
	String responseBody = resp.getBody().toString();
	
	//System.out.println("body: "+responseBody);
	System.out.println("body: "+resp.asString());
	
	}
}
