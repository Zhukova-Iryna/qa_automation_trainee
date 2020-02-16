import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterUserTest {

    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/properties/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://price.ua/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[contains(@class,'link for-login')]")).click();
        driver.findElement(By.id("go-tab-userregister")).click();
        driver.findElement(By.id("RegisterUserFirmForm_user_email")).sendKeys("user1user2@gmail.com");
        //driver.findElement(By.id("user_user_password")
        driver.findElement(By.xpath("//div[contains(@class,'mt_10')]")).click();

        //WebElement registration = driver.findElement(By.linkText("Регистрация"));
        //registration.click();user_user_password
        //driver.findElement(By.xpath(".//div[contains(@class,'tab-head-item')]")).click();
        //driver.findElement(By.xpath("//div[@class='tab-head-item ga_user_login_popup_registration_click active']")).click();

        //String blankEmailMessage = driver.findElement(By.xpath("//div[@class='right-block-inputs']//div[2]//div[1]")).getText();
        String blankPasswordMessage = driver.findElement(By.xpath("//div[@class='right-block-inputs']//div[3]//div[1]")).getText();
        Assert.assertTrue(blankPasswordMessage.contains("Необходимо заполнить поле «Пароль»."));
        //Assert.assertTrue(blankEmailMessage.contains("Необходимо заполнить поле «Адрес электронной почты»."));
        //System.out.println(blankPasswordMessage);
        driver.quit();
    }
}
