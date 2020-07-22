package tests;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import apiRequests.getDashboard;
import apiRequests.getUsername;
import bases.baseMethods;
import io.restassured.response.Response;

public class TC004_Verify_Dashboard extends baseMethods{

	
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
		
	
	
	@Test(dataProvider ="ReadDashboardTestData")
	public void getTableCount(String did,String Dname) {
		
		Response response = new getDashboard()
				.getDashboardRequest(url, username, password, did);
		String responseOutput = response.asString();
		System.out.println(response.getStatusCode());
		
		JSONObject obj = new JSONObject(responseOutput);
		Assert.assertEquals(obj.getString("id"), did);
		Assert.assertEquals(obj.getString("name"), Dname);
	
		
		
				
	}
	

}
