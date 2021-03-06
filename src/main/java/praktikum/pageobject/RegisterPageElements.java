package praktikum.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPageElements {
    @FindBy(how = How.XPATH, using = "//label[text()='Имя']")
    public SelenideElement namePlaceholderText;

    @FindBy(how = How.XPATH, using = "//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@name='name']")
    public SelenideElement namePlaceholder;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']")
    public SelenideElement emailPlaceholderText;
    @FindBy(how = How.XPATH, using = "//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@name='name']")
    public SelenideElement emailPlaceholder;

    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']")
    public SelenideElement passwordPlaceholderText;
    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    public SelenideElement passwordPlaceholder;

    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    public SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    public SelenideElement inputPasswordError;

    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    public SelenideElement alreadyRegisteredLoginButton;

    public void namePlaceholderClick() {
        namePlaceholderText.click();
    }

    public void namePlaceholderSet(String name) {
        namePlaceholder.setValue(name);
    }

    public void setName(String name) {
        namePlaceholderClick();
        namePlaceholderSet(name);
    }

    public void emailPlaceholderClick() {
        emailPlaceholderText.click();
    }

    public void emailPlaceholderSet(String email) {
        emailPlaceholder.setValue(email);
    }

    public void setEmail(String email) {
        emailPlaceholderClick();
        emailPlaceholderSet(email);
    }

    public void passwordPlaceholderClick() {
        passwordPlaceholderText.click();
    }

    public void passwordPlaceholderSet(String password) {
        passwordPlaceholder.setValue(password);
    }

    public void setPassword(String password) {
        passwordPlaceholderClick();
        passwordPlaceholderSet(password);
    }

    public void registerButtonClick() {
        registerButton.click();
    }

    @Step("Register user")
    public void setRegisterUserData(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        registerButtonClick();
    }

    @Step("Click login link on the registration page")
    public void registrationLoginButtonClick() {
        alreadyRegisteredLoginButton.click();
    }
}