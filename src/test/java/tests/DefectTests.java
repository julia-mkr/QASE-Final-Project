package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.DefectTestData;
import ui.utils.PropertyReader;

public class DefectTests extends BaseTest implements DefectTestData {

    @Test(groups = {"Smoke"}, description = "The test creates a new defect filling in the required fields")
    public void createDefectFillingInRequiredFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFields(DATA_FOR_TEST_DEFECT_1)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_1.getDefectTitle());
        Assert.assertTrue(verificationUtils.verifyDefectInputAndTextFields(DATA_FOR_TEST_DEFECT_1));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new defect filling in all the fields and selecting value " +
            "options from dropdown menus")
    public void createDefectFillingInAllFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInAllFields(DATA_FOR_TEST_DEFECT_2)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_2.getDefectTitle());
        Assert.assertTrue(verificationUtils.verifyDefectAllFieldsAndDropDownOptions(DATA_FOR_TEST_DEFECT_2));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new defect filling in the required fields and attaching a file" +
            "to it")
    public void createDefectFillingInRequiredFieldsAndAttachingFileTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFieldsAndAttachingFile(DATA_FOR_TEST_DEFECT_3, "TestCase.txt")
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_3.getDefectTitle());
        Assert.assertTrue(verificationUtils.verifyDefectInputAndTextFields(DATA_FOR_TEST_DEFECT_3));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new defect and resolves it")
    public void resolveCreatedDefectTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFieldsAndSelectingSeverity(DATA_FOR_TEST_DEFECT_4)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_4.getDefectTitle());
        defectPage.resolveDefect();
        Assert.assertEquals(defectPage.getDefectStatus(), RESOLVED_DEFECT_STATUS);
    }
}
