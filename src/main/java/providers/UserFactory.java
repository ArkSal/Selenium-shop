package providers;

import com.github.javafaker.Faker;
import models.SocialTitle;
import models.User;

import java.util.Random;

public class UserFactory {
    private static Faker faker = new Faker();

    public static User getUserWithConstantFields() {
        return new User.Builder()
                .title(SocialTitle.Mr)
                .firstName("Arek")
                .lastName("Sale")
                .email("areczek@gmail.com")
                .password("hasloSpecjalne1")
                .builder();
    }

    public static User getRandomUser() {
        return new User.Builder()
                .title(SocialTitle.values()[new Random().nextInt(SocialTitle.values().length)])
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password(true))
                .builder();
    }
}
