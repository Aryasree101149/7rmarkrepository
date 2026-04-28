package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker = new Faker();

	public String generateUsername() {
		return faker.name().username();
	}

	public String generatePassword() {
		return faker.internet().password();
	}
}
