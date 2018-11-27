package com.restassured.basic;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class SimpleGetTest3 {

//	@Test
	public void getRequest(){
		
		RestAssured.baseURI = "https://www.cleartrip.com";
		RestAssured.basePath = "/places/airports";
		
		StringWriter requestWriter = new StringWriter();
		PrintStream requestCapture = new PrintStream(new WriterOutputStream(requestWriter));
		
		StringWriter responseWriter = new StringWriter();
		PrintStream responseCapture = new PrintStream(new WriterOutputStream(responseWriter));
		
		RestAssured.given().log().all().when().get("/search?string=pune");
		
		RestAssured.given().filter(new RequestLoggingFilter(requestCapture)).when().get("/search?string=pune");
		
		System.out.println(requestWriter.toString());
		
		RestAssured.given()
		.filter(new RequestLoggingFilter(requestCapture))
		.filter(new ResponseLoggingFilter(responseCapture))
		.when()
		.get("/search?string=pune");
		
		System.out.println("responseWriter : "+responseWriter);
	}
	
	@Test
	public void testRequestLogging(){
		
		RestAssured.baseURI = "https://www.cleartrip.com";
		RestAssured.basePath = "/places/airports";
		
		//Log all request specification details including parameters, headers and body
		RestAssured.given().log().all().when().get("/search?string=pune");
		// Log only the parameters of the request
		RestAssured.given().log().params().when().get("/search?string=pune");
		// Log only the request headers
		RestAssured.given().log().headers().when().get("/search?string=pune");
		// Log only the request body
		RestAssured.given().log().body().when().get("/search?string=pune");
		// Log only the request cookies
		RestAssured.given().log().cookies().when().get("/search?string=pune");
		// Log only the request method
		RestAssured.given().log().method().when().get("/search?string=pune");
		
		
	}
	
	//@Test
	public void testResponseLogging(){
		
		RestAssured.baseURI = "https://www.cleartrip.com";
		RestAssured.basePath = "/places/airports";
		
		//Log all response specification details including parameters, headers and body
		RestAssured.given().when().get("/search?string=pune").then().log().all();
		
		// Log only the response body regardless of the status code
		RestAssured.given().when().get("/search?string=pune").then().log().body();
		
		// Log only the response headers
		RestAssured.given().when().get("/search?string=pune").then().log().headers();
		
		// Log only the response status line
		RestAssured.given().when().get("/search?string=pune").then().log().status();
		
		// Log only the response cookies
		RestAssured.given().when().get("/search?string=pune").then().log().cookies();
		
		
		
	}
}
