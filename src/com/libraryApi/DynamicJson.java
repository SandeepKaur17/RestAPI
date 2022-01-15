package com.libraryApi;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.package1.JsonBodies;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider="getbooks")
	public void addBook(String isbn,String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String addBookResponse=given().header("Content-Type", "application/json")
		.body(JsonBodies.addBookjson(isbn, aisle)).when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().asString();
		
		JsonPath js=new JsonPath(addBookResponse);
		String bookId=js.getString("ID");
		System.out.println(bookId);
		
	}
	
	@DataProvider(name="getbooks")
	public Object [][] getdata() {
		
		Object [][] data =new Object[3][2];
		data[0][0]= "amd";
	    data[0][1]= "564";
	    
	    data[1][0]= "rte";
	     data[1][1]= "908";
	     
	     data[2][0]= "uiy";
	     data[2][1]= "654";
		return data;
	    
	    
	}

}
