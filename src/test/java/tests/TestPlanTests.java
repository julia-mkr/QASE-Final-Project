package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPlanTests extends BaseTest {

    @Test(groups = "Smoke", description = "The test creates a test plan filling in all the fields and adding test cases to it")
    @Description("Creation of a new test plan with filling in all the fields and adding of a suite of test cases")
    public void createTestPlanFillingInAllFieldsAndAddingTests() throws InterruptedException {
        projectRepositorySteps.loginAndClickOnProject(driver, EMAIL, PASSWORD, PROJECT_TITLE)
                .clickOnTestPlansSubMenuOption()
                .clickOnCreateButton()
                .createTestPlanFillingInAllFieldsAndAddingTestCases(TEST_PLAN_TITLE, TEST_PLAN_DESCRIPTION, SUITE_NAME_FOR_TEST_PLAN);
        Assert.assertTrue(testPlansPage.isCreatedTestPlanNameDisplayed(TEST_PLAN_TITLE));
    }
}
