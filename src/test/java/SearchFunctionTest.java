import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchFunctionTest {
    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/properties/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://price.ua/");
        driver.manage().window().maximize();
        driver.findElement(By.id("SearchForm_searchPhrase")).sendKeys("Samsung A50" + Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.xpath("//div[starts-with(@class, 'product-block type2 ga_container')]"));
        System.out.println(elements.size());
        int counter = 0;
        for (WebElement we: elements) {
            if(we.getText().contains("Samsung A50")) {
                counter++;
            }
        }
        System.out.println(counter);
        Assert.assertTrue(counter > 0 );

        driver.quit();//div[@class='tab-head-item ga_user_login_popup_registration_click active']
    }
}
