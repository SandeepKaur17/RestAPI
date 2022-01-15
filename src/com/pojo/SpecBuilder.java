package com.pojo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class SpecBuilder {
	
	public static void main(String[] args) {
		
		List<String> type=new ArrayList<String>();
		type.add("shop"); type.add("shoe park");
		
		Location loc=new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		AddPlace ap=new AddPlace();
		ap.setAccuracy(40);
		ap.setAddress("171,naneola, Ambala");
		ap.setLanguage("Hindi");
		ap.setLocation(loc);
		ap.setName("house");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setTypes(type);
		ap.setWebsite("http://google.com");
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		String response= given().spec(req)
		.body(ap)
		.when().post("/maps/api/place/add/json")
		.then().spec(res).extract().response().asString();
		
		System.out.println(response);
	}

}
