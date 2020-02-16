import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "auth-user-block")
    WebElement loginLink;

    @FindBy(id = "SearchForm_searchPhrase")
    WebElement searchField;

    @FindBy(id = "LoginForm_username")
    WebElement emailField;

    @FindBy(id = "login_user_password")
    WebElement passwordField;

    @FindBy(xpath = "//div[contains(@class,'pt_20')]")
    WebElement submitLogin;

    @FindBy(id = "go-tab-recovery")
    WebElement recoveryPasswordLink;

    @FindBy(id = "go-tab-userregister")
    WebElement registrationTab;

    @FindBy(id = "LoginForm_username")
    WebElement loginField;

    @FindBy(id = "login_user_password")
    WebElement passField;

    @FindBy(xpath = "//div[contains(@class,'pt_20')]")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='right-block-inputs']//div[1]//div[1]")
    WebElement errorLabel;

    @FindBy(id = "RegisterUserFirmForm_user_email")
    WebElement regEmailField;

    @FindBy(id = "user_user_password")
    WebElement regPasswordField;

    @FindBy(xpath = "//div[contains(@class,'mt_10')]")
    WebElement submitRegistration;

    @FindBy(xpath = "//div[@class='form-wrap clearer-block']//span[@class^='soc-btn-facebook ga_user_login_page_social_click'][contains(text(),'facebook')]")
    WebElement authByFacebook;

    @FindBy(xpath = "//div[@class='form-wrap clearer-block']//span[@class='soc-btn-twitter ga_user_login_page_social_click'][contains(text(),'twitter')]")
    WebElement authByTwitter;

    @FindBy(xpath = "//div[@class='form-wrap clearer-block']//span[@class='soc-btn-google ga_user_login_page_social_click'][contains(text(),'google')]")
    WebElement authByGoogle;

    @FindBy(xpath = "//div[@class='form-content type-login']//a[@class='link-window-open ga_footer_agreement']")
    WebElement usersAgreementLink;

    @FindBy(xpath = "//div[@class='form-content type-login']//label")
    WebElement usersAgreementAcceptedCheckbox;

    @FindBy(xpath = "//div[@class='right-block-inputs']//div[1]//div[1]")
    WebElement blankEmailFieldMessage;

    @FindBy(xpath = "//div[@id='tab-login']//div[@class='right-block-inputs']//div[2]//div[1]")
    WebElement blankPasswordFieldMessage;

    @FindBy(xpath = "//div[@class='right-block-inputs']//div[2]//div[1]")
    WebElement blankRegEmailFieldMessage;

    @FindBy(xpath = "//div[@class='right-block-inputs']//div[3]//div[1]")
    WebElement blankRegPasswordFieldMessage;

    @FindBy(xpath = "//button[@class='ui-button ui-corner-all ui-widget ui-button-icon-only ui-dialog-titlebar-close ga_user_login_popup_close ga_register_user_popup_close']")
    WebElement closeFormButton;

    public MainPage(WebDriver driver){
        super(driver);
    }

    //open login form
    public void openLoginForm() {
        loginLink.click();
    }

    //switch to registration tab
    public void switchToRegistration() {
        //new Utils(driver).waitWhenAppearElem(registrationTab);
        registrationTab.click();
        //return this;
    }

    //enter email text
    public void enterLogin(String email) {
        enterTextInTextField(loginField, email);
    }
    // Enter password
    public void enterPassword(String password) {
        enterTextInTextField(passField, password);
    }

    // Click Submit Button
    public void submit() {
        clickWebElement(submitButton);
    }

    public String getAccountName() {
        return loginLink.getText();
    }





}
