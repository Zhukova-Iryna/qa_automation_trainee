import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'link for-login')]")
    private WebElement loginLink;

    @FindBy(id = "SearchForm_searchPhrase")
    private WebElement searchField;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public AuthenticPage openAuthForm() {
        loginLink.click();
        return new AuthenticPage(driver);
    }

    public String getLoginText() {
        return loginLink.getText();
    }
}
