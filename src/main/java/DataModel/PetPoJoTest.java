package DataModel;

import java.util.ArrayList;
import java.util.HashMap;

public class PetPoJoTest {
	private int id;
	private String name;
	private HashMap<String, Object> category;
	private ArrayList<String> photoUrls;
	private String status;
	private HashMap<String, Object> tag;
	private ArrayList<HashMap<String, Object>> tags;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public HashMap<String, Object> getCategory() {
		return category;
	}
	
	public void setCategory(HashMap<String, Object> category) {
		this.category = category;
	}
	
	public ArrayList<String> getPhotoUrls() {
		return photoUrls;
	}
	
	public void setPhotoUrls(ArrayList<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	
	public HashMap<String, Object> getTag() {
		return tag;
	}
	
	public void setTag(HashMap<String, Object> tag) {
		this.tag = tag;
	}
	
	public ArrayList<HashMap<String, Object>> getTags() {
		return tags;
	}
	
	public void setTags(ArrayList<HashMap<String, Object>> tags) {
		this.tags = tags;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
