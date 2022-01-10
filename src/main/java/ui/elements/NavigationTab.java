package ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationTab {

    WebDriver driver;
    String navLabel;

    public NavigationTab(WebDriver driver, String navLabel) {
        this.driver = driver;
        this.navLabel = navLabel;
    }

    private static final String TAB_NAVIGATION = "//*[@class='nav-link-title' and contains(text(), '%s')]";

    public void clickOnNavigationTab() {
        driver.findElement(By.xpath(String.format(TAB_NAVIGATION, navLabel))).click();
    }
}
