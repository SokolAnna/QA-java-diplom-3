import praktikum.MainClient;
import praktikum.UserClient;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.pageobject.ForgotPasswordPageElements;
import praktikum.pageobject.LoginPageElements;
import praktikum.pageobject.MainPageElements;
import praktikum.pageobject.RegisterPageElements;
import praktikum.UserGenerator;
import praktikum.UserData;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BeforeSetUp {
    int statusCode;
    String token;
    UserData userData;
    UserClient userClient;
    MainPageElements mainOpen;
    MainPageElements mainPage;
    LoginPageElements loginPage;
    RegisterPageElements registerPage;
    ForgotPasswordPageElements forgotPasswordPage;

    @Before
    public void setUp() {
        userData = UserGenerator.getRandom();

        userClient = new UserClient();
        ValidatableResponse createResponse = userClient.create(userData);
        statusCode = createResponse.extract().statusCode();
        token = createResponse.extract().path("accessToken");

        mainOpen = open(MainClient.BASE_URL, MainPageElements.class);
        mainPage = page(MainPageElements.class);
        loginPage = page(LoginPageElements.class);
        registerPage = page(RegisterPageElements.class);
        forgotPasswordPage = page(ForgotPasswordPageElements.class);
    }

    @After
    public void tearDown() {
        if (statusCode == 200) {
            userClient.deleteUser(token);
        }
    }

    @Test
    @DisplayName("Login from login button is success")
    @Description("Button on the main page on the right, valid data")
    public void loginMainLoginButtonSuccess() {
        mainOpen.loginButtonClick();
        loginPage.setLoginUser(userData.getEmail(), userData.getPassword());
        mainPage.collectBurgerMenu.shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Login from header success")
    @Description("Login from header personal account button, valid data")
    public void loginFromHeaderSuccess() {
        mainOpen.accountButtonClick();
        loginPage.setLoginUser(userData.getEmail(), userData.getPassword());
        mainPage.collectBurgerMenu.shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Login from registration page link")
    @Description("Already registered link, valid data")
    public void loginFromRegistrationPageLink() {
        mainOpen.accountButtonClick();
        loginPage.registerLinkClick();

        registerPage.registrationLoginButtonClick();
        loginPage.setLoginUser(userData.getEmail(), userData.getPassword());
        mainPage.collectBurgerMenu.shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Login from reset password page link")
    @Description("Remembered the password link, valid data")
    public void loginFromResetPasswordPageLink() {
        mainOpen.accountButtonClick();
        loginPage.resetPasswordLinkClick();

        forgotPasswordPage.rememberedPasswordLinkClick();
        loginPage.setLoginUser(userData.getEmail(), userData.getPassword());
        mainPage.collectBurgerMenu.shouldBe(Condition.visible);
    }
}