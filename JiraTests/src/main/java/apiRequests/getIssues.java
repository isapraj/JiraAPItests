package apiRequests;

import static io.restassured.RestAssured.given;

import bases.baseMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getIssues extends baseMethods {
	
	public Response getIssuesRequest(String url,String username,String password,String id) {
		RestAssured.baseURI= url;
		Response response = null;
		response = given().auth().preemptive().basic(username, password)
		.relaxedHTTPSValidation()
		.when()
		.get("rest/api/latest/issue/"+id).then().assertThat().statusCode(200).extract().response();
   		return response;
	}

}
