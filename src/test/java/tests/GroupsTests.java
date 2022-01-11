package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.GroupTestData;
import ui.utils.PropertyReader;

public class GroupsTests extends BaseTest implements GroupTestData {

    @Test
    public void createGroupTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnGroupsSubMenuTab()
                .clickOnCreateNewGroupButton()
                .createGroupFillingInAllFields(GROUP_TITLE_FOR_TEST_1, GROUP_DESCRIPTION_FOR_TEST_1);
        Assert.assertTrue(userGroupsPage.isGroupTitleDisplayed(GROUP_TITLE_FOR_TEST_1));
        Assert.assertTrue(userGroupsPage.isGroupDescriptionDisplayed(GROUP_DESCRIPTION_FOR_TEST_1));
    }

    @Test
    public void createGroupWithoutFillingInDescriptionFieldTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnGroupsSubMenuTab()
                .clickOnCreateNewGroupButton()
                .createGroupFillingInOneOfRequiredFields(GROUP_TITLE_FOR_TEST_2, "");
        Assert.assertEquals(createGroupPage.getEmptyDescriptionFieldErrorMessage(), EMPTY_DESCRIPTION_FIELD_ERROR);
    }

    @Test
    public void addMemberToCreatedGroupTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnGroupsSubMenuTab()
                .clickOnCreateNewGroupButton()
                .createGroupFillingInAllFields(GROUP_TITLE_FOR_TEST_3, GROUP_DESCRIPTION_FOR_TEST_3)
                .clickOnGroupTitle(GROUP_TITLE_FOR_TEST_3)
                .clickOnAddMemberButton()
                .addMemberToGroup("Kate");
        Assert.assertTrue(groupPage.isAddedMemberNameDisplayed("Kate"));
    }
}
