import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginUserTest {

    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/properties/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://price.ua/");
        driver.manage().window().maximize();
        driver.findElement(By.id("auth-user-block")).click();
        driver.findElement(By.id("LoginForm_username")).sendKeys("bu9ira@gmail.com");
        driver.findElement(By.xpath("//div[contains(@class,'pt_20')]")).click();
        String blankPasswordMessage = driver.findElement(By.xpath("//div[contains(text(),'».')]")).getText();
        Assert.assertTrue(blankPasswordMessage.contains("Необходимо заполнить поле «Пароль»."));
        System.out.println(blankPasswordMessage);
        driver.quit();
    }
}
