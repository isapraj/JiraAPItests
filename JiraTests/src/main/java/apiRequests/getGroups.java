package apiRequests;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getGroups {
	
	public Response getGroupsRequest(String url,String username,String password,String gname) {
		RestAssured.baseURI= url;
		Response response = null;
		response = given().auth().preemptive().basic(username, password)
		.relaxedHTTPSValidation()
		.when()
		.get("rest/api/2/group?groupname="+gname).then().assertThat().statusCode(200).extract().response();
   		return response;
	}

}
