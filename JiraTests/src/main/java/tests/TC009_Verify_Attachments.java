package tests;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import apiRequests.getAttach;

import bases.baseMethods;
import io.restassured.response.Response;

public class TC009_Verify_Attachments extends baseMethods{

	
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
		
	
	
	@Test(dataProvider ="ReadAttachTestData")
	public void getTableCount(String id,String displayName) {
		
		Response response = new getAttach()
				.getAttachRequest(url, username, password, id);
		String responseOutput = response.asString();
		System.out.println(response.getStatusCode());
		
		JSONObject obj = new JSONObject(responseOutput);
		//Assert.assertEquals(obj.getString("name"), gname);
		Assert.assertEquals(obj.getString("filename"), displayName);
	
		
		
				
	}
	

}
