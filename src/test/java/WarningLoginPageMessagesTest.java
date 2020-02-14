import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WarningLoginPageMessagesTest {
    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/properties/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://price.ua/");
        driver.manage().window().maximize();
        //driver.findElement(mainPage.).click();
        driver.findElement(By.id("go-tab-userregister")).click();
        //Actions clicker = new Actions(driver);
        //clicker.moveByOffset(800, 210).click().perform();
        mainPage.openAuthForm();
        driver.findElement(By.xpath("//div[contains(@class,'mt_10')]")).click();


        String blankEmailMessage = driver.findElement(By.xpath("//div[@class='right-block-inputs']//div[2]//div[1]")).getText();
        String blankPasswordMessage = driver.findElement(By.xpath("//div[@class='right-block-inputs']//div[3]//div[1]")).getText();
        Assert.assertTrue(blankPasswordMessage.contains("Необходимо заполнить поле «Пароль»."));
        Assert.assertTrue(blankEmailMessage.contains("Необходимо заполнить поле «Адрес электронной почты»."));
        System.out.println(blankPasswordMessage);
        //driver.quit();
    }
}
