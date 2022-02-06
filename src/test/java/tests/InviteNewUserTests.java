package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.InvitesTestData;

public class InviteNewUserTests extends BaseTest implements InvitesTestData {

    @Test(groups = {"Smoke"}, description = "The test creates an invitation of a new team member")
    @Description("Creation of an invitation for a new team member")
    public void createInvitationOfNewUserTest() {
        loginPage.login(EMAIL, PASSWORD);
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnInvitesSubMenuTab()
                .clickOnInviteNewMemberButton()
                .inviteNewUserFillingInAllInputFields(DATA_FOR_INVITATION_OF_NEW_USER_1);
        Assert.assertTrue(verificationUtils.verifyNewUserInvitation(DATA_FOR_INVITATION_OF_NEW_USER_1));
    }

    @Test(groups = {"Critical"}, description = "The test creates an invitation of a new team member without filling in the required input fields")
    @Description("Creation of an invitation for a new team member without filling in the required fields: 'Email' and 'Role title'")
    public void createInvitationOfNewUserWithoutFillingInRequiredInputFieldsTest() {
        loginPage.login(EMAIL, PASSWORD);
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnInvitesSubMenuTab()
                .clickOnInviteNewMemberButton()
                .inviteNewUserUsingInvalidData(DATA_FOR_INVITATION_OF_NEW_USER_2);
        Assert.assertEquals(inviteNewUserModalPage.getEmptyEmailErrorMessage(), EXPECTED_EMPTY_EMAIL_ERROR);
        Assert.assertEquals(inviteNewUserModalPage.getEmptyRoleTitleErrorMessage(), EXPECTED_EMPTY_ROLE_TITLE_ERROR);
    }

    @Test(groups = {"Critical"}, description = "The test creates an invitation of a new team member entering an invalid email")
    @Description("Creation of an invitation for a new team member, that fills in all the fields, but enters an invalid email")
    public void createInvitationOfNewUserUsingInvalidEmailTest() {
        loginPage.login(EMAIL, PASSWORD);
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnInvitesSubMenuTab()
                .clickOnInviteNewMemberButton()
                .inviteNewUserUsingInvalidData(DATA_FOR_INVITATION_OF_NEW_USER_3);
        Assert.assertEquals(inviteNewUserModalPage.getInvalidEmailErrorMessage(), EXPECTED_INVALID_EMAIL_ERROR);
    }
}
