package config.owner;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserStackAuth.properties"
})

public interface BrowserstackConfigAuthOwner extends Config {
    @Key("bsUser")
    String user();

    @Key("bsKey")
    String key();
}
