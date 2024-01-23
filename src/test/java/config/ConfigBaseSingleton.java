package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigBaseSingleton {

    private static BrowserstackConfig browserstackConfig;

    private ConfigBaseSingleton() {
        browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    }

    public static BrowserstackConfig getConfig() {
        if (browserstackConfig == null) {
            initializeConfig();
        }
        return browserstackConfig;
    }

    private static void initializeConfig() {
        browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    }

}
