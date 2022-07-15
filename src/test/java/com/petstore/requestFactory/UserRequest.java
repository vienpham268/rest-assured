package com.petstore.requestFactory;

import static io.restassured.RestAssured.given;

import DataModel.UserPoJo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserRequest {
	
	public Response userCreation(UserPoJo user) {
		return given().
				contentType(ContentType.JSON).
				when().
				body(user).
				post(Route.createUser());
	}
	
	public Response getUserByUserName(String userName) {
		return given().
				when().
				get(Route.UserName(userName));
	}
	
	
	public Response editUser(UserPoJo user, String userName) {
		return given().
				contentType(ContentType.JSON).
				when().
				body(user).
				put(Route.UserName(userName));
	}
	
	public Response loginUser(String userName, String password) {
		return given().
				param("username", userName).
				param("password", password).
				when().
				get(Route.login());
	}
	
	public Response logoutUser() {
		return given().
				when().
				get(Route.logout());
	}
	
	public Response deleteUser(String userName) {
		return given().
			   when().
			   delete(Route.UserName(userName));
	}

}
