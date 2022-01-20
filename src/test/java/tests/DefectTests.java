package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.DefectTestData;

public class DefectTests extends BaseTest implements DefectTestData {

    @Test(groups = {"Smoke"}, description = "The test creates a new defect filling in the required fields")
    public void createDefectFillingInRequiredFieldsTest() {
        loginPage.login(EMAIL, PASSWORD)
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectsSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFields(DATA_FOR_TEST_DEFECT_1)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_1.getDefectTitle());
        Assert.assertTrue(verificationUtils.verifyDefectInputAndTextFields(DATA_FOR_TEST_DEFECT_1));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new defect filling in all the fields and selecting value " +
            "options from dropdown menus")
    public void createDefectFillingInAllFieldsTest() {
        loginPage.login(EMAIL, PASSWORD)
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectsSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInAllFields(DATA_FOR_TEST_DEFECT_2)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_2.getDefectTitle());
        Assert.assertTrue(verificationUtils.verifyDefectAllFieldsAndDropDownOptions(DATA_FOR_TEST_DEFECT_2));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new defect filling in the required fields and attaching a file" +
            "to it")
    public void createDefectFillingInRequiredFieldsAndAttachingFileTest() {
        loginPage.login(EMAIL, PASSWORD)
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectsSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFieldsAndAttachingFile(DATA_FOR_TEST_DEFECT_3, "TestCase.txt")
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_3.getDefectTitle());
        Assert.assertTrue(verificationUtils.verifyDefectInputAndTextFields(DATA_FOR_TEST_DEFECT_3));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new defect and resolves it")
    public void resolveCreatedDefectTest() {
        loginPage.login(EMAIL, PASSWORD)
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectsSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFieldsAndSelectingSeverity(DATA_FOR_TEST_DEFECT_4)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_4.getDefectTitle());
        defectPage.resolveDefect();
        Assert.assertEquals(defectPage.getDefectStatus(), RESOLVED_DEFECT_STATUS);
    }
}
