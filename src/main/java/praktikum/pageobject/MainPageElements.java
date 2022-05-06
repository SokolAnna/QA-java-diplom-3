package praktikum.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class MainPageElements {

    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    public SelenideElement constructorButton;
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    public SelenideElement headerLogo;
    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    public SelenideElement personalAccountButton;

    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__1N8v2")
    public SelenideElement collectBurgerMenu;
    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__menuContainer__Xu3Mo")
    public SelenideElement ingredients;

    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    public SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    public SelenideElement bunsMenuButton;
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    public SelenideElement saucesMenuButton;
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    public SelenideElement fillingsMenuButton;

    @FindBy(how = How.XPATH, using = "//h2[text()='Булки']")
    public SelenideElement bunsHeader;
    @FindBy(how = How.XPATH, using = "//h2[text()='Соусы']")
    public SelenideElement saucesHeader;
    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    public SelenideElement fillingsHeader;

    @FindBy(how = How.XPATH, using = "//p[text()='Флюоресцентная булка R2-D3']")
    public SelenideElement fluorescentBunText;
    @FindBy(how = How.XPATH, using = "//p[text()='Соус Spicy-X']")
    public SelenideElement spicySauceText;
    @FindBy(how = How.XPATH, using = "//p[text()='Мясо бессмертных моллюсков Protostomia']")
    public SelenideElement shellfishFillingText;

    @Step("Click constructor header button")
    public void constructorButtonClick() {
        constructorButton.click();
    }

    @Step("Click burger header logo")
    public void headerLogoClick() {
        headerLogo.click();
    }

    @Step("Click personal account header button")
    public void accountButtonClick() {
        personalAccountButton.click();
    }

    @Step("Click login button on the main page")
    public void loginButtonClick() {
        loginButton.click();
    }

    @Step("Click buns button on the menu")
    public void bunsMenuButtonClick() {
        bunsMenuButton.shouldHave(visible, Duration.ofSeconds(20));
        bunsMenuButton.shouldBe(enabled).click();
    }

    @Step("Click sauces button on the menu")
    public void saucesMenuButtonClick() {
        saucesMenuButton.shouldHave(visible, Duration.ofSeconds(20));
        saucesMenuButton.shouldBe(enabled).click();
    }

    @Step("Click fillings  button on the menu")
    public void fillingsMenuButtonClick() {
        fillingsMenuButton.shouldHave(visible, Duration.ofSeconds(20));
        fillingsMenuButton.shouldBe(enabled).click();
    }
}