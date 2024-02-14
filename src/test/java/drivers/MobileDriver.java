package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfigFull;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;

import static helpers.BrowserstackHelper.getBrowserstackUrl;

public class MobileDriver implements WebDriverProvider {

    BrowserstackConfigFull browserstackConfigFull;
    MutableCapabilities mutableCapabilities;

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        browserstackConfigFull = BrowserstackConfigFull.getInstance();
        mutableCapabilities = new MutableCapabilities();

        mutableCapabilities.setCapability("project", "autotests.mobile");
        mutableCapabilities.setCapability("build", "jobBaseName");
        //capabilities.setCapability("name", "Tests - " + platform + " - " + buildNumber);
        mutableCapabilities.setCapability("name", "Tests - on " + browserstackConfigFull.osType + " - " + "buildNumber");
//        caps.setCapability("name", "Tests - on platform1 with buildNumber1");
        mutableCapabilities.setCapability("autoGrantPermissions", "true");

        mutableCapabilities.setCapability("deviceName", browserstackConfigFull.mobileDevice);
        mutableCapabilities.setCapability("os_version", browserstackConfigFull.osVersion);
        mutableCapabilities.setCapability("app", browserstackConfigFull.app);

        return getDriver();
    }

    public WebDriver getDriver() {
        if (browserstackConfigFull.osType.equals("android")) {
            return getAndroidDriver(mutableCapabilities);
        } else if (browserstackConfigFull.osType.equals("ios")) {
            return getIosDriver(mutableCapabilities);
        } else {
            throw new RuntimeException("Driver could not be determined");
        }
    }

    public AndroidDriver getAndroidDriver(MutableCapabilities caps) {
        return new AndroidDriver(getBrowserstackUrl(), caps);
    }

    public IOSDriver getIosDriver(MutableCapabilities caps) {
        return new IOSDriver(getBrowserstackUrl(), caps);
    }
}
