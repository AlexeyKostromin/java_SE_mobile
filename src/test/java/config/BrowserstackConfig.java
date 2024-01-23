package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envMobile}.properties"
})

public interface BrowserstackConfig extends Config{
        @Key("bsUser")
        String user();

        @Key("bsKey")
        String key();

        @Key("mobileDevice")
        String device();

        @Key("osType")
        String osType();

        @Key("osVersion")
        String osVersion();

        @Key("app")
        String app();

        @Key("bsUrl")
        String url();
}
