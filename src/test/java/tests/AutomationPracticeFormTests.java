package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {

    String firstName = "Eduard",
            lastName = "Ovechkin",
            email = "ovi@chkin.edu",
            gender = "Male",
            userNumber = "1234567890",
            yearOfBirth = "1972",
            monthOfBirth = "January",
            dayOfBirth = "16",
            englishSubject = "English",
            mathsSubject = "Maths",
            sportsHobby = "Sports",
            readingHobby = "Reading",
            imageFileName = "image.png",
            currentAddress = "Street Lenin, 1",
            state = "Haryana",
            city = "Panipat";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void modalContentTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email).pressEnter();
        $("#genterWrapper").find(byText(gender)).click();
        $("#userNumber").setValue(userNumber);

        // Filling calendar block
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();

        $("#subjectsInput").setValue(englishSubject).pressEnter();
        $("#subjectsInput").setValue(mathsSubject).pressEnter();
        $("#hobbiesWrapper").find(byText(sportsHobby)).click();
        $("#hobbiesWrapper").find(byText(readingHobby)).click();
        $("#uploadPicture").uploadFromClasspath("images/" + imageFileName);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$(".table-responsive tr").filterBy(text("Student Name"))
                .shouldHave(texts(firstName + " " + lastName));
        $$(".table-responsive tr").filterBy(text("Student Email"))
                .shouldHave(texts(email));
        $$(".table-responsive tr").filterBy(text("Gender"))
                .shouldHave(texts(gender));
        $$(".table-responsive tr").filterBy(text("Mobile"))
                .shouldHave(texts(userNumber));
        $$(".table-responsive tr").filterBy(text("Date of Birth"))
                .shouldHave(texts(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $$(".table-responsive tr").filterBy(text("Subjects"))
                .shouldHave(texts(englishSubject + ", " + mathsSubject));
        $$(".table-responsive tr").filterBy(text("Hobbies"))
                .shouldHave(texts(sportsHobby + ", " + readingHobby));
        $$(".table-responsive tr").filterBy(text("Picture"))
                .shouldHave(texts(imageFileName));
        $$(".table-responsive tr").filterBy(text("Address"))
                .shouldHave(texts(currentAddress));
        $$(".table-responsive tr").filterBy(text("State and City"))
                .shouldHave(texts(state + " " + city));
    }

}
