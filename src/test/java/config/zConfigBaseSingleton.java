package config;

import config.owner.BrowserstackConfigOwner;
import org.aeonbits.owner.ConfigFactory;

public class zConfigBaseSingleton {

    private static BrowserstackConfigOwner browserstackConfig;

    private zConfigBaseSingleton() {
        browserstackConfig = ConfigFactory.create(BrowserstackConfigOwner.class, System.getProperties());
    }

    public static BrowserstackConfigOwner getConfig() {
        if (browserstackConfig == null) {
            initializeConfig();
        }
        return browserstackConfig;
    }

    private static void initializeConfig() {
        browserstackConfig = ConfigFactory.create(BrowserstackConfigOwner.class, System.getProperties());
    }

}
