package com.petstore.tests;

import DataCreationFromModel.PetDataCreator;
import DataModel.PetPoJoTest;
import com.jayway.jsonpath.JsonPath;
import com.petstore.requestFactory.PetRequests;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class PetTest extends TestBase
{
    public static PetPoJoTest pet = new PetPoJoTest();
    public static PetRequests petRequest = new PetRequests();
    public static int createdPetID;
    public static String createdPetIDString;

    public static PetDataCreator petDataCreator = new PetDataCreator();

    @Test
    public void TC_01_getPetsByStatus() {
        response = petRequest.getPetByStatus("available");
        validatableResponse =
                response
                .then()
                .statusCode(200);
    }

    @Test
    public void TC_02_createPet() {
        response = petRequest.petCreation(petDataCreator.createPetData());

        validatableResponse =
                response
                .then()
                .statusCode(200);

        String responseString = response.asString();

       createdPetID = JsonPath.read(responseString,"$.id");
      
    }

    @Test
    public void TC_03_findPetByID() {
    	sleepInSecond(5);
        response = petRequest.petById(createdPetID);

        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200);
    }

    @Test
    public void TC_04_updateExistingPet() {
        response = petRequest.updateGivenPet(petDataCreator.editPetData(createdPetID));

        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200);
    }
    
    @Test
    public void TC_05_updateExistingPetWithFormData(){
    	response = petRequest.updatePetWithFormData(petDataCreator.editPetWithForm(createdPetID), createdPetID);
    	
    	response.prettyPrint();
    	
    	validatableResponse =
    			response
    			.then()
    			.statusCode(200);
    	
    }

    @Test
    public void TC_06_uploadImage() {
    	response = petRequest.uploadImages(createdPetID);
    	
    	response.prettyPrint();
    	
    	validatableResponse =
    			response
    			.then()
    			.statusCode(200)
    			.body("message", containsString(TestBase.CAT_IMAGES));
    	
    }
    @Test
    public void TC_07_delete() {
        response = petRequest.delete(petDataCreator.delete(createdPetID), createdPetID);
        System.out.println(response.getStatusLine());
        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200)
                .body("message", equalTo(String.valueOf(createdPetID)));

    }
}
