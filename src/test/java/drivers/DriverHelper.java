package drivers;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.EnvironmentHelper.isAndroid;
import static helpers.EnvironmentHelper.isIos;

public class DriverHelper {

public static void configureSelenide(){
    addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

    if(isAndroid || isIos){
        Configuration.browser = MobileDriver.class.getName();
        Configuration.browserSize = null;
    }
    Configuration.timeout = 10000;


}


}
