package helpers;

public class EnvironmentHelper_old {

//    public final static String platform = System.getProperty("platform", "android");
    public final static String platform = System.getProperty("platform", "ios");

    //BROWSERSTACK CONFIG
//    public static final String
//              bsLogin = System.getProperty("bs_login"),
//            bsPassword = System.getProperty("bs_password");

    public static final String
            bsLogin = System.getProperty("bs_login", "alexq_SgYyvP"),
            bsPassword = System.getProperty("bs_password", "wnUAtVceBCst1TsscWax");

    //ANDROID CONFIG
    public static final boolean isAndroid = platform.equals("android");
    public static final String
            androidDevice = System.getProperty("mobile_device", "Google Pixel 3"),
            androidVersion = System.getProperty("os_version", "9.0"),
            androidAppBrowserstack = System.getProperty("app_bs", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

    //IOS CONFIG
    public static final boolean isIos = platform.equals("ios");
    public static final String
            iosDevice = System.getProperty("mobile_device", "iPhone 11 Pro Max"),
            iosVersion = System.getProperty("os_version", "13.2"),
            //iosAppBrowserstack = System.getProperty("app_bs", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");
            iosAppBrowserstack = System.getProperty("app_bs", "bs://4a629f5858c31ca69c379d3546caa85638f9b697");


    // CI CONFIG (jenkins)
    public static final String
            buildNumber = System.getProperty("build_number", "1"),
            jobBaseName = System.getProperty("job_Base_name", "local");


}
