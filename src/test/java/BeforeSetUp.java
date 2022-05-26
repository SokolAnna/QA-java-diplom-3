import com.codeborne.selenide.Configuration;
import org.junit.Before;

public class BeforeSetUp {

    @Before
    public void setUpClass() {
        Configuration.browserSize = "1920x1080";
        System.setProperty("selenide.browser", "Chrome");
        Configuration.pageLoadTimeout = 45000;
    }
}