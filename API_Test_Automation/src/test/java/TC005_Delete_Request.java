import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC005_Delete_Request {
	
	@Test
	void deleteUser() {
		
		
		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.DELETE,"/2");
		
		
		//Status code validation and print it
		int statusCode = response.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(statusCode, 204);
		
		
	}
	
	

}
