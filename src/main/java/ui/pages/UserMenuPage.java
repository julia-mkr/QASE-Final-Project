package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.*;
import ui.utils.Waiters;

public class UserMenuPage extends AppMenu {

    public UserMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-menu")
    private WebElement userMenuBtn;

    public UserMenuPage clickOnUserMenuButton() {
        Waiters.waitForElementLocated(driver, userMenuBtn, 5);
        userMenuBtn.click();
        return this;
    }

    public LoginPage signOut() {
        clickOnUserMenuButton();
        new UserMenuDropdown(driver, SIGN_OUT_USER_MENU_OPTION).clickOnOption();
        return new LoginPage(driver);
    }
}
