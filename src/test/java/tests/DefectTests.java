package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestDefectData;
import ui.utils.PropertyReader;
import ui.utils.VerificationUtils;

public class DefectTests extends BaseTest implements TestDefectData {

    @Test
    public void createDefectFillingInRequiredFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFields(DATA_FOR_TEST_DEFECT_1)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_1.getDefectTitle());
        Assert.assertTrue(VerificationUtils.verifyDefectInputAndTextFields(driver, DATA_FOR_TEST_DEFECT_1));
    }

    @Test
    public void createDefectFillingInAllFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInAllFields(DATA_FOR_TEST_DEFECT_2)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_2.getDefectTitle());
        Assert.assertTrue(VerificationUtils.verifyDefectAllFieldsAndDropDownOptions(driver, DATA_FOR_TEST_DEFECT_2));
    }

    @Test
    public void createDefectFillingInRequiredFieldsAndAttachingFileTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFieldsAndAttachingFile(DATA_FOR_TEST_DEFECT_3, "TestCase.txt")
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_3.getDefectTitle());
        Assert.assertTrue(VerificationUtils.verifyDefectInputAndTextFields(driver, DATA_FOR_TEST_DEFECT_3));
    }

    @Test
    public void resolveCreatedDefectTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnDefectSubMenuOption()
                .clickOnCreateNewDefectButton()
                .createNewDefectFillingInRequiredFieldsAndSelectingSeverity(DATA_FOR_TEST_DEFECT_4)
                .clickOnDefectTitle(DATA_FOR_TEST_DEFECT_4.getDefectTitle());
        defectPage.resolveDefect();
        Assert.assertEquals(defectPage.isDefectStatusResolved(), "Resolved");
    }
}
