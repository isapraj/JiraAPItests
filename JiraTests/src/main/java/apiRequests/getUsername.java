package apiRequests;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getUsername {
	
	public Response getUsernameRequest(String url,String username,String password,String uname) {
		RestAssured.baseURI= url;
		Response response = null;
		response = given().auth().preemptive().basic(username, password)
		.relaxedHTTPSValidation()
		.when()
		.get("rest/api/2/user?username="+uname).then().assertThat().statusCode(200).extract().response();
   		return response;
	}

}
