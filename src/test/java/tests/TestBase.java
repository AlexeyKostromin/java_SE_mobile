package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.BrowserstackConfigFull;
//import config.LocalConfig;
import drivers.LocalAndroidDriver;
import drivers.LocalDriver;
import drivers.LocalDriverSR;
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
    //    public static BrowserstackConfigFull browserstackConfigFull;
//    public static LocalConfig localConfig;
    public static String runtimeEnvironment;

    @BeforeAll
    static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        runtimeEnvironment = System.getProperty("runtimeEnv", "local");

//        initConfig();
        initDriver();
    }

//    static void initConfig() {
//
//        if (runtimeEnvironment.equals("local")) {
//            localConfig = new LocalConfig();
//        } else if (runtimeEnvironment.equals("browserstack")) {
//            browserstackConfigFull = BrowserstackConfigFull.getInstance();
//        } else {
//            throw new RuntimeException("You need to specify runtimeEnv!");
//        }
//    }

    static void initDriver() {
        Configuration.browser = null;
        switch (runtimeEnvironment) {
            case "local" -> Configuration.browser = LocalDriver.class.getName();
            case "browserstack" -> Configuration.browser = MobileDriver.class.getName();
            case "localDriverSR" -> Configuration.browser = LocalDriverSR.class.getName();
            default -> throw new RuntimeException("runtimeEnv is invalid!");
        }

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
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);

        AttachHelper.takeScreenshotAs("Last screenshot");
        AttachHelper.pageSource();
        closeWebDriver();

        if (runtimeEnvironment.equals("browserstack")) {
            AttachHelper.addVideoBrowserstack(sessionId);
        }
    }
}
