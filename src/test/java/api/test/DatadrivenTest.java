package api.test;

import org.testng.Assert;

import org.testng.annotations.Test;

import api.Utilities.DataProviders;
import api.endpoints.userEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class DatadrivenTest {
     
	@Test(priority=1, dataProvider = "Data", dataProviderClass= DataProviders.class)
	public void testPostUser(String UserID, String UserName, String FName, String LName, String Email, String Pwd, String Phone)
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(UserName);
		userPayload.setFirstname(FName);
		userPayload.setLastname(LName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Pwd);
		userPayload.setPhone(Phone);
		
		Response response =userEndpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	@Test(priority=2,dataProvider = "userNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserbyName(String UserName)
	{
		Response response =userEndpoints.deleteUser(UserName);
		
	}
	
}
