package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.DefectTestData;

public class DefectTests extends BaseTest implements DefectTestData {

    @Test(groups = {"Smoke"}, description = "The test creates a new defect filling in the required fields")
    @Description("Creation of a new defect report with filling in the required fields")
    public void createDefectFillingInRequiredFieldsTest() {
        projectRepositorySteps.loginAndClickOnProject(driver,EMAIL, PASSWORD, PROJECT_TITLE)
                .clickOnDefectsSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFields(DATA_FOR_TEST_DEFECT_1)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_1.getDefectTitle());
        Assert.assertTrue(verificationUtils.verifyDefectInputAndTextFields(DATA_FOR_TEST_DEFECT_1));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new defect filling in all the fields and selecting value " +
            "options from dropdown menus")
    @Description("Creation of a new defect report with filling in all the fields and selecting values from the 'Milestones', " +
            "'Severity', and 'Assignee' dropdowns")
    public void createDefectFillingInAllFieldsTest() {
        projectRepositorySteps.loginAndClickOnProject(driver,EMAIL, PASSWORD, PROJECT_TITLE)
                .clickOnDefectsSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInAllFields(DATA_FOR_TEST_DEFECT_2)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_2.getDefectTitle());
        Assert.assertTrue(verificationUtils.verifyDefectAllFieldsAndDropDownOptions(DATA_FOR_TEST_DEFECT_2));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new defect filling in the required fields and attaching a file" +
            "to it")
    @Description("Creation of a new defect report with filling in the required fields and attaching a file to it")
    public void createDefectFillingInRequiredFieldsAndAttachingFileTest() {
        projectRepositorySteps.loginAndClickOnProject(driver,EMAIL, PASSWORD, PROJECT_TITLE)
                .clickOnDefectsSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFieldsAndAttachingFile(DATA_FOR_TEST_DEFECT_3, ATTACHING_FILE)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_3.getDefectTitle());
        Assert.assertTrue(verificationUtils.verifyDefectInputAndTextFields(DATA_FOR_TEST_DEFECT_3));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new defect and resolves it")
    @Description("Resolving of the defect")
    public void resolveCreatedDefectTest() {
        projectRepositorySteps.loginAndClickOnProject(driver,EMAIL, PASSWORD, PROJECT_TITLE)
                .clickOnDefectsSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFieldsAndSelectingSeverity(DATA_FOR_TEST_DEFECT_4)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_4.getDefectTitle());
        defectPage.resolveDefect();
        Assert.assertEquals(defectPage.getDefectStatus(), RESOLVED_DEFECT_STATUS);
    }
}
