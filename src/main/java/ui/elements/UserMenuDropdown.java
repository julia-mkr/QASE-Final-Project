package ui.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utils.Waiters;

@Log4j2
public class UserMenuDropdown {

    WebDriver driver;
    String userMenuOption;

    public UserMenuDropdown(WebDriver driver, String userMenuOption) {
        this.driver = driver;
        this.userMenuOption = userMenuOption;
    }

    private static final String MENU_OPTION = "//*[@class='user-menu-item']//*[contains(text(), '%s')]";

    public void clickOnOption() {
        Waiters.waitForElementBecomesVisible(driver, By.xpath(String.format(MENU_OPTION, userMenuOption)), 10);
        log.info(String.format("Clicking on the '%s' option", userMenuOption));
        driver.findElement(By.xpath(String.format(MENU_OPTION, userMenuOption))).click();
    }
}
