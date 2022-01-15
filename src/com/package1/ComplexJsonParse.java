package com.package1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	@Test
	public static void main() {
		
	JsonPath js=new JsonPath(JsonBodies.coursePrice());
	
	//no of courses
	int size =js.getInt("courses.size()");
	System.out.println(size);
	
	
	//purchase amount
	System.out.println(js.getInt("dashboard.purchaseAmount"));
	
	// Print Title of the first course
	System.out.println(js.getString("courses[0].title"));
	
	//Print All course titles and their respective Prices
	for(int i=0;i<size;i++) {
	String titles=js.getString("courses["+i+"].title");
	int price =js.getInt("courses["+i+"].price");
	
	System.out.println(titles+":"+price);
	}
	
	//Print no of copies sold by RPA Course
	for(int j=0;j<size;j++) {
		String titleGet=js.getString("courses["+j+"].title");
		if(titleGet.equals("RPA")) {
		int copies =js.getInt("courses["+j+"].copies");
		System.out.println(copies);
		break;
		
		}
	}
	//Verify if Sum of all Course prices matches with Purchase Amount
	
	int sum=0;
	for(int k=0;k<size;k++) {
		int copyy=js.getInt("courses["+k+"].copies");
		int price =js.getInt("courses["+k+"].price");
		sum=sum+(price*copyy);
}
	System.out.println(sum);
	Assert.assertEquals(sum, js.getInt("dashboard.purchaseAmount"));
}
}