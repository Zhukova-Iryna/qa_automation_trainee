import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AuthenticationTest extends BaseTest {
    MainPage mainPage;
    String baseUrl;
    String email;
    String password;

    @BeforeClass
    public void setUp() {

        String commonProperties = "src/main/resources/test-properties.properties";
        Properties properties = new Properties();

        if (commonProperties != null) {
            try {
                properties.load(new FileReader(commonProperties));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        baseUrl = properties.getProperty("baseurl");
        email = properties.getProperty("validemail");
        password = properties.getProperty("validpassword");
        driver.get(baseUrl);
        mainPage = new MainPage(driver);
    }


    @Test
    public void checkPositiveLoginScenario() {
        mainPage.openLoginForm();
        mainPage.enterLogin(email);
        mainPage.enterPassword(password);
        mainPage.submit();
        String accountName = mainPage.getAccountName();
        Assert.assertNotEquals(accountName, "Вход");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
