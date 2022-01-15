package com.pojo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class SerializeTest {
	
	public static void main(String[] args) {
		
		List<String> type=new ArrayList<String>();
		type.add("shop"); type.add("shoe park");
		
		Location loc=new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		AddPlace ap=new AddPlace();
		ap.setAccuracy(40);
		ap.setAddress("29, side layout, cohen 09");
		ap.setLanguage("English");
		ap.setLocation(loc);
		ap.setName("Frontline house");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setTypes(type);
		ap.setWebsite("http://google.com");
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String	 response=given().log().all().queryParam("key", "qaclick123")
		.body(ap)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
	}

}
