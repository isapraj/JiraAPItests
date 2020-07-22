package tests;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import apiRequests.getIssues;
import apiRequests.getUsername;
import bases.baseMethods;
import io.restassured.response.Response;

public class TC003_Verify_Username extends baseMethods{

	
	@BeforeTest
	public void setFileName(){
		
		if(baseMethods.url.contains("poc")) {
			baseMethods.fileName="./data/NpdTestData.xlsx";
	}
		else if (baseMethods.url.contains("prd"))
		{
			baseMethods.fileName="./data/PrdTestData.xlsx";
		}
		
	}
		
	
	
	@Test(dataProvider ="ReadUserNameTestData")
	public void getTableCount(String uname,String displayName) {
		
		Response response = new getUsername()
				.getUsernameRequest(url, username, password,uname);
		String responseOutput = response.asString();
		System.out.println(response.getStatusCode());
		
		JSONObject obj = new JSONObject(responseOutput);
		Assert.assertEquals(obj.getString("key"), uname);
		Assert.assertEquals(obj.getString("displayName"), displayName);
	
		
		
				
	}
	

}
