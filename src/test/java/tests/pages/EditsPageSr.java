package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class EditsPageSr {

    public SelenideElement
            searchBar = $(id("SearchBarTextInput")),
            myEdits = $(id("MyEdits")),
            sentEdits = $(id("SentEdits")),
            timelines = $(id("Timelines")),
            allEdits = $(id("AllEdits")),
            newEditBtn = $(xpath("//*[@text='NEW EDIT']"));


//    public void loginWithCredentials(String userName, String password) {
//        userNameTextBox.click();
//        userNameTextBox.sendKeys(userName);
//        passwordTextBox.click();
//        passwordTextBox.sendKeys(password);
//        loginFormBtn.click();
//    }


}
