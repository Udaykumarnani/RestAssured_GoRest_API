package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import org.testng.annotations.Test;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserUserPoints {
	
	static ResourceBundle getURL(){
		
		ResourceBundle rb=ResourceBundle.getBundle("routes");
		return rb;
		
	}
	
	public static Response post_User(User payload) {
		
		String post_Url=getURL().getString("Post_Url");
		String token="Bearer "+"b5531b4e7e7b87cc77f24b9f42d54415e692b4711730aae030eff026f741f7c4";
		
		Response response=given()
		   .header("Authorization",token)
		   .contentType("application/json")
		   .accept("application/json")
		   .body(payload)
		   
		
		.when()
		   .post(post_Url);
		    
		
		return response;
		  
	}
	
   public static Response get_User(int id) {
		
		String get_Url=getURL().getString("Get_Url");
		String token="Bearer "+"b5531b4e7e7b87cc77f24b9f42d54415e692b4711730aae030eff026f741f7c4";
		
		Response response=given()
		   .header("Authorization",token)
		   .pathParam("id", id)
		
		.when()
		   .get(get_Url);
		    
		
		return response;
		  
	}
   
   public static Response update_User(int id,User payload) {
		
		String update_Url=getURL().getString("Update_Url");
		String token="Bearer "+"b5531b4e7e7b87cc77f24b9f42d54415e692b4711730aae030eff026f741f7c4";
		
		Response response=given()
		   .header("Authorization",token)
		   .pathParam("id", id)
		   .body(payload)
		
		.when()
		     .put(update_Url);
		    
		
		return response;
		  
	}
   
   
   public static Response delete_User(int id) {
		
		String delete_Url=getURL().getString("Delete_Url");
		String token="Bearer "+"b5531b4e7e7b87cc77f24b9f42d54415e692b4711730aae030eff026f741f7c4";
		
		Response response=given()
		   .header("Authorization",token)
		   .pathParam("id", id)
		
		.when()
		     .delete(delete_Url);
		    
		
		return response;
		  
	}
   
   
	
	

}
