package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestSuiteData;
import ui.utils.PropertyReader;

public class SuiteTests extends BaseTest implements TestSuiteData {

    @Test(groups = {"Smoke"}, description = "The test creates a test suite filling in the required fields")
    public void createSuiteFillingInRequiredFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnCreateSuiteButton()
                .createSuiteFillingInRequiredFields(DATA_FOR_TEST_SUITE_1);
        Assert.assertTrue(projectRepositoryPage.isCreatedSuiteDisplayed("Smoke Tests"));
    }

    @Test(groups = {"Critical"}, description = "The test create a test suite filling in all the fields")
    public void createSuiteFillingInAllFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnCreateSuiteButton()
                .createSuiteFillingInAllFields(DATA_FOR_TEST_SUITE_2);
        Assert.assertTrue(projectRepositoryPage.isCreatedSuiteDisplayed("Regression Tests"));
    }
}
