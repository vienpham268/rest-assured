package com.petstore.requestFactory;

import DataModel.PetPoJoTest;
import com.petstore.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;


public class PetRequests{
    public Response getPetByStatus(String status){
        return given()
                .queryParam("status",status)
                .when()
                .get(Route.findPetByStatus());
    }

    public Response petCreation(PetPoJoTest pet){
    	return given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(pet)
                .post(Route.creatAndPutPet());
    }

    public Response petById(int petID){
        return given()
                .when()
                .get(Route.getAndUpdatePetByID(petID));
    }

    public Response updateGivenPet(PetPoJoTest pet){
        return given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(pet)
                .put(Route.creatAndPutPet());
    }
    
    public Response updatePetWithFormData(PetPoJoTest pet, int petID) {
    	return given()
    			.when()
    			.contentType("application/x-www-form-urlencoded")
    			.when()
    			.formParam("id", pet.getId())
    			.formParam("name", pet.getName())
    			.formParam("status", pet.getStatus())
    			.post(Route.getAndUpdatePetByID(petID));
    }
    
    public Response uploadImages(int petID) {
    	return given()
    			.when()
    			.contentType("multipart/form-data")
    			.when()
    			.formParam("id", petID)
    			.formParam("additionalMetadata", "1")
    			.multiPart("file", new File(TestBase.UPLOAD_FOLDER + TestBase.CAT_IMAGES))
    			.post(Route.uploadImages(petID));
    }
    
    public Response delete(PetPoJoTest pet, int petID) {
        return given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(pet)
                .delete(Route.getAndUpdatePetByID(petID));
    }
}
