import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticPage extends BasePage {

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

    public AuthenticPage(WebDriver driver) {
        super(driver);
    }

    //switch to registration
    private AuthenticPage switchToRegistration() {
        registrationTab.click();
        return this;
    }

    //fill email field
    public AuthenticPage enterEmail(String email, String tab) {
        switch (tab) {
            case "login":
                emailField.sendKeys(email);
                break;
            case "registration":
                switchToRegistration();
                regEmailField.sendKeys(email);
                break;
        }
        return this;
    }

    //fill password field
    public AuthenticPage enterPassword(String password, String tab) {
        switch (tab) {
            case "login":
                passwordField.sendKeys(password);
                break;
            case "registration":
                switchToRegistration();
                regPasswordField.sendKeys(password);
                break;
        }
        return this;
    }

    //get error message for blank email field
    public String getEmailErrorMsg(String tab) {
        String message;
        switch (tab) {
            case "login":
                message = blankEmailFieldMessage.getText();
                break;
            case "registration":
                switchToRegistration();
                message = blankRegEmailFieldMessage.getText();
                break;
            default: message = "No such messages";
        }
        return message;
    }

    //get error message for blank password field
    public String getPasswordErrorMsg(String tab) {
        String message;
        switch (tab) {
            case "login":
                message = blankPasswordFieldMessage.getText();
                break;
            case "registration":
                switchToRegistration();
                message = blankRegPasswordFieldMessage.getText();
                break;
            default: message = "No such messages";
        }
        return message;
    }

}
