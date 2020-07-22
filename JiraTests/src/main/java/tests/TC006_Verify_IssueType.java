package tests;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import apiRequests.getIssueType;

import bases.baseMethods;
import io.restassured.response.Response;

public class TC006_Verify_IssueType extends baseMethods{

	
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
		
	
	
	@Test(dataProvider ="ReadIssueTypeTestData")
	public void getTableCount(String tid,String displayName) {
		
		Response response = new getIssueType()
				.getIssueTypeRequest(url, username, password, tid);
		String responseOutput = response.asString();
		System.out.println(response.getStatusCode());
		
		JSONObject obj = new JSONObject(responseOutput);
		Assert.assertEquals(obj.getString("id"), tid);
		Assert.assertEquals(obj.getString("name"), displayName);
	
		
		
				
	}
	

}
