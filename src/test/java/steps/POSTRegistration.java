package steps;

import org.json.simple.JSONObject;
import org.junit.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class POSTRegistration  {
	
	public Response response;
	
	
	@Given("^I set URI for registration$")
	public void i_set_uri_for_registration() throws Throwable {
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		
	}
	@When("^I register with all required information$")
	public void i_register_with_all_required_information() throws Throwable {
		RequestSpecification request = RestAssured.given();
		
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Jebin");
		requestParams.put("LastName", "Jacob");
		requestParams.put("UserName", "jebinjosekbbb");
		requestParams.put("Password", "Test@1234");
		requestParams.put("Email", "jebinjosekhhfvfvk@gmail.com");	
		
		
		//request.header("Content-Type","application/json");
		request.body(requestParams.toJSONString());
		response = request.post("/register");
		
	}

	@Then("^Verify the response after registration$")
	public void verify_the_response_after_registration() throws Throwable {
	
		
		System.out.println("Response is - "+ response.asString());
		int statusCode= response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	
}
