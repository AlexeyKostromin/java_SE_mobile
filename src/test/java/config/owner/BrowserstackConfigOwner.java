package config.owner;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envMobile}.properties"
})

public interface BrowserstackConfigOwner extends Config{
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
