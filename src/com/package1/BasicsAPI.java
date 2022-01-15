package com.package1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicsAPI {

	
	@Test
	public static void main1() {
		// TODO Auto-generated method stub

		//given-all input details
		//when-submit the api
		//then-validate the response
		
		//Add place;
		BasicsAPI basicsAPI=new BasicsAPI();
		basicsAPI.addPlace("silver oak,210");
		
		
	}	
		
		public void addPlace(String updatedPlace) {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response=given().queryParam("key" , "qaclick123").header("Content-Type", "application/json")
		.body(JsonBodies.getAddPlaceJson()).when().post("/maps/api/place/add/json")
		.then().statusCode(200).body("scope", equalTo("APP")).extract().asString();
		//.headers(DEFAULT_BODY_ROOT_PATH, args, args);
		
		//System.out.println(response);
		
		JsonPath js=new JsonPath(response);//parsing json
	String placeId=js.getString("place_id");
	System.out.println(placeId);
		//0dce92b38d30c3811e7c11e5baafe716
		//4e3f21dac40eccb073edeeba1067dc4f
	
			
	given().queryParam("key" , "qaclick123").header("Content-Type", "application/json")
			.body(JsonBodies.getUpdatePlaceJson(placeId,updatedPlace)).when().put("/maps/api/place/update/json")
			.then().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
			//aedb73f01094c3cfe8739b094f82af63
		
		
		//get place
	String responseget=given().queryParam("key" , "qaclick123")
		.queryParam("place_id",placeId).when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().asString();
		//body("address", equalTo(updatedPlace));
		
		JsonPath js1=new JsonPath(responseget);//parsing json
		String updatedAddress=js1.getString("address");
		System.out.println(updatedAddress);
		
		Assert.assertEquals(updatedAddress, updatedPlace);
}
}