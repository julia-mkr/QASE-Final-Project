package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ui.elements.NavigationTab;

public class NavigationMenuPage extends AppMenu {

    public NavigationMenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the 'Project' navigation tab")
    public ProjectsPage clickOnProjectNavigationTab() {
        new NavigationTab(driver, PROJECTS_NAV_LABEL).clickOnNavigationTab();
        return new ProjectsPage(driver);
    }

    @Step("Click on the 'Workspace' navigation tab")
    public WorkspacePage clickOnWorkspaceNavigationTab() {
        new NavigationTab(driver, WORKSPACE_NAV_LABEL).clickOnNavigationTab();
        return new WorkspacePage(driver);
    }
}
