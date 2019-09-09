package steps;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GoogleSearch {

	
	@Test
	public void googleMap()
	{
		RestAssured.baseURI="https://www.google.com/maps/search/?api=1";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/nearby+restaurant");
	
		
		//RestAssured.baseURI="https://www.google.com/maps/search/?api=1";
		
		
		// Getting access denied -https://maps.googleapis.com/maps/api/place/nearbysearch/xml?&key=AIzaSyDhWT-bf0vgZnsBuqr85rCGrDNW7YymYv8
			System.out.println("**********************************"+response.getBody().asString());
		
		//Status Code
				int statusCode = response.getStatusCode();
				Assert.assertEquals(200, statusCode);
				System.out.println("Status Code : "+ statusCode);
				
				
		
		
		
	}
}
