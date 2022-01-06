package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestCaseData;
import ui.pages.CreateTestCasePage;
import ui.utils.*;

public class CaseTests extends BaseTest implements TestCaseData {

    @Test
    public void createTestCaseFillingInRequiredFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject("Project 2")
                .clickOnCreateCaseButton()
                .createTestCaseFillingInRequiredFields(DATA_FOR_TEST_CASE_1)
                .clickOnTestCase(DATA_FOR_TEST_CASE_1.getTitle());
        Assert.assertTrue(CreateTestCasePage.isEnteredTextDisplayed(driver, DATA_FOR_TEST_CASE_1.getTitle()));
    }

    @Test
    public void createTestCaseFillingInRequiredFieldsAndSelectingValuesFromDropdownMenuTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject("Project 2")
                .clickOnCreateCaseButton()
                .createTestCaseFillingInRequiredFieldsAndSelectingOptionsFromDropdowns(DATA_FOR_TEST_CASE_2)
                .clickOnTestCase(DATA_FOR_TEST_CASE_2.getTitle());
        Assert.assertTrue(VerificationUtils.verifyTestCaseInputFieldsAndDropdownOption(driver, DATA_FOR_TEST_CASE_2));
    }

    @Test
    public void createTestCaseFillingInRequiredFieldsAndAttachingFileTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject("Project 2")
                .clickOnCreateCaseButton()
                .createTestSuiteFillingInSomeFieldsAndAttachingFile(DATA_FOR_TEST_CASE_3, "TestCase.txt")
                .clickOnTestCase(DATA_FOR_TEST_CASE_3.getTitle());
        Assert.assertTrue(CreateTestCasePage.isEnteredTextDisplayed(driver, DATA_FOR_TEST_CASE_3.getTitle()));
        Assert.assertTrue(CreateTestCasePage.isEnteredTextDisplayed(driver, DATA_FOR_TEST_CASE_3.getDescription()));
    }

    @Test
    public void createTestCaseFillingInInputFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject("Project 2")
                .clickOnCreateCaseButton()
                .createTestCaseFillingInInputFields(DATA_FOR_TEST_CASE_4)
                .clickOnTestCase(DATA_FOR_TEST_CASE_4.getTitle());
        VerificationUtils.verifyTestCaseInputAndTextFields(driver, DATA_FOR_TEST_CASE_4);
    }
}
