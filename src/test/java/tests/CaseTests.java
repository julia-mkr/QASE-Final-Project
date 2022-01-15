package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestCaseData;
import ui.pages.CreateTestCasePage;
import ui.utils.*;

public class CaseTests extends BaseTest implements TestCaseData {

    @Test(groups = {"Smoke"}, description = "The test creates a new test case filling in the required fields")
    public void createTestCaseFillingInRequiredFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnCreateCaseButton()
                .createTestCaseFillingInRequiredFields(DATA_FOR_TEST_CASE_1)
                .clickOnTestCase(DATA_FOR_TEST_CASE_1.getTitle());
        Assert.assertTrue(createTestCasePage.isEnteredTextDisplayed(DATA_FOR_TEST_CASE_1.getTitle()));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new test case filling in the required fields and " +
            "selecting value options from some dropdown menus")
    public void createTestCaseFillingInRequiredFieldsAndSelectingValuesFromDropdownMenuTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnCreateCaseButton()
                .createTestCaseFillingInRequiredFieldsAndSelectingOptionsFromDropdowns(DATA_FOR_TEST_CASE_2)
                .clickOnTestCase(DATA_FOR_TEST_CASE_2.getTitle());
        Assert.assertTrue(verificationUtils.verifyTestCaseInputFieldsAndDropdownOptions(DATA_FOR_TEST_CASE_2));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new test case filling in the required fields and attaching a file" +
            "to it")
    public void createTestCaseFillingInRequiredFieldsAndAttachingFileTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnCreateCaseButton()
                .createTestSuiteFillingInSomeFieldsAndAttachingFile(DATA_FOR_TEST_CASE_3, "TestCase.txt")
                .clickOnTestCase(DATA_FOR_TEST_CASE_3.getTitle());
        Assert.assertTrue(createTestCasePage.isEnteredTextDisplayed(DATA_FOR_TEST_CASE_3.getTitle()));
        Assert.assertTrue(createTestCasePage.isEnteredTextDisplayed(DATA_FOR_TEST_CASE_3.getDescription()));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new test case filling in the required fields and all the text fields")
    public void createTestCaseFillingInInputFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnCreateCaseButton()
                .createTestCaseFillingInInputFields(DATA_FOR_TEST_CASE_4)
                .clickOnTestCase(DATA_FOR_TEST_CASE_4.getTitle());
        Assert.assertTrue(verificationUtils.verifyTestCaseInputAndTextFields(DATA_FOR_TEST_CASE_4));
    }
}
