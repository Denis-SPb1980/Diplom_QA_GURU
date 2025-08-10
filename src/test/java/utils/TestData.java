package utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class TestData {
    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String login = faker.name().username();
    public String email = faker.internet().emailAddress();
    public String password = generatePassword();



    private String generatePassword() {
        Faker faker = new Faker();
        String letters = faker.letterify("????");
        String numbers = faker.numerify("##");
        String specialChars = RandomStringUtils.random(2, "!@#$%^&*");

        String password = letters + numbers + specialChars;

        return RandomStringUtils.random(password.length(), password.toCharArray());
    }

}