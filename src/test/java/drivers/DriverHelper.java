package drivers;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.EnvironmentHelper_old.isAndroid;
import static helpers.EnvironmentHelper_old.isIos;

public class DriverHelper {

    public static void configureSelenide() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        if (isAndroid || isIos) {
            //Configuration.browser = MobileDriver.class.getName();
            Configuration.browser = BrowserstackDriver_new.class.getName();
            Configuration.browserSize = null;
        }
        Configuration.timeout = 10000;
    }
    public static void configureSelenide2() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));


//            Configuration.browser = MobileDriver2.class.getName();
            Configuration.browser = BrowserstackDriver_new2.class.getName();
            Configuration.browserSize = null;

        Configuration.timeout = 10000;
    }

}
