package ui.pages;

import org.openqa.selenium.WebDriver;
import ui.elements.SubMenu;

public class WorkspacePage extends NavigationMenuPage {

    public WorkspacePage(WebDriver driver) {
        super(driver);
    }

    public InvitesPage clickOnInvitesSubMenuTab() {
        new SubMenu(driver, INVITES_SUB_MENU_LABEL).clickOnSubMenuOption();
        return new InvitesPage(driver);
    }

    public UserGroupsPage clickOnGroupsSubMenuTab() {
        new SubMenu(driver, GROUPS_SUB_MENU_LABEL).clickOnSubMenuOption();
        return new UserGroupsPage(driver);
    }
}
