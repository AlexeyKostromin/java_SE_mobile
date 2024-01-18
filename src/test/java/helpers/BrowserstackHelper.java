package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class BrowserstackHelper {
    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    public static URL getBrowserstackUrl() {
        try {
            //return new URL("https://" + bsLogin + ":" + bsPassword + "@hub-cloud.browserstack.com/wd/hub");
            return new URL("https://" + config.user() + ":" + config.key() + "@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getVideoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
//                .auth().basic(config.user(), config.key())
                .auth().basic("alexq_SgYyvP", "wnUAtVceBCst1TsscWax")
                .when()
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
