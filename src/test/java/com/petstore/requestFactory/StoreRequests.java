package com.petstore.requestFactory;

import DataModel.StorePojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StoreRequests
{
    public Response inventoryStatus(){
        return given()
               .when()
               .get(Route.getPetInventories());
    }

    public Response newOrder(StorePojo store) {
        return  given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(store)
                .post(Route.placeAnOrder());
    }

    public Response findPurchaseByID(String orderID){
        return given()
                .when()
                .get(Route.findPurchaseByID(orderID));
    }

    public Response deleteOrder(String orderID){
        return given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .delete(Route.findPurchaseByID(orderID));
    }

}
