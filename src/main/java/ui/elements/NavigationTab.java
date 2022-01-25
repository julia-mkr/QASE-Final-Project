package ui.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NavigationTab {

    WebDriver driver;
    String navLabel;

    public NavigationTab(WebDriver driver, String navLabel) {
        this.driver = driver;
        this.navLabel = navLabel;
    }

    private static final String TAB_NAVIGATION = "//*[@class='nav-link-title' and contains(text(), '%s')]";

    public void clickOnNavigationTab() {
        log.info(String.format("Clicking on the '%s' tab on the navigation menu", navLabel));
        driver.findElement(By.xpath(String.format(TAB_NAVIGATION, navLabel))).click();
    }
}
