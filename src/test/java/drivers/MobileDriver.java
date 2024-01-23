package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;

import static helpers.BrowserstackHelper.getBrowserstackUrl;
import static tests.TestBase.configBase;

public class MobileDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        BrowserstackConfig config = configBase.getConfig();
//        ConfigBaseSingleton.getConfig();

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("project", "autotests.mobile");
        caps.setCapability("build", "jobBaseName");
        //capabilities.setCapability("name", "Tests - " + platform + " - " + buildNumber);
        caps.setCapability("name", "Tests - on " + config.osType() + " - " + "buildNumber");
//        caps.setCapability("name", "Tests - on platform1 with buildNumber1");
        caps.setCapability("autoGrantPermissions", "true");

        caps.setCapability("deviceName", config.device());
        caps.setCapability("os_version", config.osVersion());
        caps.setCapability("app", config.app());

        if (config.osType().equals("android")) {
            return getAndroidDriver(caps);
        } else if (config.osType().equals("ios")) {
            return getIosDriver(caps);
        } else {
            return null;
        }
    }

    public AndroidDriver getAndroidDriver(MutableCapabilities caps) {
        return new AndroidDriver(getBrowserstackUrl(), caps);
    }

    public IOSDriver getIosDriver(MutableCapabilities caps) {
        return new IOSDriver(getBrowserstackUrl(), caps);
    }
}
