package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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

    @Step("Log in using the email: '{email}' and the password: '{password}'")
    public ProjectsPage login(String email, String password) {
        openUrl(LOGIN_URL);
        log.info("Typing the email: " + email + " into the 'Email' field");
        emailField.sendKeys(email);
        log.info("Typing the password: " + password + " into the 'Password' field");
        passwordField.sendKeys(password);
        clickOnLoginButton();
        return new ProjectsPage(driver);
    }

    @Step("Click on the 'Login' button")
    public void clickOnLoginButton() {
        log.info("Clicking on the 'Login' button");
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
