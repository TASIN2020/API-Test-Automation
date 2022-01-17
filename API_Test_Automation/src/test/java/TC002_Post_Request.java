import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_Post_Request {
	
	@Test
	void createNewUser() {
		
		
		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request payload for Post request
		JSONObject requestParam = new JSONObject();
		requestParam.put("name", "morpheus");
		requestParam.put("job", "leader");
		
		httpRequest.header("Content-Type" , "application/json");
		httpRequest.body(requestParam.toJSONString());
		
		
		//Response object
		Response response = httpRequest.request(Method.POST,"/users");
		
		//print response in the console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is shown here: "+responseBody);
		
		//Status code validation and print it
		int statusCode = response.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(statusCode, 201);
			
	}
	
	

}

