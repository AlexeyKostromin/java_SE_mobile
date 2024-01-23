package helpers;

import config.BrowserstackConfig;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static tests.TestBase.configBase;

public class BrowserstackHelper {
//    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
     static BrowserstackConfig config = configBase.getConfig();

    public static URL getBrowserstackUrl() {
        try {
            return new URL("https://" + config.user() + ":" + config.key() + "@hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getVideoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(config.user(), config.key())
                .when()
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
