package praktikum.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPageElements {
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    public SelenideElement rememberedPasswordLink;
}
