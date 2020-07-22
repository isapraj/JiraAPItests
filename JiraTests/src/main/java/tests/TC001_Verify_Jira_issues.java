package tests;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import apiRequests.getIssues;

import bases.baseMethods;
import io.restassured.response.Response;


public class TC001_Verify_Jira_issues extends baseMethods{

	
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
		
	
	
	@Test(dataProvider ="ReadSpacesandSpaceKeyTestData")
	public void getTableCount(String spaceKey,String spaceName) {
		Response response = new getIssues()
				.getIssuesRequest(url, username, password,spaceKey);
		String responseOutput = response.asString();
		JSONObject obj = new JSONObject(responseOutput);
		Assert.assertEquals(obj.getString("key"), spaceKey);
		//Assert.assertEquals(obj.getString("name"), spaceName);
				
	}
	
}
