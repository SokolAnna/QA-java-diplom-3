package praktikum.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageElements {
    @FindBy(how = How.CLASS_NAME, using = "Auth_login__3hAey")
    public SelenideElement loginLogo;
    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    public SelenideElement loginText;

    @FindBy(how = How.XPATH, using = "//div[@class='input pr-6 pl-6 input_type_text input_size_default']/label[text()='Email']")
    public SelenideElement emailPlaceholderTextLogin;
    @FindBy(how = How.XPATH, using = "//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@name='name']")
    public SelenideElement emailPlaceholderLogin;

    public void emailPlaceholderLoginClick() {
        emailPlaceholderTextLogin.click();
    }

    public void emailPlaceholderLoginSet(String email) {
        emailPlaceholderLogin.setValue(email);
    }

    public void setEmailLogin(String email) {
        emailPlaceholderLoginClick();
        emailPlaceholderLoginSet(email);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='input pr-6 pl-6 input_type_password input_size_default']/label[text()='Пароль']")
    public SelenideElement passwordPlaceholderTextLogin;
    @FindBy(how = How.XPATH, using = "//div[@class='input pr-6 pl-6 input_type_password input_size_default input_status_active']/input[@name='Пароль']")
    public SelenideElement passwordPlaceholderLogin;

    public void passwordPlaceholderClickLogin() {
        passwordPlaceholderTextLogin.click();
    }

    public void passwordPlaceholderSetLogin(String password) {
        passwordPlaceholderLogin.setValue(password);
    }

    public void setPasswordLogin(String password) {
        passwordPlaceholderClickLogin();
        passwordPlaceholderSetLogin(password);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    public SelenideElement loginButton;

    @Step("Login user")
    public void setLoginUser(String email, String password) {
        setEmailLogin(email);
        setPasswordLogin(password);
        loginButton.click();
    }

    @FindBy(how = How.XPATH, using = "//p[@class='undefined text text_type_main-default text_color_inactive mb-4']/a[text()='Зарегистрироваться']")
    public SelenideElement registerLink;
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    public SelenideElement resetPasswordLink;
}