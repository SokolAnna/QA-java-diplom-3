import praktikum.MainClient;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.pageObject.MainPageElements;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

import java.lang.*;
import java.time.Duration;

public class ConstructorTest {
    MainPageElements mainOpen;
    MainPageElements mainPage;

    @Before
    public void setUp() {
        System.setProperty("selenide.browser", "Chrome");
        Configuration.pageLoadTimeout = 45000;

        mainOpen = open(MainClient.BASE_URL, MainPageElements.class);
        mainPage = page(MainPageElements.class);
    }

    @Test
    @DisplayName("Fillings jump from buns success")
    @Description("Click fillings tub")
    public void fillingsJumpFromBunsSuccess() {
        mainOpen.fillingsNoSelectMenuButton.shouldBe(enabled).click();

        mainPage.fillingsSelectMenuButton.shouldBe(visible);
        mainPage.ingredients.shouldBe(visible);
    }

    @Test
    @DisplayName("Fillings jump from sauces success")
    @Description("Click sauces tub, click fillings tub")
    public void fillingsJumpFromSaucesSuccess() {
        mainOpen.saucesNoSelectMenuButton.click();
        mainPage.fillingsNoSelectMenuButton.shouldBe(enabled).click();

        mainPage.fillingsSelectMenuButton.shouldBe(visible);
        mainPage.ingredients.shouldBe(visible);
    }

    @Test
    @DisplayName("Sauces jump from buns success")
    @Description("Click sauces tub")
    public void saucesJumpFromBunsSuccess() {
        mainOpen.saucesNoSelectMenuButton.shouldBe(enabled).click();

        mainPage.saucesSelectMenuButton.shouldBe(visible);
        mainPage.ingredients.shouldBe(visible);
    }

    @Test
    @DisplayName("Sauces jump from fillings success")
    @Description("Click fillings tub, click sauces tub")
    public void saucesJumpFromFillingsSuccess() {
        mainOpen.fillingsNoSelectMenuButton.click();
        mainPage.saucesNoSelectMenuButton.shouldBe(enabled).click();

        mainPage.saucesSelectMenuButton.shouldBe(visible);
        mainPage.ingredients.shouldBe(visible);
    }

    @Test
    @DisplayName("Buns jump from fillings success")
    @Description("Click fillings tub, click buns tub")
    public void bunsJumpFromFillingsSuccess() {
        mainOpen.fillingsNoSelectMenuButton.click();
        Configuration.pageLoadTimeout = 45000;
        mainPage.bunsNoSelectMenuButton.should(visible, Duration.ofSeconds(1000));
        mainPage.bunsNoSelectMenuButton.shouldBe(enabled).click();

        mainPage.bunsSelectMenuButton.shouldBe(visible);
        mainPage.ingredients.shouldBe(visible);
    }

    @Test
    @DisplayName("Buns jump from sauces success")
    @Description("Click sauces tub, click buns tub")
    public void bunsJumpFromSaucesSuccess() {
        mainOpen.saucesNoSelectMenuButton.click();
        Configuration.pageLoadTimeout = 45000;
        mainPage.bunsNoSelectMenuButton.should(visible, Duration.ofSeconds(5000));
        mainPage.bunsNoSelectMenuButton.shouldBe(enabled).click();

        mainPage.bunsSelectMenuButton.shouldBe(visible);
        mainPage.ingredients.shouldBe(visible);
    }
}