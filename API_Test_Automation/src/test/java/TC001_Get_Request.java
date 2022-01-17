import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_Get_Request {
	
	@Test
	void listOfUsers() {
		
		
		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"/2");
		
		//print response in the console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is shown here: "+responseBody);
		
		//Status code validation and print it
		int statusCode = response.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	

}
