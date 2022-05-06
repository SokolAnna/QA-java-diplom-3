import praktikum.MainClient;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.pageobject.MainPageElements;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

import java.lang.*;

public class ConstructorTest {
    MainPageElements mainOpen;
    MainPageElements mainPage;

    @Before
    public void setUp() {
        System.setProperty("selenide.browser", "Chrome");
        Configuration.pageLoadTimeout = 5000;

        mainOpen = open(MainClient.BASE_URL, MainPageElements.class);
        mainPage = page(MainPageElements.class);
    }

    @Test
    @DisplayName("Fillings jump from buns success")
    @Description("Click fillings tub")
    public void fillingsJumpFromBunsSuccess() {
        mainOpen.fillingsMenuButtonClick();

        mainPage.fillingsHeader.shouldBe(visible);
        mainPage.shellfishFillingText.shouldBe(visible);
    }

    @Test
    @DisplayName("Fillings jump from sauces success")
    @Description("Click sauces tub, click fillings tub")
    public void fillingsJumpFromSaucesSuccess() {
        mainOpen.saucesMenuButtonClick();
        mainPage.fillingsMenuButtonClick();

        mainPage.fillingsHeader.shouldBe(visible);
        mainPage.shellfishFillingText.shouldBe(visible);
    }

    @Test
    @DisplayName("Sauces jump from buns success")
    @Description("Click sauces tub")
    public void saucesJumpFromBunsSuccess() {
        mainOpen.saucesMenuButtonClick();

        mainPage.saucesHeader.shouldBe(visible);
        mainPage.spicySauceText.shouldBe(visible);
    }

    @Test
    @DisplayName("Sauces jump from fillings success")
    @Description("Click fillings tub, click sauces tub")
    public void saucesJumpFromFillingsSuccess() {
        mainOpen.fillingsMenuButtonClick();
        mainPage.saucesMenuButtonClick();

        mainPage.saucesHeader.shouldBe(visible);
        mainPage.spicySauceText.shouldBe(visible);
    }

    @Test
    @DisplayName("Buns jump from fillings success")
    @Description("Scroll to fillings, click buns tub")
    public void bunsJumpFromFillingsSuccess() {
        mainOpen.fillingsHeader.scrollIntoView(true);
        mainPage.bunsMenuButtonClick();

        mainPage.bunsHeader.shouldBe(visible);
        mainPage.fluorescentBunText.shouldBe(visible);
    }

    @Test
    @DisplayName("Buns jump from sauces success")
    @Description("Scroll to sauces, click buns tub")
    public void bunsJumpFromSaucesSuccess() {
        mainOpen.saucesHeader.scrollIntoView(true);
        mainPage.bunsMenuButtonClick();

        mainPage.bunsHeader.shouldBe(visible);
        mainPage.fluorescentBunText.shouldBe(visible);
    }
}