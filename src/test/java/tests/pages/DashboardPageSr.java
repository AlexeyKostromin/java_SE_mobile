package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class DashboardPageSr {

    public SelenideElement
            permissionAllowBtn = $(id("com.android.permissioncontroller:id/permission_allow_button")),
            loginBtn = $(id("login-button")),
            userNameTextBox = $(id("Username")),
            passwordTextBox = $(id("Password")),
            loginFormBtn = $(xpath("//*[@text='Login']")),
            skipForNow = $(xpath("//*[@text='Skip for now']")),
            diveStraightInBtn = $(id("DiveStraightInButton")),
            mainMenu = $(id("drawerId")),
            settings = $(xpath("//*[@text='SETTINGS']")),
            profileSettings = $(xpath("//*[@text='Profile Settings']")),
            currentSportDropDown = $(id("textInput")),
            sportBasketball = $(xpath("//*[@text='Basketball']")),
            saveProfileSettings = $(xpath("//*[@text='SAVE']")),
            menuBack = $(xpath("//*[@content-desc='Go back']")),
            menuDashboard = $(xpath("//*[@text='DASHBOARD']")),
            menuEdits = $(xpath("//*[@content-desc='EDITS']")),
            menuGames = $(xpath("//*[@content-desc='GAMES']")),
    //click Games
    gamesActionItem = $(id("GamesActionItem")),
            editsActionItem = $(id("EditsActionItem"));


    public void loginWithCredentials(String userName, String password) {
        userNameTextBox.click();
        userNameTextBox.sendKeys(userName);
        passwordTextBox.click();
        passwordTextBox.sendKeys(password);
        loginFormBtn.click();
    }

    public void skipIntro() {
        skipForNow.click();
        diveStraightInBtn.click();
    }

    public void goToProfileSettings() {
        mainMenu.click();
        settings.click();
        profileSettings.click();
    }

    public void setSportBasketball() {
        currentSportDropDown.click();
        sportBasketball.click();
        saveProfileSettings.click();
    }

    public void goBackToDashboardPage() {
        menuBack.click();
        menuDashboard.click();
//        mainMenu.click();
    }

}
