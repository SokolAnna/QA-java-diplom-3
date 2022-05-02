import praktikum.MainClient;
import praktikum.UserClient;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.pageObject.LoginPageElements;
import praktikum.pageObject.MainPageElements;
import praktikum.pageObject.ProfilePageElements;
import praktikum.UserGenerator;
import praktikum.UserData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

import java.lang.*;
import java.time.Duration;

public class ProfileTest {
    int statusCode;
    String token;
    UserData userData;
    UserClient userClient;
    MainPageElements mainOpen;
    MainPageElements mainPage;
    LoginPageElements loginPage;
    ProfilePageElements profilePage;

    @Before
    public void setUp() {
        userData = UserGenerator.getRandom();
        System.setProperty("selenide.browser", "Chrome");
        Configuration.pageLoadTimeout = 45000;

        userClient = new UserClient();
        ValidatableResponse createResponse = userClient.create(userData);
        statusCode = createResponse.extract().statusCode();
        token = createResponse.extract().path("accessToken");

        mainOpen = open(MainClient.BASE_URL, MainPageElements.class);
        mainPage = page(MainPageElements.class);
        loginPage = page(LoginPageElements.class);
        profilePage = page(ProfilePageElements.class);

        mainOpen.personalAccountButton.click();
        loginPage.setLoginUser(userData.getEmail(), userData.getPassword());
    }

    @After
    public void tearDown() {
        if (statusCode == 200) {
            userClient.deleteUser(token);
        }
    }

    @Test
    @DisplayName("Authorized user personal account success")
    @Description("Move from main page to personal account page, authorized user")
    public void authorizedUserPersonalAccountSuccess() {
        mainPage.personalAccountButton.click();

        profilePage.personalAccountPageButton.shouldBe(Condition.visible);
        profilePage.profileText.shouldBe(Condition.visible);
        profilePage.descriptionText.shouldHave(text("В этом разделе вы можете изменить свои персональные данные"));
    }

    @Test
    @DisplayName("Account page click constructor button")
    @Description("Goes to main page from account page success")
    public void accountClickConstructorButtonSuccess() {
        mainPage.personalAccountButton.click();

        mainPage.constructorButton.click();
        mainPage.collectBurgerMenu.shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Account page click burger logo")
    @Description("Goes to main page from account page success")
    public void accountClickBurgerLogoSuccess() {
        mainPage.personalAccountButton.click();

        mainPage.headerLogo.click();
        mainPage.collectBurgerMenu.shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Account logout success")
    @Description("Logout from account profile page logout button")
    public void accountLogoutSuccess() {
        mainPage.personalAccountButton.click();
        profilePage.logoutButton.should(visible, Duration.ofSeconds(500));
        profilePage.logoutButton.click();

        loginPage.loginLogo.shouldBe(visible);
        loginPage.loginText.shouldBe(visible);
    }
}