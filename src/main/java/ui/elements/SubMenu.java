package ui.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SubMenu {

    WebDriver driver;
    String subMenuLabel;

    public SubMenu(WebDriver driver, String subMenuLabel) {
        this.driver = driver;
        this.subMenuLabel = subMenuLabel;
    }

    private static final String SUB_MENU_ITEM = "//*[text()='%s' and contains(@class, 'submenu-item')]";

    public void clickOnSubMenuOption() {
        log.info(String.format("Clicking on the '%s' submenu tab", subMenuLabel));
        driver.findElement(By.xpath(String.format(SUB_MENU_ITEM, subMenuLabel))).click();
    }
}
