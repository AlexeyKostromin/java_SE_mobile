package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.pages.DashboardPageSr;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class LocalTestsSr extends TestBase {

    DashboardPageSr homePageSr= new DashboardPageSr();

    @Test
    @Tag("android_local_SR")
    @DisplayName("Search item")
    void successfulSearchTest() {

        homePageSr.permissionAllowBtn.click();
        homePageSr.loginBtn.click();
        homePageSr.loginWithCredentials("o.kostromin@sportradar.com" , "OKwarsaw100@");
        homePageSr.skipIntro();

        homePageSr.goToProfileSettings();
        homePageSr.setSportBasketball();
        homePageSr.goBackToDashboardPage();
    }

    @Test
    @Tag("android_local_SR1")
    @DisplayName("Search item")
    void successfulSearchTest1() {
        final String searchRequest = "Appium";
        step("Allow notifications", () -> {
            $(id("com.android.permissioncontroller:id/permission_allow_button")).click();
        });
        step("Click Login", () -> {
            $(id("login-button")).click();
        });

        step("Username and password", () -> {
            $(id("Username")).click();
            $(id("Username")).sendKeys("o.kostromin@sportradar.com");;

            $(id("Password")).click();
            $(id("Password")).sendKeys("OKwarsaw100@");
            $(xpath("//*[@text='Login']")).click();
        });
        step("Skip for now", () -> {
            $(xpath("//*[@text='Skip for now']")).click();
            $(id("DiveStraightInButton")).click();
        });

//menu button = drawerId
        $(id("drawerId")).click();
        $(xpath("//*[@text='SETTINGS']")).click();
        $(xpath("//*[@text='Profile Settings']")).click();
        $(id("textInput")).click();

        $(xpath("//*[@text='Basketball']")).click();
        $(xpath("//*[@text='SAVE']")).click();
        $(xpath("//*[@content-desc='Go back']")).click();

        //close manu
        $(id("drawerId")).click();
        //click Games
        $(id("GamesActionItem")).click();


//        step("Pass onboarding screen2", () -> {
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
//        });
//        step("Pass onboarding screen3", () -> {
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
//        });
//        step("Pass onboarding screen4", () -> {
//            $(id("org.wikipedia.alpha:id/acceptButton")).click();
//        });
//
//        step("Type search ", () -> {
//            $(accessibilityId("Search Wikipedia")).click();
//            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchRequest);
//        });
//
//        step("Verify content found", () -> {
//            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
//                    .shouldHave(sizeGreaterThan(0));
//        });
    }

    @Test
    @Tag("android1")
    @DisplayName("Search and open article, then go back")
    void openArticleByNameTest() {
        final String searchRequest = "Appium";
        final String articleToSelect = "Appius Claudius Caecus";

        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchRequest);
        });

        step("Click on the item with text ", () -> {
            var results = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
            results.findBy(Condition.text(articleToSelect)).click();
        });

        step("Verify error occured", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldHave(Condition.text("An error occurred"));
        });

        step("Click GO BACK, ensure main page loaded and search toolbar is visible", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_button")).click();
            $(accessibilityId("Search Wikipedia")).shouldBe(Condition.visible);
        });
    }


}
