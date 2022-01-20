package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ui.elements.SubMenu;

public class WorkspacePage extends NavigationMenuPage {

    public WorkspacePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the 'Invites' submenu tab")
    public InvitesPage clickOnInvitesSubMenuTab() {
        new SubMenu(driver, INVITES_SUB_MENU_LABEL).clickOnSubMenuOption();
        return new InvitesPage(driver);
    }

    @Step("Click on the 'Groups' submenu tab")
    public UserGroupsPage clickOnGroupsSubMenuTab() {
        new SubMenu(driver, GROUPS_SUB_MENU_LABEL).clickOnSubMenuOption();
        return new UserGroupsPage(driver);
    }
}
