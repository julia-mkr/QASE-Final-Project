package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.utils.PropertyReader;

public class SuiteTests extends BaseTest {

    @Test
    public void createSuiteFillingInRequiredFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject("Project 2")
                .clickOnCreateSuiteButton()
                .createSuiteFillingInRequiredFields("Smoke Tests");
        Assert.assertTrue(projectRepositoryPage.isCreatedSuiteDisplayed("Smoke Tests"));
    }

    @Test
    public void createSuiteFillingInAllFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject("Project 2")
                .clickOnCreateSuiteButton()
                .createSuiteFillingInAllFields("Regression Tests", "Description of the suite", "Preconditions");
        Assert.assertTrue(projectRepositoryPage.isCreatedSuiteDisplayed("Regression Tests"));
    }
}
