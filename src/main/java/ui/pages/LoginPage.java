package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final String LOGIN_URL = "https://app.qase.io/login";

    @FindBy(id = "inputEmail")
    WebElement emailField;
    @FindBy(id = "inputPassword")
    WebElement passwordField;
    @FindBy(id = "btnLogin")
    WebElement loginButton;
    @FindBy(css = ".form-control-feedback")
    WebElement errorMessage;

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
}
