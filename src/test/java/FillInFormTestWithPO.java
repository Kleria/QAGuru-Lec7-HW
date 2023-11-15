import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillInFormTestWithPO {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Jane")
                .setLastName("Doe")
                .userEmailInput("janedoe@test.com")
                .genderWrapper("Female")
                .userNumber("8800555353")
                .setDateOfBirth("9", "January", "1994")
                .hobbiesWrapper("Reading")
                .hobbiesWrapper("Music")
                .subjectsInput("Maths")
                .subjectsInput("History")
                .uploadPicture("Cat.jpg")
                .currentAddress("ul. Pushkina, d. Kolotushkina")
                .state("Haryana")
                .city("Panipat")
                .submitButton()
                .resultTable("Jane Doe")
                .resultTable("janedoe@test.com")
                .resultTable("8800555353")
                .resultTable("09 January,1994")
                .resultTable("Maths, History")
                .resultTable("Reading, Music")
                .resultTable("Cat.jpg")
                .resultTable("ul. Pushkina, d. Kolotushkina")
                .resultTable("Haryana")
                .resultTable("Panipat");
    }

    @Test
    void fillFormTestMinData() {
        registrationPage.openPage()
                .setFirstName("Doris")
                .setLastName("Doe")
                .genderWrapper("Other")
                .userNumber("7700775353")
                .hobbiesWrapper("Reading")
                .currentAddress("hotel California")
                .submitButton()

                .resultTable("Doris Doe")
                .resultTable("Other")
                .resultTable("7700775353")
                .resultTable("Reading")
                .resultTable("hotel California");
    }
    @Test
    void fillFormTestPhoneAbsent() {
        registrationPage.openPage()
                .setFirstName("Doris")
                .setLastName("Doe")
                .genderWrapper("Other")
                .hobbiesWrapper("Reading")
                .currentAddress("hotel California")
                .submitButton()
                .resultTableAbsent();
    }
}