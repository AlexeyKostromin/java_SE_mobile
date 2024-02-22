package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.owner.LocalConfigOwner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class LocalDriver implements WebDriverProvider {
    UiAutomator2Options uiAutomator2Options;
    static LocalConfigOwner localConfig;

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        localConfig = ConfigFactory.create(LocalConfigOwner.class, System.getProperties());

        uiAutomator2Options = new UiAutomator2Options();
        UiAutomator2Options options = uiAutomator2Options;

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(localConfig.osVersion())
                .setDeviceName(localConfig.device())
                .setApp(getAppPath())
                .setAppPackage(localConfig.appPackage())      //get this from developer
                .setAppActivity(localConfig.appActivity());   //get this from developer

        return getDriver();
    }

    public WebDriver getDriver() {
        if (localConfig.osType().equals("android")) {
            return getAndroidDriver(uiAutomator2Options);
        } else if (localConfig.osType().equals("ios")) {
            return getIosDriver(uiAutomator2Options);
        } else {
            return null;
        }
    }
//    public WebDriver getDriver() {
//        if (localConfig.osType().equals("android")) {
//            return new AndroidDriver(getAppiumServerUrl(), uiAutomator2Options);
//        } else if (localConfig.osType().equals("ios")) {
//            return new IOSDriver(getAppiumServerUrl(), uiAutomator2Options);
//        } else {
//            throw new RuntimeException("Driver could not be determined");
//        }
//    }

    public AndroidDriver getAndroidDriver(UiAutomator2Options options) {
        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public IOSDriver getIosDriver(UiAutomator2Options options) {
        return new IOSDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://" + localConfig.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    //https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk
    private String getAppPath() {
        String appVersion = "app-alpha-universal-release.apk";
        String appUrl = "https://github.com/wikimedia/apps-android-wikipedia" +
                "/releases/download/latest/" + appVersion;
        String appPath = "src/test/resources/apps/" + appVersion;

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}
