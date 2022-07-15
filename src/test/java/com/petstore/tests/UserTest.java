package com.petstore.tests;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.petstore.requestFactory.UserRequest;

import DataCreationFromModel.UserDataCreater;
import DataModel.UserPoJo;
import io.restassured.response.Response;


public class UserTest extends TestBase {

	public UserDataCreater userDataCreater = new UserDataCreater();
	public UserRequest userRequest = new UserRequest();
	public UserPoJo userPoJo = new UserPoJo();
	public String createdUserName, createdPassword;
	
	@Test
	public void TC_01_createUser() {
		userPoJo = userDataCreater.DataForUserCreation();
		createdUserName = userPoJo.getUsername();
		createdPassword = userPoJo.getPassword();
		Response respose = userRequest.userCreation(userPoJo);
		validatableResponse = respose.then().statusCode(200);
	}
	
	@Test
	public void TC_02_getUserByUserName(){
		sleepInSecond(5);
		userRequest.getUserByUserName(createdUserName);
		Response respose = userRequest.getUserByUserName(createdUserName);
		validatableResponse = respose.then().statusCode(200).body("username", equalTo(createdUserName));
	}
	
	
	@Test
	public void TC_03_editUser() {
		userPoJo = userDataCreater.DataForEditUser();
		Response respose = userRequest.editUser(userPoJo, createdUserName);
		validatableResponse = respose.then().statusCode(200);
	}
	
	@Test
	public void TC_04_login() {
		Response respose = userRequest.loginUser(createdUserName, createdPassword);
		validatableResponse = respose.then().statusCode(200);
	}
	
	@Test
	public void TC_05_logout() {
		Response respose = userRequest.logoutUser();
		validatableResponse = respose.then().statusCode(200).body("message", equalTo("ok"));
	}
	
	@Test
	public void TC_06_deleteUser() {
		Response respose = userRequest.deleteUser(createdUserName);
		validatableResponse = respose.then().statusCode(200).body("message", equalTo(createdUserName));
	}

}
