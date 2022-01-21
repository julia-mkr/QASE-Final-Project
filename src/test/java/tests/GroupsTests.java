package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.GroupTestData;

public class GroupsTests extends BaseTest implements GroupTestData {

    @Test(groups = {"Smoke"}, description = "The test creates a new group")
    @Description("Creation of a new group with filling in all the required fields")
    public void createGroupTest() {
        loginPage.login(EMAIL, PASSWORD);
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnGroupsSubMenuTab()
                .clickOnCreateNewGroupButton()
                .createGroupFillingInAllFields(GROUP_TITLE_FOR_TEST_1, GROUP_DESCRIPTION_FOR_TEST_1);
        Assert.assertTrue(userGroupsPage.isGroupTitleDisplayed(GROUP_TITLE_FOR_TEST_1));
        Assert.assertTrue(userGroupsPage.isGroupDescriptionDisplayed(GROUP_DESCRIPTION_FOR_TEST_1));
    }

    @Test(groups = {"Critical"}, description = "The test creates a new group without filling in the required 'Description' field")
    @Description("Creation of a new group with filling in all the fields, except the required 'Description' field")
    public void createGroupWithoutFillingInDescriptionFieldTest() {
        loginPage.login(EMAIL, PASSWORD);
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnGroupsSubMenuTab()
                .clickOnCreateNewGroupButton()
                .createGroupFillingInOneOfRequiredFields(GROUP_TITLE_FOR_TEST_2, EMPTY_GROUP_DESCRIPTION_FOR_TEST_2);
        Assert.assertEquals(createGroupPage.getEmptyDescriptionFieldErrorMessage(), EMPTY_DESCRIPTION_FIELD_ERROR);
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new group and add a team member to it")
    @Description("Addition of a team member to the created group")
    public void addMemberToCreatedGroupTest() {
        loginPage.login(EMAIL, PASSWORD);
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnGroupsSubMenuTab()
                .clickOnCreateNewGroupButton()
                .createGroupFillingInAllFields(GROUP_TITLE_FOR_TEST_3, GROUP_DESCRIPTION_FOR_TEST_3)
                .clickOnGroupTitle(GROUP_TITLE_FOR_TEST_3)
                .clickOnAddMemberButton()
                .addMemberToGroup(MEMBER_NAME);
        Assert.assertTrue(groupPage.isAddedMemberNameDisplayed(MEMBER_NAME));
    }
}
