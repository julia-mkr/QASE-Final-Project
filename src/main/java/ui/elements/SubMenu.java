package ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubMenu {

    WebDriver driver;
    String subMenuLabel;

    public SubMenu(WebDriver driver, String subMenuLabel) {
        this.driver = driver;
        this.subMenuLabel = subMenuLabel;
    }

    private static final String SUB_MENU_ITEM = "//*[text()='%s' and contains(@class, 'submenu-item')]";

    public void clickOnSubMenuOption() {
        driver.findElement(By.xpath(String.format(SUB_MENU_ITEM, subMenuLabel))).click();
    }
}
