package helpers;

import config.BrowserstackConfigFull;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class BrowserstackHelper {
    static BrowserstackConfigFull browserstackConfigFull = BrowserstackConfigFull.getInstance();

    public static URL getBrowserstackUrl() {
        try {
            return new URL("https://" + browserstackConfigFull.userName + ":" + browserstackConfigFull.userKey + "@" + browserstackConfigFull.bsUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getVideoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(browserstackConfigFull.userName, browserstackConfigFull.userKey)
                .when()
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
