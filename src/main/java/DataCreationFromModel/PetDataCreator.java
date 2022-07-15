package DataCreationFromModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import com.github.javafaker.Faker;

import DataModel.PetPoJoTest;

public class PetDataCreator {
	
	PetPoJoTest pet = new PetPoJoTest();
	Faker faker = new Faker(Locale.US);
	
	public PetPoJoTest createPetData() {
		
		HashMap<String, Object> category = new HashMap<>();
		category.put("id", "1");
		category.put("name", "Cats");
		
		ArrayList<String> photoUrl = new ArrayList<>();
		photoUrl.add("cuteCat");
		
		HashMap<String, Object> tag = new HashMap<>();
		tag.put("id", "1");
		tag.put("name", "Big");
		
		ArrayList<HashMap<String, Object>> tags = new ArrayList<>();
		tags.add(tag);
		
		pet.setId(faker.number().numberBetween(1, 10));
		pet.setCategory(category);
		pet.setName(faker.name().firstName());
		pet.setPhotoUrls(photoUrl);
		pet.setTags(tags);
		pet.setStatus("available");
		
		return pet;
		
	}
	
	public PetPoJoTest editPetData(int petID) {
		
		HashMap<String, Object> category = new HashMap<>();
		category.put("id", "1");
		category.put("name", "Cats");
		
		ArrayList<String> photoUrl = new ArrayList<>();
		photoUrl.add("cuteCat");
		
		HashMap<String, Object> tag = new HashMap<>();
		tag.put("id", "1");
		tag.put("name", "Big");
		
		ArrayList<HashMap<String, Object>> tags = new ArrayList<>();
		tags.add(tag);
		
		pet.setId(petID);
		pet.setCategory(category);
		pet.setName("Updated" + faker.name().firstName());
		pet.setPhotoUrls(photoUrl);
		pet.setTags(tags);
		pet.setStatus("available");
		
		return pet;
		
	}
	
	public PetPoJoTest editPetWithForm(int petID) {
		pet.setId(petID);
		pet.setName("Updated Form" + faker.name().firstName());
		pet.setStatus("available");
		return pet;
		
	}
	
	public PetPoJoTest delete(int petID) {
		pet.setId(petID);
		return pet;
		
	}

}
