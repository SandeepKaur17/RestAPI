package com.oAuth2;

import org.openqa.selenium.By;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pojo.WebAutomation;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class OAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

       /* System.setProperty("webdriver.chrome.driver", "C:\\Users\\sande\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       
        driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
	   
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sandeepkauranttal01@gmail.com");*/
		
		
	String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWgZch7g-bx4i02WHEh2UqhpzpifktQ1cyjYwPCZkrmlqQ19X6RkhaYB7hBuxEVAIQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
	
	String partialcode=url.split("code=")[1];

	String code=partialcode.split("&scope")[0];

	System.out.println(code);

	String response =

	                given() 

	                .urlEncodingEnabled(false)

	                       .queryParams("code",code)

	            	        .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

	                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

	                        .queryParams("grant_type", "authorization_code")

	                        .queryParams("state", "verifyfjdss")

	                        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")

	                     // .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")

	                         .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

	                        .when().log().all()

	                        .post("https://www.googleapis.com/oauth2/v4/token").asString();

	 System.out.println(response);

	JsonPath jsonPath = new JsonPath(response);

	    String accessToken = jsonPath.getString("access_token");

	    System.out.println(accessToken);

	com.pojo.GetCourses r2=    given().contentType("application/json").

	queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)

	.when()

	           .get("https://rahulshettyacademy.com/getCourse.php")

	.as(com.pojo.GetCourses.class);
	
	List<WebAutomation> WA=r2.getCourses().getWebAutomation();
	
	for(int i=0;i<WA.size();i++) {
		
		System.out.println(r2.getCourses().getWebAutomation().get(i).getCourseTitle());
		
		
	}

	/*System.out.println(r2.getInstructor());
	System.out.println(r2.getlinkedIn());
	System.out.println(r2.getCourses().getWebAutomation().get(0).getCourseTitle());
	System.out.println(r2.getCourses().getApi().get(0).getCourseTitle());*/
	



	}

}
