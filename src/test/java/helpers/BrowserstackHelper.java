package helpers;

import static io.restassured.RestAssured.given;

public class BrowserstackHelper {

    public static String getVideoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("alexq_SgYyvP", "wnUAtVceBCst1TsscWax")
                .get(url)
                .then()
                .log().status().log().body().statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
