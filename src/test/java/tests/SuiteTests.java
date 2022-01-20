package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestSuiteData;

public class SuiteTests extends BaseTest implements TestSuiteData {

    @Test(groups = {"Smoke"}, description = "The test creates a test suite filling in the required fields")
    public void createSuiteFillingInRequiredFieldsTest() {
        loginPage.login(EMAIL, PASSWORD)
                .clickOnProject(PROJECT_TITLE)
                .clickOnCreateSuiteButton()
                .createSuiteFillingInRequiredFields(DATA_FOR_TEST_SUITE_1);
        Assert.assertTrue(projectRepositoryPage.isCreatedSuiteDisplayed("Smoke Tests"));
    }

    @Test(groups = {"Critical"}, description = "The test create a test suite filling in all the fields")
    public void createSuiteFillingInAllFieldsTest() {
        loginPage.login(EMAIL, PASSWORD)
                .clickOnProject(PROJECT_TITLE)
                .clickOnCreateSuiteButton()
                .createSuiteFillingInAllFields(DATA_FOR_TEST_SUITE_2);
        Assert.assertTrue(projectRepositoryPage.isCreatedSuiteDisplayed("Regression Tests"));
    }
}
