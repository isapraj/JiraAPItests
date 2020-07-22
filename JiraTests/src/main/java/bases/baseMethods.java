package bases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import utils.ReadProjectsTestData;
import utils.ReadSpacesandSpaceKey;
import utils.ReadUsernameTestData;
import utils.ReadDashboardTestData;
import utils.ReadGroupsTestData;
import utils.ReadIssueTypeTestData;
import utils.ReadAttachTestData;
import utils.ReadRoleTestData;


public class baseMethods {
	public  static String  fileName;
	
	public static String url,username,password,node_total,Health,Phase,Version;
	@BeforeSuite
	public void getConfigData() throws IOException
	{
		Properties configData = new Properties();
		FileInputStream in = new FileInputStream( "./src/main/resources/config.properties");
		configData.load(in);
	    url = configData.getProperty("url");
	    username = configData.getProperty("username");
	    password = configData.getProperty("password");
	    node_total =configData.getProperty("node_total");
	    Health =configData.getProperty("Health");
	    Phase =configData.getProperty("Phase");
	    Version =configData.getProperty("Version");
	 	
	}

	
	@DataProvider(name="ReadSpacesandSpaceKeyTestData")	
	public String[][] sendSpaceData() throws IOException
	{
		return ReadSpacesandSpaceKey.readSpacesandSpaceKey(fileName);
	}
	
	@DataProvider(name="ReadUserNameTestData")	
	public String[][] sendProjectData() throws IOException
	{
		return ReadUsernameTestData.readUsername(fileName);
	}

	@DataProvider(name="ReadProjectsTestData")	
	public String[][] sendProjectsData() throws IOException
	{
		return ReadProjectsTestData.readProjects(fileName);
	}

	@DataProvider(name="ReadDashboardTestData")	
	public String[][] sendDashboardData() throws IOException
	{
		return ReadDashboardTestData.readDashboard(fileName);
	}
	
	@DataProvider(name="ReadGroupsTestData")	
	public String[][] sendGroupsData() throws IOException
	{
		return ReadGroupsTestData.readGroups(fileName);
	}
	
	@DataProvider(name="ReadIssueTypeTestData")	
	public String[][] sendIssueTypeData() throws IOException
	{
		return ReadIssueTypeTestData.readIssueType(fileName);
	}

	@DataProvider(name="ReadAttachTestData")	
	public String[][] sendAttachData() throws IOException
	{
		return ReadAttachTestData.readAttach(fileName);
	}
	
	@DataProvider(name="ReadRoleTestData")	
	public String[][] sendRoleData() throws IOException
	{
		return ReadRoleTestData.readRole(fileName);
	}

	
}
