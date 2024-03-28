package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class userEndpoints {
	
	public static Response createUser(User payload)
	{
		
	Response response =	given()
		     .contentType(ContentType.JSON)
		     .accept(ContentType.JSON)
		     .body(payload)
		.when()
		   .post(Routes.post_url);
		   
		   return response;
	}

	
	public static Response readUser(String username)
	{
		
	Response response =	given()
		     .pathParam("username", username)
		.when()
		   .post(Routes.get_url);
		   
		   return response;
	}
	
	public static Response updateUser(String username, User payload)
	{
		
	Response response =	given()
		     .contentType(ContentType.JSON)
		     .accept(ContentType.JSON)
		     .pathParam("username", username)
		     .body(payload)
		.when()
		   .post(Routes.update_url);
		   
		   return response;
	}
	
	public static Response deleteUser(String username)
	{
		
	Response response =	given()
		     .pathParam("username", username)
		.when()
		   .post(Routes.delete_url);
		   
		   return response;
	}
	
}
