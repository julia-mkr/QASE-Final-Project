package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestCaseData;

public class CaseTests extends BaseTest implements TestCaseData {

    @Test(groups = {"Smoke"}, description = "The test creates a new test case filling in the required fields")
    @Description("Creation of a new test case with filling in only the required fields")
    public void createTestCaseFillingInRequiredFieldsTest() {
        projectRepositorySteps.loginAndClickOnProject(driver,EMAIL, PASSWORD, PROJECT_TITLE)
                .clickOnCreateCaseButton()
                .createTestCaseFillingInRequiredFields(DATA_FOR_TEST_CASE_1)
                .clickOnTestCase(DATA_FOR_TEST_CASE_1.getTitle());
        Assert.assertTrue(createTestCasePage.isEnteredTextDisplayed(DATA_FOR_TEST_CASE_1.getTitle()));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new test case filling in the required fields and " +
            "selecting value options from some dropdown menus")
    @Description("Creation of a new test case with filling in the required fields and selecting values from from the 'Suite', " +
            "'Priority', 'Type', 'Layer', and 'Automation status' dropdowns")
    public void createTestCaseFillingInRequiredFieldsAndSelectingValuesFromDropdownMenuTest() {
        projectRepositorySteps.loginAndClickOnProject(driver,EMAIL, PASSWORD, PROJECT_TITLE)
                .clickOnCreateCaseButton()
                .createTestCaseFillingInRequiredFieldsAndSelectingOptionsFromDropdowns(DATA_FOR_TEST_CASE_2)
                .clickOnTestCase(DATA_FOR_TEST_CASE_2.getTitle());
        Assert.assertTrue(verificationUtils.verifyTestCaseInputFieldsAndDropdownOptions(DATA_FOR_TEST_CASE_2));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new test case filling in the required fields and attaching a file" +
            "to it")
    @Description("Creation of a new test case with filling in the required fields and attaching a file to it")
    public void createTestCaseFillingInRequiredFieldsAndAttachingFileTest() {
        projectRepositorySteps.loginAndClickOnProject(driver,EMAIL, PASSWORD, PROJECT_TITLE)
                .clickOnCreateCaseButton()
                .createTestcaseFillingInSomeFieldsAndAttachingFile(DATA_FOR_TEST_CASE_3, ATTACHING_FILE)
                .clickOnTestCase(DATA_FOR_TEST_CASE_3.getTitle());
        Assert.assertTrue(createTestCasePage.isEnteredTextDisplayed(DATA_FOR_TEST_CASE_3.getTitle()));
        Assert.assertTrue(createTestCasePage.isEnteredTextDisplayed(DATA_FOR_TEST_CASE_3.getDescription()));
    }

    @Test(groups = {"Smoke"}, description = "The test creates a new test case filling in the required fields and all the text fields")
    @Description("Creation of a new test case with filling in all the input fields such as: 'Title', 'Description', 'Pre-conditions', " +
            "'Post-condition' and adds steps to reproduce")
    public void createTestCaseFillingInInputFieldsTest() {
        projectRepositorySteps.loginAndClickOnProject(driver,EMAIL, PASSWORD, PROJECT_TITLE)
                .clickOnCreateCaseButton()
                .createTestCaseFillingInInputFields(DATA_FOR_TEST_CASE_4)
                .clickOnTestCase(DATA_FOR_TEST_CASE_4.getTitle());
        Assert.assertTrue(verificationUtils.verifyTestCaseInputAndTextFields(DATA_FOR_TEST_CASE_4));
    }
}
