package ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMenuDropdown {

    WebDriver driver;
    String userMenuOption;

    public UserMenuDropdown(WebDriver driver, String userMenuOption) {
        this.driver = driver;
        this.userMenuOption = userMenuOption;
    }

    private static final String MENU_OPTION = "//*[@class='user-menu-item']//*[contains(text(), '%s')]";

    public void clickOnOption() {
        driver.findElement(By.xpath(String.format(MENU_OPTION, userMenuOption))).click();
    }
}
