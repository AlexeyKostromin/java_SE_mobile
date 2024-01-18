package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;

import static helpers.BrowserstackHelper.getBrowserstackUrl;

public class BrowserstackDriver_new2 implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
//        DesiredCapabilities caps = new DesiredCapabilities();

        BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

        // Set URL of the application under test
        caps.setCapability("app", config.app());

        // Specify device and os_version for testing
        caps.setCapability("deviceName", config.device());
        caps.setCapability("os_version", config.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("debug", "true");

        // Initialise the remote Webdriver using BrowserStack remote URL with desired capabilities defined above
        System.out.println(caps);
        return new AndroidDriver(getBrowserstackUrl(), caps);

//        try {
//            return new RemoteWebDriver(
//                    new URL(config.url()), caps);//last screenshot not works
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }



    }
}
