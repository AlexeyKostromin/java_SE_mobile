package config;

import config.owner.BrowserstackConfigAuthOwner;
import config.owner.BrowserstackConfigOwner;
import org.aeonbits.owner.ConfigFactory;

public class BrowserstackConfigFull {

    private static BrowserstackConfigFull instance;
    public final String userName;
    public final String userKey;
    public final String bsUrl;
    public final String osType;
    public final String osVersion;
    public final String mobileDevice;

    public final String app;

    public BrowserstackConfigFull() {
        BrowserstackConfigAuthOwner browserstackConfigAuthOwner = ConfigFactory.create(BrowserstackConfigAuthOwner.class, System.getProperties());
        userName = browserstackConfigAuthOwner.user();
        userKey = browserstackConfigAuthOwner.key();

        BrowserstackConfigOwner browserstackConfigOwner = ConfigFactory.create(BrowserstackConfigOwner.class, System.getProperties());
        bsUrl = browserstackConfigOwner.url();
        osType = browserstackConfigOwner.osType();
        osVersion = browserstackConfigOwner.osVersion();
        mobileDevice = browserstackConfigOwner.device();
        app = browserstackConfigOwner.app();
    }

    public static BrowserstackConfigFull getInstance() {
        if (instance == null) {
            instance = new BrowserstackConfigFull();
        }
        return instance;
    }

}
