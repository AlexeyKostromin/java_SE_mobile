package helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

public class AttachHelper {
    @Attachment(value = "{attachName}", type = "iamge/png", fileExtension = "png")
    public static byte[] takeScreenshotAs(String attachName) {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

//    public static void browserConsoleLogs() {
//        attachAsText("Browser console logs",
//                String.join("\n", Selenide.getWebDriverLogs(BROWSER)));
//    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo(String sessionId) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + BrowserstackHelper.getVideoUrl(sessionId)
                + "' type='video/mp4'></video></body></html>";
    }

    //curl -u "alexq_SgYyvP:wnUAtVceBCst1TsscWax" -X GET "https://api.browserstack.com/app-automate/sessions/<session-id>.json"
//curl -u alexq_SgYyvP:wnUAtVceBCst1TsscWax -X GET https://api.browserstack.com/app-automate/sessions/a88bb4233b521a7fcee16b2496dc16b36cad54e5.json

//    public static URL getVideoUrl() {
//        var remoteDriverUrl = System.getProperty("remoteDriverUrl");
//        String videoUrl = "https://" + remoteDriverUrl + "/video/" + sessionId() + ".mp4";
//        try {
//            return new URL(videoUrl);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
