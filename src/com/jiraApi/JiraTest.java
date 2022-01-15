package com.jiraApi;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="http://localhost:8080/";
		
		SessionFilter session=new SessionFilter();
	String sessId=given().header("content-type","application/json").body("{ \"username\": \"sandeepkauranttal01\", \"password\": \"m@h@dev#786\" }")
		.filter(session).when().post("/rest/auth/1/session")
		.then().log().all().extract().response().asString();
	
	
	//create issue in jira
		
	/*	given().header("content-type","application/json")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"RA\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Credit Cared issue\",\r\n"
				+ "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}").filter(session).when().post("/rest/api/2/issue")
						.then().log().all();*/
		
		/*add comment to already existing jira issue
		given().header("content-type","application/json").pathParam("key", "RA-2")
		.body("{\r\n"
				+ "    \"body\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eget venenatis elit. Duis eu justo eget augue iaculis fermentum. Sed semper quam laoreet nisi egestas at posuere augue semper.\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/{key}/comment")
						.then().log().all();*/
		
		
		
		/*add attachment to the issue
		given().header("Atlassian-Token","no-check").filter(session).pathParam("key", "RA-2")
		.header("Content-Type","multipart/form-data")
		.multiPart("file",new File("practice.txt"))
		.when().post("/rest/api/2/issue/{key}/attachments")
						.then().log().all().assertThat().statusCode(200);*/
	
	
	//get issue
	given().filter(session).pathParam("key", "RA-2").queryParam("fields", "comment")
	.when().get("/rest/api/2/issue/{key}")
					.then().log().all().statusCode(200);
	
	
	}

}
