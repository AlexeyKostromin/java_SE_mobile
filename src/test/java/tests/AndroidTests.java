package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {
    @Test
    @Tag("android")
    void successfulSearchTest() {
        final String searchRequest = "Appium";

        step("Type search ", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchRequest);
        });

        step("Verify content found", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @Tag("android")
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
