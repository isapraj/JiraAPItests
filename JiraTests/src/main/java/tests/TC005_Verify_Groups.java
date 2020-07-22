package tests;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import apiRequests.getGroups;

import bases.baseMethods;
import io.restassured.response.Response;

public class TC005_Verify_Groups extends baseMethods{

	
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
		
	
	
	@Test(dataProvider ="ReadGroupsTestData")
	public void getTableCount(String gname,String displayName) {
		
		Response response = new getGroups()
				.getGroupsRequest(url, username, password, gname);
		String responseOutput = response.asString();
		System.out.println(response.getStatusCode());
		
		JSONObject obj = new JSONObject(responseOutput);
		Assert.assertEquals(obj.getString("name"), gname);
		Assert.assertEquals(obj.getString("expand"), displayName);
	
		
		
				
	}
	

}
