package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
//https://naveenautomationlabs.com/opencart/index.php?route=account/login
    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id="input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "(//a[text()='Forgotten Password'])[1]")
    private WebElement forgetPasswordLink;

    public LoginPage(WebDriver driver, WebElement emailInput, WebElement passwordInput, WebElement loginButton, WebElement forgetPasswordLink) {
        this.driver = driver;
        this.emailInput = emailInput;
        this.passwordInput = passwordInput;
        this.loginButton = loginButton;
        this.forgetPasswordLink = forgetPasswordLink;
        PageFactory.initElements(driver, this);
    }

    public LoginPage(WebDriver driver) {
    }

    public void enterEmail(){
        emailInput.sendKeys("test@ui.com");
    }
    public void enterPassword(){
        passwordInput.sendKeys("test123");
    }
    public void clickLoginButton(){
        loginButton.click();
    }

    public AccountPage login(){
        enterEmail();
        enterPassword();
        clickLoginButton();
        return new AccountPage(this.driver);
    }
}
