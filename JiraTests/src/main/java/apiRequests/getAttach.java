package apiRequests;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getAttach {
	
	public Response getAttachRequest(String url,String username,String password,String id) {
		RestAssured.baseURI= url;
		Response response = null;
		response = given().auth().preemptive().basic(username, password)
		.relaxedHTTPSValidation()
		.when()
		.get("rest/api/2/attachment/"+id).then().assertThat().statusCode(200).extract().response();
   		return response;
	}

}
