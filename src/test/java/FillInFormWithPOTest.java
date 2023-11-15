import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultComponent;

public class FillInFormWithPOTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    RegistrationPage registrationPage = new RegistrationPage();
    ResultComponent resultComponent = new ResultComponent();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .eliminateBanners()
                .setFirstName("Jane")
                .setLastName("Doe")
                .userEmailInput("janedoe@test.com")
                .genderWrapper("Female")
                .userNumber("8800555353")
                .setDateOfBirth("10", "January", "1994")
                .hobbiesWrapper("Reading")
                .hobbiesWrapper("Music")
                .subjectsInput("Maths")
                .subjectsInput("History")
                .uploadPicture("Cat.jpg")
                .currentAddress("ul. Pushkina, d. Kolotushkina")
                .state("Haryana")
                .city("Panipat")
                .submitButton();
        resultComponent
                .checkResult("Jane Doe")
                .checkResult("janedoe@test.com")
                .checkResult("8800555353")
                .checkResult("10 January,1994")
                .checkResult("Maths, History")
                .checkResult("Reading, Music")
                .checkResult("Cat.jpg")
                .checkResult("ul. Pushkina, d. Kolotushkina")
                .checkResult("Haryana")
                .checkResult("Panipat");
    }

    @Test
    void fillFormTestMinData() {
        registrationPage.openPage()
                .eliminateBanners()
                .setFirstName("Doris")
                .setLastName("Doe")
                .genderWrapper("Other")
                .userNumber("7700775353")
                .hobbiesWrapper("Reading")
                .currentAddress("hotel California")
                .submitButton();
        resultComponent
                .checkResult("Doris Doe")
                .checkResult("Other")
                .checkResult("7700775353")
                .checkResult("Reading")
                .checkResult("hotel California");
    }
    @Test
    void fillFormTestPhoneAbsent() {
        registrationPage.openPage()
                .eliminateBanners()
                .setFirstName("Doris")
                .setLastName("Doe")
                .genderWrapper("Other")
                .hobbiesWrapper("Reading")
                .currentAddress("hotel California")
                .submitButton();
        resultComponent.tableNotAvailable();
    }
}