package DataCreationFromModel;

import com.github.javafaker.Faker;

import DataModel.UserPoJo;

public class UserDataCreater {
	Faker faker = new Faker();
	UserPoJo user = new UserPoJo();
	String username = faker.name().username();
	
	public UserPoJo DataForUserCreation() {
		user.setId(faker.number().randomDigitNotZero());
		user.setUsername(username);
		user.setFirstName(faker.name().firstName());
		user.setLastName(faker.name().lastName());
		user.setEmail(faker.internet().emailAddress());
		user.setPassword(faker.internet().password());
		user.setPhone(faker.phoneNumber().phoneNumber());
		user.setUserStatus(1);
		return user;
		
	}
	
	public UserPoJo DataForEditUser() {
		user.setId(faker.number().randomDigitNotZero());
		user.setUsername(username);
		user.setFirstName(faker.name().firstName());
		user.setLastName(faker.name().lastName());
		user.setEmail(faker.internet().emailAddress());
		user.setPassword(faker.internet().password());
		user.setPhone(faker.phoneNumber().phoneNumber());
		user.setUserStatus(1);
		return user;
		
	}

}
