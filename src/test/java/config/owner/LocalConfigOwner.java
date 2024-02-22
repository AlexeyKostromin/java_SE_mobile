package config.owner;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envMobile}.properties"
})

public interface LocalConfigOwner extends Config {
    @Key("url")
    String url();

    @Key("osType")
    String osType();

    @Key("osVersion")
    String osVersion();

    @Key("mobileDevice")
    String device();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();


}
