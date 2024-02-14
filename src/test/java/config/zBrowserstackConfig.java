package config;

import config.owner.BrowserstackConfigOwner;
import org.aeonbits.owner.ConfigFactory;

public class zBrowserstackConfig {

    private static BrowserstackConfigOwner browserstackConfig;

    public zBrowserstackConfig() {
        browserstackConfig = ConfigFactory.create(BrowserstackConfigOwner.class, System.getProperties());
    }

    public BrowserstackConfigOwner getConfig() {
        return browserstackConfig;
    }

}
