package praktikum.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

    @FindBy(how = How.XPATH, using = "//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    public SelenideElement bunsNoSelectMenuButton;
    @FindBy(how = How.XPATH, using = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    public SelenideElement bunsSelectMenuButton;
    @FindBy(how = How.XPATH, using = "//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    public SelenideElement saucesNoSelectMenuButton;
    @FindBy(how = How.XPATH, using = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    public SelenideElement saucesSelectMenuButton;
    @FindBy(how = How.XPATH, using = "//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    public SelenideElement fillingsNoSelectMenuButton;
    @FindBy(how = How.XPATH, using = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    public SelenideElement fillingsSelectMenuButton;

    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    public SelenideElement fillingsHeader;

    @FindBy(how = How.XPATH, using = "//a[@class='BurgerIngredient_ingredient__1TVf6 ml-4 mr-4 mb-8']/p[text()='Флюоресцентная булка R2-D3']")
    public SelenideElement fluorescentBunText;
    @FindBy(how = How.XPATH, using = "//a[@class='BurgerIngredient_ingredient__1TVf6 ml-4 mr-4 mb-8']/p[text()='Соус Spicy-X']")
    public SelenideElement spicySauceText;
    @FindBy(how = How.XPATH, using = "//a[@class='BurgerIngredient_ingredient__1TVf6 ml-4 mr-4 mb-8']/p[text()='Мясо бессмертных моллюсков Protostomia']")
    public SelenideElement shellfishFillingText;
    @FindBy(how = How.XPATH, using = "//div[@class='Modal_modal__contentBox__sCy8X pt-10 pb-15']/p[text()='Мясо бессмертных моллюсков Protostomia']")
    public SelenideElement shellfishFillingDetails;

}
