package com.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App2 {

	public static void main(String[] args) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		
		MyPojo mypojo = createDummy();
		String jsonString = mapper.writeValueAsString(mypojo);
		
		System.out.println(jsonString);
		
	}

	public static MyPojo createDummy(){
		
		MyPojo myPojo = new MyPojo();
		
		myPojo.setId(2);
		myPojo.setFirstName("Nitesh");
		myPojo.setLastName("Agarwal");
		
		String hobbies[]= {"Cricket","Bowling","Dance"};
		myPojo.setHobbies(hobbies);
		return myPojo;
		
	}
}
