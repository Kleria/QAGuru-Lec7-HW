package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    genderWrapper = $("#genterWrapper"),
    userNumber =  $("#userNumber"),
    calendarInput = $("#dateOfBirthInput"),
    hobbiesWrapper = $("#hobbiesWrapper"),
    subjectsInput =  $("#subjectsInput"),
    uploadPicture =  $("#uploadPicture"),
    currentAddress = $("#currentAddress"),
    state =$("#state"),
    city =$("#city"),
    submitButton = $("#submit"),
    resultTable = $(".table-responsive");








CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage userEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage genderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage userNumber(String value){
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
       return this;
    }

    public RegistrationPage hobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage uploadPicture(String classpath) {
        uploadPicture.uploadFromClasspath(classpath);
        return this;
    }
    public RegistrationPage currentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationPage state(String value) {
        state.click();
        state.$(byText(value)).click();
        return this;
    }
    public RegistrationPage city(String value) {
        city.click();
        city.$(byText(value)).click();
        return this;
    }
    public RegistrationPage submitButton() {
        submitButton.click();
        return this;
    }
    public RegistrationPage resultTable(String value) {
        resultTable.shouldHave(text(value));
        return this;
    }
    public RegistrationPage resultTableAbsent() {
        resultTable.shouldNotBe(visible);
        return this;
    }
}


