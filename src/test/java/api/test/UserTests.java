package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserUserPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	
	User payload;
	
	@BeforeClass
	public void setup() {
		
		faker=new Faker();
		payload=new User();
		
		payload.setName(faker.name().fullName());
		payload.setGender("male");
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setStatus("active");
		
	}
	
	@Test(priority=1)
	public void post_User(ITestContext context) {
		
		Response response=UserUserPoints.post_User(payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
		context.setAttribute("id",response.jsonPath().getInt("id"));
	}
	
	@Test(priority=2)
	public void get_User(ITestContext context) {
		
		   int id=(int) context.getAttribute("id");
		   
		   Response response = UserUserPoints.get_User(id);
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void update_user(ITestContext context){
		
		int id=(int) context.getAttribute("id");
		
		payload.setName(faker.name().fullName());
		payload.setGender("female");
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setStatus("inactive");
		
		Response response=UserUserPoints.update_User(id, payload);
		 
		 response.then().log().body();
		 
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		 response=UserUserPoints.get_User(id);
		 
		 response.then().log().body();
		 
		 Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void delete_user(ITestContext context) {
		
		int id=(int) context.getAttribute("id");
		
		Response response=UserUserPoints.delete_User(id);
		
		Assert.assertEquals(response.getStatusCode(), 204);
		
		System.out.println("After deleting User");
		
	}

}
