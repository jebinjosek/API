package steps;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
 
public class PUTexample {

	@Test(priority=2,description="Creating the List of user")
	public void RegisterUserPOSTAPI()
	{

		String bo=" '   {  '  + \r\n" + 
				" '       \"name\": \"morpheus\",  '  + \r\n" + 
				" '       \"job\": \"leader\"  '  + \r\n" + 
				" '  }  ' ; ";

		RestAssured.baseURI="https://reqres.in";

		String Resp=given().
				body("bo").
				when().
				post("/api/users").
				then().assertThat(). 
				statusCode(201).and().
				contentType(ContentType.JSON).and().
				header("server", "cloudflare").and(). 
				header("content-length", "51").
				extract().
				response().asString();

		System.out.println("Response is\t"+Resp);
	}
	
	@Test(priority=3,description="Update the List of user")
	public void UpdateUserPutRequest()
	{

		String PutBody="{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"zion resident\"\r\n" + 
				"}";
		RestAssured.baseURI="https://reqres.in";

				String Resp=given().
				header("Content-Type","application/json; charset=utf-8").
				body("PutBody").
				when().
				put("/api/users/2").
				then().assertThat(). 
				statusCode(200).and().
				contentType(ContentType.JSON).and().
				header("server", "cloudflare").and(). 
				header("content-length", "40").and().
				body("name[]",equalTo("morpheus")).
				extract().
				response().asString();

		System.out.println("Response is\t"+Resp);
	}
	
}