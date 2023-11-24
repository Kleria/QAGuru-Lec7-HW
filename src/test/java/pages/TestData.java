package pages;
import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {
    Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userPhone = faker.number().digits(10),
            userAddress = faker.address().streetAddress(),
            userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            userCity = getRandomCity(userState),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1960, 1999)),
            userGender = faker.options().option("Male", "Female", "Other"),
            userHobbies = faker.options().option("Sports", "Reading", "Music"),
            userSubject = faker.options().option("Maths", "English", "Physics", "Chemistry", "Computer Science", "Commerce",
                    "Economics", "Arts", "Social Studies", "History", "Civics", "Accounting", "Biology", "Hindi")
    ;

    ;
    public String getRandomCity(String userState) {
        switch (userState) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return userState;
        }


}}
