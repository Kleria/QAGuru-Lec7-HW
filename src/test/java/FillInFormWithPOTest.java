import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TestData;
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
    TestData testData = new TestData();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .eliminateBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .userEmailInput(testData.userEmail)
                .genderWrapper(testData.getRandomGender())
                .userNumber(testData.userPhone)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .hobbiesWrapper(testData.userHobbies())
                .subjectsInput(testData.userSubject())
                .uploadPicture("Cat.jpg")
                .currentAddress(testData.userAddress)
                .state(testData.userState)
                .city(testData.userCity)
                .submitButton();
        resultComponent
                .checkResult(testData.firstName + " " + testData.lastName)
                .checkResult(testData.userEmail)
                .checkResult(testData.userPhone)
                .checkResult(testData.getRandomGender())
                .checkResult(testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .checkResult(testData.userHobbies())
                .checkResult(testData.userSubject())
                .checkResult("Cat.jpg")
                .checkResult(testData.userAddress)
                .checkResult(testData.userState)
                .checkResult(testData.userCity);
    }

    @Test
    void fillFormTestMinData() {
        registrationPage.openPage()
                .eliminateBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .genderWrapper(testData.getRandomGender())
                .userNumber(testData.userPhone)
                .hobbiesWrapper(testData.userHobbies())
                .currentAddress(testData.userAddress)
                .submitButton();
        resultComponent
                .checkResult(testData.firstName + testData.lastName)
                .checkResult(testData.getRandomGender())
                .checkResult(testData.userPhone)
                .checkResult(testData.userHobbies())
                .checkResult(testData.userAddress);
    }
    @Test
    void fillFormTestPhoneAbsent() {
        registrationPage.openPage()
                .eliminateBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .genderWrapper(testData.getRandomGender())
                .hobbiesWrapper(testData.userHobbies())
                .currentAddress(testData.userAddress)
                .submitButton();
        resultComponent.tableNotAvailable();

    }}