import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils {
    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitWhenAppearElem(WebElement element) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.textToBePresentInElement(element, "bu9ira"));
    }
}