package api.endpoints;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.response.Response;

//This class is created to perform CRUD Operations

public class UserEndPoints {
	
	 public static Response createUser(User requestpayload) {
		
		 Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(requestpayload)
			
		.when()
			.post(Routes.post_url);
		 
		 return response;
		 
	}
	 
	 public static Response readUser(String userName) {
			
		 Response response = given()
			.pathParam("username", userName)
			
		.when()
			.get(Routes.get_url);
		 
		 return response;
		 
	}

	 public static Response updateUser(String userName, User requestpayload) {
			
		 Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(requestpayload)
			
		.when()
			.put(Routes.update_url);
		 
		 return response;
		 
	}
	 
	 public static Response deleteUser(String userName) {
			
		 Response response = given()
			.pathParam("username", userName)
			
		.when()
			.delete(Routes.delete_url);
		 
		 return response;
		 
	}
}
