package config;

import config.owner.BrowserstackConfigOwner;
import org.aeonbits.owner.ConfigFactory;

public class LocalConfigFull {

    //public final String runtimeEnvironment = System.getProperty("runtimeEnv", "local");
    public final String mobileEnvironment = System.getProperty("envMobile", "android");

    BrowserstackConfigOwner browserstackConfigOwner = ConfigFactory.create(BrowserstackConfigOwner.class, System.getProperties());

    public final String bsUrl = browserstackConfigOwner.url();
    public final String osType = browserstackConfigOwner.osType();

    public final String osVersion = browserstackConfigOwner.osVersion();
    public final String mobileDevice = browserstackConfigOwner.device();

    public final String app = browserstackConfigOwner.app();

}
