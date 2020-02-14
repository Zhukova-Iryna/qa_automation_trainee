import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthenticationTest extends BaseTest {
    WebDriver driver;
    MainPage mainPage;
    AuthenticPage authPage;

    @BeforeClass
    public void init() {
        driver = new ChromeDriver();

    }

    @BeforeMethod
    public void lunch() {
        //driver.get("https://price.ua/");
        mainPage = new MainPage(driver);
        mainPage.driver.get("https://price.ua/");
        authPage = mainPage.openAuthForm();
    }

    @Test
    public void checkPositiveLoginScenario(String email, String password) {
        driver.get("https://price.ua/");
        authPage.enterEmail(email, "login");
        authPage.enterPassword(password, "login");
        authPage.submitLogin.click();
        Assert.assertNotEquals(mainPage.getLoginText(), "Вход");
    }
}
