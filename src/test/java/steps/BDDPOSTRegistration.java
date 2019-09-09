package steps;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;

import static org.hamcrest.Matchers.*;
import org.hamcrest.core.IsEqual;


public class BDDPOSTRegistration  {
	
	public Response response;
	public JSONObject requestParams ;
	
	@BeforeClass
	public void data()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
		
		requestParams= new JSONObject();
		requestParams.put("FirstName", "Jebin");
		requestParams.put("LastName", "Jacob");
		requestParams.put("UserName", "jebinjosekbbb");
		requestParams.put("Password", "Test@1234");
		requestParams.put("Email", "jebinjosekhhfvfvk@gmail.com");
		
	}
	
	
	
	@Test
	public void testPostdata()
	{
		
		given()
			.body(requestParams.toJSONString())
		.when()
			.post()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
		//	.body("SuccessCode",equalTo("OPERATION_SUCCESS"))
			.extract().response().asString();
	}
	
		
}
