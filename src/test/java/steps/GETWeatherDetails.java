package steps;

import java.util.List;

import org.junit.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GETWeatherDetails {

	
	public Response response; 
	
	
	@Given("^I set URI to get weather info$")
	public void i_set_uri_to_get_weather_info() throws Throwable {
		
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weatherfull/city";
		
		
	}

	
	@When("^I submit a request with city \"([^\"]*)\"$")
	public void i_submit_a_request_with_city(String city) throws Throwable {
		RequestSpecification httpRequest = RestAssured.given();
		response = httpRequest.get("/"+city);
		
	}

	
	@Then("^Verify the weather response$")
	public void verify_the_response() throws Throwable {
		
		String responseBody=response.getBody().asString();
		System.out.println("Response -- "+responseBody);
		
		//Status Code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		
		//Status Line
		String statusLine = response.getStatusLine();
		System.out.println("*StatusLine"+statusLine);
		
		
		//Individual header validation
		System.out.println("*********INDIVIDUAL HEADER*********");
		String headerContentType = response.getHeader("Content-Type");
		System.out.println("*ContentType - "+headerContentType);
		
		//All headers access/verify
		System.out.println("*********RESPONSE HEADERS*********");
		
		Headers allHeaders = response.getHeaders();
		for(Header header : allHeaders)
		{
			System.out.println("Header , "+header.getName()+":"+header.getValue());
		}
		
		
		System.out.println("*********RESPONSE BODY - INDIVIDUAL*********");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String city = jsonPathEvaluator.get("City");
		System.out.println(jsonPathEvaluator.get("City"));
		Assert.assertEquals("Hyderabad", city);
	
	}

}
