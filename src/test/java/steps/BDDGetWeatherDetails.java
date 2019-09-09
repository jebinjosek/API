package steps;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class BDDGetWeatherDetails {

	
	public Response response; 
	
	

	
	
	@Test
	public void test()
	{
		
		given()
			.baseUri("http://restapi.demoqa.com/utilities/weatherfull/city")
			.basePath("Hyderabad")
		
		.when()
			.get()
		
		.then()
			.statusCode(200)
			.body("City", equalTo("Hyderabad"))
			.body("Temperature", containsString("Degree celsius"))
			.body("Humidity",containsString("Percent"))
			.body("WindSpeed",containsString("hour"))
			.body("WindDirectionDegree",containsString("Degree"));
		
	}

}
