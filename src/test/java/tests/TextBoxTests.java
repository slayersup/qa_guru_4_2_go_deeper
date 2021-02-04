package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dataAppearsInOutputBlockTest() {
        open("https://demoqa.com/text-box");

        $("#userName").setValue("Alex");
        $("#userEmail").setValue("aa@aa.aa");
        $("#currentAddress").setValue("City 1, Street 1");
        $("#permanentAddress").setValue("City 2, Street 2");
        $("#submit").click();

        $("#output").shouldHave(text("Name:Alex"),
                text("Email:aa@aa.aa"),
                text("Current Address :City 1, Street 1"),
                text("Permananet Address :City 2, Street 2"));
    }
}
