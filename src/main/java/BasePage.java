import org.openqa.selenium.WebDriver;

public class BasePage {
    private final int EXPLICITLY_WAIT_TIMEOUT = 10;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


}
