package helpers;

import java.net.MalformedURLException;
import java.net.URL;

import static helpers.EnvironmentHelper.bsLogin;
import static helpers.EnvironmentHelper.bsPassword;
import static io.restassured.RestAssured.given;

public class BrowserstackHelper {

    public static URL getBrowserstackUrl() {
        try {
            return new URL("https://" + bsLogin + ":" + bsPassword + "@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getVideoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
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
