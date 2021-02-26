package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {

    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.startMaximized = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud:4444/wd/hub";
    }
}
