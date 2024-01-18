package drivers;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.zEnvironmentHelper.isAndroid;
import static helpers.zEnvironmentHelper.isIos;

public class zDriverHelper {

    public static void configureSelenide2() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));


//            Configuration.browser = MobileDriver2.class.getName();
            Configuration.browser = zBrowserstackDriver.class.getName();
            Configuration.browserSize = null;

        Configuration.timeout = 10000;
    }

}
