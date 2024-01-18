package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigBase {

    private static BrowserstackConfig browserstackConfig;

    public ConfigBase() {
        browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    }

    public BrowserstackConfig getConfig() {
        return browserstackConfig;
    }

}
