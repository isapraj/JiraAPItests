package apiRequests;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getProjects {
	
	public Response getProjectsRequest(String url,String username,String password,String pid) {
		RestAssured.baseURI= url;
		Response response = null;
		response = given().auth().preemptive().basic(username, password)
		.relaxedHTTPSValidation()
		.when()
		.get("rest/api/2/project/"+pid).then().assertThat().statusCode(200).extract().response();
   		return response;
	}

}
