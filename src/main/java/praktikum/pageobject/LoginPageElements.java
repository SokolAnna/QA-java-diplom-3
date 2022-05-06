package praktikum.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

public class LoginPageElements {
    @FindBy(how = How.CLASS_NAME, using = "Auth_login__3hAey")
    public SelenideElement loginLogo;
    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    public SelenideElement loginText;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']")
    public SelenideElement emailPlaceholderTextLogin;
    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    public SelenideElement emailPlaceholderLogin;

    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']")
    public SelenideElement passwordPlaceholderTextLogin;
    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    public SelenideElement passwordPlaceholderLogin;

    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    public SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    public SelenideElement registerLink;
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    public SelenideElement resetPasswordLink;

    public void emailPlaceholderLoginClick() {
        emailPlaceholderTextLogin.shouldBe(enabled).click();
    }

    public void emailPlaceholderLoginSet(String email) {
        emailPlaceholderLogin.setValue(email);
    }

    public void setEmailLogin(String email) {
        emailPlaceholderLoginClick();
        emailPlaceholderLoginSet(email);
    }

    public void passwordPlaceholderClickLogin() {
        passwordPlaceholderTextLogin.shouldBe(enabled).click();
    }

    public void passwordPlaceholderSetLogin(String password) {
        passwordPlaceholderLogin.setValue(password);
    }

    public void setPasswordLogin(String password) {
        passwordPlaceholderClickLogin();
        passwordPlaceholderSetLogin(password);
    }

    @Step("Login user")
    public void setLoginUser(String email, String password) {
        setEmailLogin(email);
        setPasswordLogin(password);
        loginButton.click();
    }

    @Step("Click already registered link on the login page")
    public void registerLinkClick() {
        registerLink.shouldBe(enabled).click();
    }

    @Step("Click reset password link on the login page")
    public void resetPasswordLinkClick() {
        resetPasswordLink.click();
    }
}