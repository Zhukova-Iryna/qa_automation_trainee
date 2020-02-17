import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "auth-user-block")
    WebElement loginLink;

    @FindBy(id = "header-user-link")
    WebElement userAccount;

    @FindBy(id = "SearchForm_searchPhrase")
    WebElement searchField;

    @FindBy(id = "LoginForm_username")
    WebElement emailField;

    @FindBy(id = "login_user_password")
    WebElement passwordField;

    @FindBy(xpath = ".//div[contains(@class,'pt_20')]")
    WebElement submitLogin;

    @FindBy(id = "go-tab-recovery")
    WebElement recoveryPasswordLink;

    @FindBy(id = "go-tab-userregister")
    WebElement registrationTab;

    @FindBy(id = "LoginForm_username")
    WebElement loginField;

    @FindBy(id = "login_user_password")
   WebElement passField;

    @FindBy(xpath = ".//div[contains(@class,'pt_20')]")
    WebElement submitButton;

    @FindBy(xpath = ".//div[@class='error-text']")
    WebElement errorLabel;

    @FindBy(id = "RegisterUserFirmForm_user_email")
    WebElement regEmailField;

    @FindBy(id = "user_user_password")
    WebElement regPasswordField;

    @FindBy(xpath = "//div[contains(@class,'mt_10')]")
    WebElement submitRegistration;

    @FindBy(id = "SearchForm_searchPhrase")
    WebElement searchInput;

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
    }

    //enter email text
    public void enterLogin(String email) {
        enterTextInTextField(loginField, email);
    }

    // enter password
    public void enterPassword(String password) {
        enterTextInTextField(passField, password);
    }

    // click Submit Button
    public void submit() {
        clickWebElement(submitButton);
    }

    //get title from login button
    public String getAccountName() {
        new Utils(driver).waitWhenAppearElem(loginLink);
        return userAccount.getText();
    }

    //check is error message appears
    public boolean checkErrorLoginMessageAppears() {
        return errorLabel.isDisplayed();
    }

    //fill search field and open search result page
    public void runSearch(String searchRequest) {
        searchInput.sendKeys(searchRequest + Keys.ENTER);
    }

}