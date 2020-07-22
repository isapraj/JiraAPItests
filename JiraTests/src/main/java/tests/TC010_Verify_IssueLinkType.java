package tests;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import apiRequests.getRole;

import bases.baseMethods;
import io.restassured.response.Response;

public class TC010_Verify_IssueLinkType extends baseMethods{

	
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
		
	
	
	@Test(dataProvider ="ReadRoleTestData")
	public void getTableCount(String id,String displayName) {
		
		Response response = new getRole()
				.getRoleRequest(url, username, password, id);
		String responseOutput = response.asString();
		System.out.println(response.getStatusCode());
		
		JSONObject obj = new JSONObject(responseOutput);
		Assert.assertEquals(obj.getString("id"), id);
		Assert.assertEquals(obj.getString("name"), displayName);
	
		
		
				
	}
	

}
