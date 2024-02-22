package tests;

import com.codeborne.selenide.Configuration;
import config.zConfigBase;
import drivers.LocalDriver;
import helpers.AttachHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class zTestBaseLocal {
    public static zConfigBase configBase;

    @BeforeAll
    static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        configBase = new zConfigBase();

        Configuration.browser = LocalDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void beforeEach() {
        //SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
//        String sessionId = Selenide.sessionId().toString();
//        System.out.println(sessionId);
//
        AttachHelper.takeScreenshotAs("Last screenshot");
        AttachHelper.pageSource();
        closeWebDriver();

//        AttachHelper.addVideo(sessionId);
    }
}
