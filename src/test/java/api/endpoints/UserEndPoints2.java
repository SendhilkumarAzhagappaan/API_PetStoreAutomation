package api.endpoints;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.response.Response;

//This class is created to perform CRUD Operations

public class UserEndPoints2 {
	
	//method created for getting URL's from properties file
	static ResourceBundle getURL()
	{
		//Load properties file
		//routes is the property file name
		ResourceBundle routes = ResourceBundle.getBundle("routes"); 	
		return routes;
	}
	
	 public static Response createUser(User requestpayload) {
		
		 String post_url = getURL().getString("post_url");
		 
		 Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(requestpayload)
			
		.when()
			.post(post_url);
		 
		 return response;
		 
	}
	 
	 public static Response readUser(String userName) {
			
		 String get_url = getURL().getString("get_url");
		 
		 Response response = given()
			.pathParam("username", userName)
			
		.when()
			.get(get_url);
		 
		 return response;
		 
	}

	 public static Response updateUser(String userName, User requestpayload) {
			
		 String update_url = getURL().getString("update_url");
		 
		 Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(requestpayload)
			
		.when()
			.put(update_url);
		 
		 return response;
		 
	}
	 
	 public static Response deleteUser(String userName) {
		 
		 String delete_url = getURL().getString("delete_url");
			
		 Response response = given()
			.pathParam("username", userName)
			
		.when()
			.delete(delete_url);
		 
		 return response;
		 
	}
}
