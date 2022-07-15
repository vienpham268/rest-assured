package com.petstore.tests;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.petstore.requestFactory.StoreRequests;

import DataCreationFromModel.StoreDataCreator;
import io.restassured.response.Response;

public class StoreTest extends TestBase {

	public static StoreRequests storeRequests = new StoreRequests();
	public static StoreDataCreator storeDataCreator = new StoreDataCreator();
	public String createdOrderID;

	@Test
	public void TC_01_getInventoryStatus() {
		response = storeRequests.inventoryStatus();
		response.prettyPrint();
		validatableResponse = response.then().statusCode(200);
	}

	@Test
	public void TC_02_placeAnOrder() {
		response = storeRequests.newOrder(storeDataCreator.newOrderData());
		response.prettyPrint();
		validatableResponse = response.then().statusCode(200);
		String responseString = response.asString();
		createdOrderID = JsonPath.read(responseString, "$.id").toString();

	}

	@Test
	public void TC_03_getOrderByID() {
		Response response = storeRequests.findPurchaseByID(createdOrderID);
		response.prettyPrint();
		validatableResponse = response.then().statusCode(200);
	}

	@Test
	public void TC_04_deleteTheCreatedOrder() {
		System.out.println(createdOrderID);
		response = storeRequests.deleteOrder(createdOrderID);
		response.prettyPrint();
		validatableResponse = response.then().statusCode(200);
	}
}
