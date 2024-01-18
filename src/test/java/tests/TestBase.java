package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackDriver;
import drivers.BrowserstackDriver_new;
//import helpers.AttachHelper;
import helpers.AttachHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }
//    @BeforeAll
//    static void beforeAll() {
//        DriverHelper.configureSelenide();
//    }

    @BeforeEach
    void beforeEach() {
        //SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);

        //AttachHelper.takeScreenshotAs("Last screenshot");
        AttachHelper.pageSource();
        closeWebDriver();
        AttachHelper.addVideo(sessionId);
    }
}
