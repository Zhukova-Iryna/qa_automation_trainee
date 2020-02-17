import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class AuthenticationTest extends BaseTest {
    MainPage mainPage;
    String baseUrl;
    String email;
    String password;
    String empty = "";
    String searchRequest;

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
        searchRequest = properties.getProperty("searchrequest");
        driver.get(baseUrl);
        mainPage = new MainPage(driver);
    }


    @Test
    public void checkPositiveLoginScenario() {
        mainPage.openLoginForm();
        mainPage.enterLogin(email);
        mainPage.enterPassword(password);
        mainPage.submit();
        Assert.assertNotEquals(mainPage.getAccountName(), "Вход", "login unsuccessful");
    }

    @Test
    public void checkNegativeLoginScenario() {
        mainPage.openLoginForm();
        mainPage.enterLogin(empty);
        mainPage.enterPassword(password);
        mainPage.submit();
        Assert.assertTrue(mainPage.checkErrorLoginMessageAppears(), "Error message doesn't appears");
    }

    @Test
    public void searchStartsTest() {
        mainPage.runSearch(searchRequest);
        Assert.assertTrue(driver.getTitle().contains("Поиск"), "Search failed");
    }

    @Test
    public void relevantSearchTest(){
        mainPage.runSearch(searchRequest);
        List<WebElement> elements = driver.findElements(By.xpath(".//div[contains(@class,'ga_container')]"));
        System.out.println(elements.size());
        int counter = 0;
        for (WebElement we: elements) {
            if(we.getText().contains("Samsung A50")) {
                counter++;
            }
        }
        System.out.println(counter);
        Assert.assertTrue(counter > 0 );
    }
}