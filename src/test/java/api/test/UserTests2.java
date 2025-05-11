package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserUserPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTests2 {

	
	User payload;

	Response response;

	@Test(priority=1,dataProvider = "userData", dataProviderClass = DataProviders.class)
	public void post_User(String Name,String Gender,String Email,String Status) {
        payload=new User();
		
		payload.setName(Name);
		payload.setGender(Gender);
		payload.setEmail(Email);
		payload.setStatus(Status);
		
		response=UserUserPoints.post_User(payload);
		response.then().log().all();
		
		//System.out.println(response.jsonPath().getInt("id"));
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
		
	}
	
	
	
	//@Test(priority=4)
	public void delete_user() {
		
	    response=UserUserPoints.delete_User(response.jsonPath().getInt("id"));
		
		Assert.assertEquals(response.getStatusCode(), 204);
		
		System.out.println("After deleting User");
		
	}

}
