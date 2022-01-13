package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.utils.PropertyReader;

public class TestPlanTests extends BaseTest {

    @Test
    public void createTestPlanFillingInAllFieldsAndAddingTests() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnTestPlansSubMenuOption()
                .clickOnCreateButton()
                .createTestPlanFillingInAllFieldsAndAddingTestCases(TEST_PLAN_TITLE, TEST_PLAN_DESCRIPTION, SUITE_NAME_FOR_TEST_PLAN);
        Assert.assertTrue(testPlansPage.isCreatedTestPlanNameDisplayed(TEST_PLAN_TITLE));
    }
}
