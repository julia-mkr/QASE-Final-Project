package ui.utils;

import org.openqa.selenium.WebDriver;
import ui.objects.*;
import ui.pages.CreateTestCasePage;
import ui.pages.DefectPage;
import ui.pages.MilestonesPage;

public class VerificationUtils {

    public static boolean verifyTestCaseInputFieldsAndDropdownOptions(WebDriver driver, TestCase testCase) {
        boolean result = false;
        if (!testCase.getTitle().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getTitle());
        }
        if (!testCase.getPriority().isEmpty()) {
            result = CreateTestCasePage.isOptionDisplayed(driver, testCase.getPriority());
        }
        if (!testCase.getType().isEmpty()) {
            result = CreateTestCasePage.isOptionDisplayed(driver, testCase.getType());
        }
        if (!testCase.getLayer().isEmpty()) {
            result = CreateTestCasePage.isOptionDisplayed(driver, testCase.getLayer());
        }
        if (!testCase.getAutomationStatus().isEmpty()) {
            result = CreateTestCasePage.isOptionDisplayed(driver, testCase.getAutomationStatus());
        }
        return result;
    }

    public static boolean verifyTestCaseInputAndTextFields(WebDriver driver, TestCase testCase) {
        boolean result = false;
        if (!testCase.getTitle().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getTitle());
        }
        if (!testCase.getDescription().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getDescription());
        }
        if (!testCase.getPreConditions().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getPreConditions());
        }
        if (!testCase.getPostConditions().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getPostConditions());
        }
        if (!testCase.getAction().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getAction());
        }
        if (!testCase.getInputData().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getInputData());
        }
        if (!testCase.getExpectedResult().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getExpectedResult());
        }
        return result;
    }

    public static boolean verifyMilestoneInputAndTextFields(WebDriver driver, Milestone milestone) {
        boolean result = false;
        if (!milestone.getMilestoneName().isEmpty()) {
            result = MilestonesPage.isMilestoneTitleDisplayed(driver, milestone.getMilestoneName());
        }
        if (!milestone.getDescription().isEmpty()) {
            result = MilestonesPage.isMilestoneDescriptionDisplayed(driver);
        }
        return result;
    }

    public static boolean verifyDefectInputAndTextFields(WebDriver driver, Defect defect) {
        boolean result = false;
        if (!defect.getDefectTitle().isEmpty()) {
            result = DefectPage.isDefectTitleDisplayed(driver, defect.getDefectTitle());
        }
        if (!defect.getActualResult().isEmpty()) {
            result = DefectPage.isDescriptionTextDisplayed(driver, defect.getActualResult());
        }
        return result;
    }

    public static boolean verifyDefectAllFieldsAndDropDownOptions(WebDriver driver, Defect defect) {
        boolean result = false;
        if (!defect.getDefectTitle().isEmpty()) {
            result = DefectPage.isDefectTitleDisplayed(driver, defect.getDefectTitle());
        }
        if (!defect.getActualResult().isEmpty()) {
            result = DefectPage.isDescriptionTextDisplayed(driver, defect.getActualResult());
        }
        if (!defect.getMilestones().isEmpty()) {
            result = DefectPage.isOptionDisplayed(driver, defect.getMilestones());
        }
        if (!defect.getSeverity().isEmpty()) {
            result = DefectPage.isOptionDisplayed(driver, defect.getSeverity());
        }
        if (!defect.getAssignee().isEmpty()) {
            result = DefectPage.isAssigneeNameDisplayed(driver);
        }
        return result;
    }
}
