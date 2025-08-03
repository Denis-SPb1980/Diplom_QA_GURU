package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    static void setUp() {
        step("Открытие страницы", () -> {
            Configuration.browser = System.getProperty("browser", "chrome");
            Configuration.browserVersion = System.getProperty("browserVersion", "127.0");
            Configuration.browserSize = System.getProperty("screenResolution", "1920x1080");
            Configuration.baseUrl = "https://pitergsm.ru";
            Configuration.pageLoadStrategy = "eager";
            Configuration.remote = String.format(
                    "https://%s:%s@%s/wd/hub",
                    System.getProperty("selenoidLogin", "user1"),
                    System.getProperty("selenoidPassword", "1234"),
                    System.getProperty("selenoidHost",  "selenoid.autotests.cloud")
            );


            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        } );
    }

    @BeforeEach
    void prepare() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshots");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}