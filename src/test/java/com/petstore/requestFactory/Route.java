package com.petstore.requestFactory;

public class Route {
	
	private static final String USER = "/user";
	private static final String STORE = "/store";
	private static final String ORDER = "/order";
	private static final String PET = "/pet";
    
    public static String createUser() {
    	return USER;
    }
    
    public static String UserName(String userName) {
    	return USER +  "/" + userName;
    }
    
    public static String login() {
    	return USER + "/login";    }
    
    public static String logout() {
    	return USER + "/logout";
    }
    
    public static String placeAnOrder() {
    	return STORE + ORDER;
    }
    
    public static String findPurchaseByID(String orderID) {
    	return STORE + ORDER + "/" + orderID;
    }
    
    public static String getPetInventories() {
    	return STORE + "/inventory";
    }
    
    public static String creatAndPutPet() {
    	return PET;
    }
    
    public static String getAndUpdatePetByID(int petID) {
    	return PET + "/" + petID;
    }
    
    public static String findPetByStatus() {
    	return PET + "/findByStatus";
    }
    
    public static String uploadImages(int petID) {
    	return PET + "/" + petID + "/uploadImage";
    }


    
}
