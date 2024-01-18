package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static helpers.BrowserstackHelper.getBrowserstackUrl;
import static helpers.EnvironmentHelper_old.*;

public class MobileDriver2 implements WebDriverProvider {


    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
            return getAndroidDriver();

    }

    private DesiredCapabilities commonCapabilities() {
        //MutableCapabilities caps = new MutableCapabilities();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", "autotests.mobile");
        capabilities.setCapability("build", "jobBaseName");
        //capabilities.setCapability("name", "Tests - " + platform + " - " + buildNumber);
        capabilities.setCapability("name", "Tests - on platform1 with buildNumber1");
        capabilities.setCapability("autoGrantPermissions", "true");

        return capabilities;
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("deviceName", androidDevice);
        capabilities.setCapability("os_version", androidVersion);
        //capabilities.setCapability("platformVersion", androidVersion);
        capabilities.setCapability("app", androidAppBrowserstack);

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

    public IOSDriver getIosDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("deviceName", iosDevice);
        capabilities.setCapability("os_version", iosVersion);
        capabilities.setCapability("app", iosAppBrowserstack);

        return new IOSDriver(getBrowserstackUrl(), capabilities);
    }

}
