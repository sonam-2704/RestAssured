package com.restassured.basic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest {

	@Test
	public void getCityDetails() {

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://www.cleartrip.com";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the
		// method URL.
		// This will return the Response from the server. Store the response in
		// a variable.

		Response response = httpRequest.request(Method.GET, "/places/airports/search?string=pune");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

		int statusCode = response.getStatusCode();

		System.out.println("Status code : " + statusCode);

		JsonPath jsonPathEvaluator = response.jsonPath();

		System.out.println(jsonPathEvaluator.getString("v").toString());

		// JSONObject jsonObject = new JSONObject(responseBody);
		// System.out.println(jsonObject.getString("k"));

		JSONArray jsonArray = new JSONArray(responseBody);
		System.out.println("jsonArray: "+jsonArray);
		
		for(int i=0;i<jsonArray.length();i++){
			
			//System.out.println(jsonArray.get(i));
			
			System.out.println(jsonArray.getJSONObject(i));
			
			JSONObject obj1 = jsonArray.getJSONObject(i);
			
			System.out.println("k: "+obj1.getString("k"));
			System.out.println("v: "+obj1.getString("v"));
			
		}

		// Validate if the specific JSON element is equal to expected value
		Assert.assertTrue(responseBody.contains("Pune"), "Response not validated successfully");

	}

	// @Test
	public void validateHeader() {

		RestAssured.baseURI = "https://www.cleartrip.com";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/places/airports/search?string=pune");

		String header = response.getHeader("content-encoding");

		System.out.println("header: " + header);

		Headers headerList = response.getHeaders();

		for (Header h : headerList) {

			System.out.println(h.getName() + " : " + h.getValue());
		}

		/*
		 * RestAssured.given().get(
		 * "https://www.cleartrip.com/places/airports/search?string=pune").then(
		 * ).assertThat().statusCode(200); RestAssured.given().get(
		 * "https://www.cleartrip.com/places/airports/search?string=pune").then(
		 * ).assertThat().header("content-encoding","gzip");
		 */
	}
}
