package tests;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import apiRequests.getProjects;
import bases.baseMethods;
import io.restassured.response.Response;

public class TC002_Verify_Projects extends baseMethods{

	
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
		
	
	
	@Test(dataProvider ="ReadProjectsTestData")
	public void getTableCount(String pid,String projectTypeKey) {
		
		Response response = new getProjects()
				.getProjectsRequest(url, username, password, pid);
		String responseOutput = response.asString();
		System.out.println(response.getStatusCode());
		
		JSONObject obj = new JSONObject(responseOutput);
		Assert.assertEquals(obj.getString("key"), pid);
		Assert.assertEquals(obj.getString("projectTypeKey"), projectTypeKey);
	
		
		
				
	}
	

}
