package ui.pages;

import org.openqa.selenium.WebDriver;
import ui.elements.NavigationTab;

public class NavigationMenuPage extends AppMenu {

    public NavigationMenuPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage clickOnProjectNavigationTab() {
        new NavigationTab(driver, PROJECTS_NAV_LABEL).clickOnNavigationTab();
        return new ProjectsPage(driver);
    }
}
