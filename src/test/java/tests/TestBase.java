package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ConfigBase;
import drivers.MobileDriver;
import helpers.AttachHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {
    public static ConfigBase configBase;

    @BeforeAll
    static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

         configBase = new ConfigBase();

        Configuration.browser = MobileDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }
//    @BeforeAll
//    static void beforeAll() {
//        //DriverHelper.configureSelenide();
//        DriverHelper.configureSelenide2();
//    }

    @BeforeEach
    void beforeEach() {
        //SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);

        AttachHelper.takeScreenshotAs("Last screenshot");
        AttachHelper.pageSource();
        closeWebDriver();

        AttachHelper.addVideo(sessionId);
    }
}
