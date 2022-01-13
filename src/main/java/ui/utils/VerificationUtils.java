package ui.utils;

import org.openqa.selenium.WebDriver;
import ui.objects.*;
import ui.pages.*;

public class VerificationUtils {
    WebDriver driver;
    private CreateTestCasePage createTestCasePage;
    private DefectPage defectPage;

    public VerificationUtils(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyTestCaseInputFieldsAndDropdownOptions(TestCase testCase) {
        createTestCasePage = new CreateTestCasePage(driver);
        boolean result = false;
        if (!testCase.getTitle().isEmpty()) {
            result = createTestCasePage.isEnteredTextDisplayed(testCase.getTitle());
        }
        if (!testCase.getPriority().isEmpty()) {
            result &= createTestCasePage.isOptionDisplayed(testCase.getPriority());
        }
        if (!testCase.getType().isEmpty()) {
            result &= createTestCasePage.isOptionDisplayed(testCase.getType());
        }
        if (!testCase.getLayer().isEmpty()) {
            result &= createTestCasePage.isOptionDisplayed(testCase.getLayer());
        }
        if (!testCase.getAutomationStatus().isEmpty()) {
            result &= createTestCasePage.isOptionDisplayed(testCase.getAutomationStatus());
        }
        return result;
    }

    public boolean verifyTestCaseInputAndTextFields(TestCase testCase) {
        createTestCasePage = new CreateTestCasePage(driver);
        boolean result = false;
        if (!testCase.getTitle().isEmpty()) {
            result = createTestCasePage.isEnteredTextDisplayed(testCase.getTitle());
        }
        if (!testCase.getDescription().isEmpty()) {
            result &= createTestCasePage.isEnteredTextDisplayed(testCase.getDescription());
        }
        if (!testCase.getPreConditions().isEmpty()) {
            result &= createTestCasePage.isEnteredTextDisplayed(testCase.getPreConditions());
        }
        if (!testCase.getPostConditions().isEmpty()) {
            result &= createTestCasePage.isEnteredTextDisplayed(testCase.getPostConditions());
        }
        if (!testCase.getAction().isEmpty()) {
            result &= createTestCasePage.isEnteredTextDisplayed(testCase.getAction());
        }
        if (!testCase.getInputData().isEmpty()) {
            result &= createTestCasePage.isEnteredTextDisplayed(testCase.getInputData());
        }
        if (!testCase.getExpectedResult().isEmpty()) {
            result &= createTestCasePage.isEnteredTextDisplayed(testCase.getExpectedResult());
        }
        return result;
    }

    public boolean verifyMilestoneInputAndTextFields(Milestone milestone) {
        MilestonesPage milestonesPage = new MilestonesPage(driver);
        boolean result = false;
        if (!milestone.getMilestoneName().isEmpty()) {
            result = milestonesPage.isMilestoneTitleDisplayed(milestone.getMilestoneName());
        }
        if (!milestone.getDescription().isEmpty()) {
            result &= milestonesPage.isMilestoneDescriptionDisplayed();
        }
        return result;
    }

    public boolean verifyDefectInputAndTextFields(Defect defect) {
        defectPage = new DefectPage(driver);
        boolean result = false;
        if (!defect.getDefectTitle().isEmpty()) {
            result = defectPage.isDefectTitleDisplayed(defect.getDefectTitle());
        }
        if (!defect.getActualResult().isEmpty()) {
            result &= defectPage.isDescriptionTextDisplayed(defect.getActualResult());
        }
        return result;
    }

    public boolean verifyDefectAllFieldsAndDropDownOptions(Defect defect) {
        defectPage = new DefectPage(driver);
        boolean result = false;
        if (!defect.getDefectTitle().isEmpty()) {
            result = defectPage.isDefectTitleDisplayed(defect.getDefectTitle());
        }
        if (!defect.getActualResult().isEmpty()) {
            result &= defectPage.isDescriptionTextDisplayed(defect.getActualResult());
        }
        if (!defect.getMilestones().isEmpty()) {
            result &= defectPage.isOptionDisplayed(defect.getMilestones());
        }
        if (!defect.getSeverity().isEmpty()) {
            result &= defectPage.isOptionDisplayed(defect.getSeverity());
        }
        if (!defect.getAssignee().isEmpty()) {
            result &= defectPage.isAssigneeNameDisplayed();
        }
        return result;
    }

    public boolean verifyNewUserInvitation(InvitationOfNewUser invitationOfNewUser) {
        InvitesPage invitesPage = new InvitesPage(driver);
        boolean result = false;
        if (!invitationOfNewUser.getName().isEmpty()) {
            result = invitesPage.isMemberNameDisplayed(invitationOfNewUser.getName());
        }
        if (!invitationOfNewUser.getEmail().isEmpty()) {
            result &= invitesPage.isMemberEmailDisplayed(invitationOfNewUser.getEmail());
        }
        if (!invitationOfNewUser.getRoleTitle().isEmpty()) {
            result &= invitesPage.isMemberRoleTitleDisplayed(invitationOfNewUser.getRoleTitle());
        }
        return result;
    }
}
