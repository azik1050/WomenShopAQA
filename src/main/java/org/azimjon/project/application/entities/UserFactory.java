package org.azimjon.project.application.entities;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import org.azimjon.project.core.utils.enums.Month;
import org.azimjon.project.core.utils.enums.Title;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class UserFactory {
    private static final Faker faker = new Faker();
    private static List<User> users = new ArrayList<>();

    public static User createRandomUser() {
        return new User.UserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.animal().name())
                .dayOfBirth(Integer.toString(faker.number().numberBetween(1, 28)))
                .monthOfBirth(Month.APRIL)
                .yearOfBirth(Integer.toString(faker.number().numberBetween(1980, 2000)))
                .isNewsletterEnabled(faker.random().nextBoolean())
                .title(Title.MR)
                .build();
    }

    public static User createTestUser() {
        return new User.UserBuilder()
                .firstName("Artem")
                .lastName("Bondarenko")
                .email("bondarenko@gmail.com")
                .password("SecurePassword123")
                .dayOfBirth("10")
                .monthOfBirth(Month.APRIL)
                .yearOfBirth(Integer.toString(2000))
                .isNewsletterEnabled(true)
                .title(Title.MR)
                .build();
    }

    public static User getUserByName(String name) {
        for (User user: users) {
            if (user.getFirstName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
