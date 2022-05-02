package praktikum.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePageElements {
    @FindBy(how = How.XPATH, using = "//a[@class='AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo']/p[text()='Личный Кабинет']")
    public SelenideElement personalAccountPageButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Профиль']")
    public SelenideElement profileText;
    @FindBy(how = How.XPATH, using = "//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    public SelenideElement descriptionText;

    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    public SelenideElement logoutButton;
}