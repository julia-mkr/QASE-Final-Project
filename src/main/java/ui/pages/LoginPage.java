package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputEmail")
    private WebElement emailField;
    @FindBy(id = "inputPassword")
    private WebElement passwordField;
    @FindBy(id = "btnLogin")
    private WebElement loginButton;
    @FindBy(css = ".form-control-feedback")
    private WebElement errorMessage;
    @FindBy(xpath = "//*[@class='logo']")
    private WebElement qaseLogo;

    public ProjectsPage login(String email, String password) {
        openUrl(LOGIN_URL);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        clickOnLoginButton();
        return new ProjectsPage(driver);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isQaseLogoDisplayed() {
        return qaseLogo.isDisplayed();
    }
}
