package config;

import config.owner.BrowserstackConfigOwner;
import org.aeonbits.owner.ConfigFactory;

public class zConfigBase {

    private static BrowserstackConfigOwner browserstackConfig;

    public zConfigBase() {
        browserstackConfig = ConfigFactory.create(BrowserstackConfigOwner.class, System.getProperties());
    }

    public BrowserstackConfigOwner getConfig() {
        return browserstackConfig;
    }

}
