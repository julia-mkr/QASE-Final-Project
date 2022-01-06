package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestSuiteData;
import ui.utils.PropertyReader;

public class SuiteTests extends BaseTest implements TestSuiteData {

    @Test
    public void createSuiteFillingInRequiredFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject("Project 2")
                .clickOnCreateSuiteButton()
                .createSuiteFillingInRequiredFields(DATA_FOR_TEST_SUITE_1);
        Assert.assertTrue(projectRepositoryPage.isCreatedSuiteDisplayed("Smoke Tests"));
    }

    @Test
    public void createSuiteFillingInAllFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject("Project 2")
                .clickOnCreateSuiteButton()
                .createSuiteFillingInAllFields(DATA_FOR_TEST_SUITE_2);
        Assert.assertTrue(projectRepositoryPage.isCreatedSuiteDisplayed("Regression Tests"));
    }
}
