package com.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App1 {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		
		MyPojo myPojo = mapper.readValue(new File("simpleSample.json"), MyPojo.class);
		
		System.out.println(myPojo.getFirstName());
		System.out.println(myPojo.getLastName());
		System.out.println(myPojo.getId());
		System.out.println(myPojo.getHobbies()[0]);
		
	}

}
