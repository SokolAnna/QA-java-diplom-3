import praktikum.MainClient;
import praktikum.UserClient;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.pageObject.LoginPageElements;
import praktikum.pageObject.MainPageElements;
import praktikum.pageObject.RegisterPageElements;
import praktikum.UserGenerator;
import praktikum.UserData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegisterTest {
    int statusCode;
    String token;
    UserData userData;
    UserClient userClient;
    MainPageElements mainPage;
    LoginPageElements loginPage;
    RegisterPageElements registerPage;

    @Before
    public void setUp() {
        userData = UserGenerator.getRandom();
        System.setProperty("selenide.browser", "Chrome");
        Configuration.pageLoadTimeout = 45000;

        mainPage = open(MainClient.BASE_URL, MainPageElements.class);
        mainPage.personalAccountButton.click();
        loginPage = page(LoginPageElements.class);
        loginPage.registerLink.click();
        registerPage = page(RegisterPageElements.class);
    }

    @After
    public void tearDown() {
        UserData userLogin = new UserData(userData.getEmail(), userData.getPassword());
        userClient = new UserClient();
        ValidatableResponse createResponse = userClient.login(userLogin);
        statusCode = createResponse.extract().statusCode();

        if (statusCode == 200) {
            token = createResponse.extract().path("accessToken");
            userClient.deleteUser(token);
        }
    }

    @Test
    @DisplayName("Register user valid data positive result")
    @Description("Basic register user test")
    public void registerValidDataPositiveResult() {
        registerPage.setRegisterUserData(userData.getName(), userData.getEmail(), userData.getPassword());
        loginPage.loginLogo.shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Register user short password input error")
    @Description("Trying to put five symbols password error expected")
    public void registerShortPasswordInputError() {
        registerPage.setRegisterUserData(userData.getName(), userData.getEmail(), "passw");
        registerPage.inputPasswordError.shouldHave(text("Некорректный пароль"));
    }
}