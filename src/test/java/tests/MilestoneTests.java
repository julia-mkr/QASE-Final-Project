package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.MilestoneTestData;

public class MilestoneTests extends BaseTest implements MilestoneTestData {

    @Test(groups = {"Smoke"}, description = "The test creates a milestone filling in the required fields")
    @Description("Creation of a new milestone with filling in only the required fields")
    public void createMilestoneFillingInRequiredFieldsTest() {
        projectRepositorySteps.loginAndClickOnProject(driver,EMAIL, PASSWORD, PROJECT_TITLE)
                .clickOnMilestonesSubMenuOption()
                .clickOnCreateMilestoneButton()
                .createMilestoneFillingInRequiredFields(DATA_FOR_TEST_MILESTONE_1);
        Assert.assertTrue(verificationUtils.verifyMilestoneInputAndTextFields(DATA_FOR_TEST_MILESTONE_1));
    }

    @Test(groups = {"Critical"}, description = "The test creates a milestone filling in all the fields")
    @Description("Creation of a new milestone with filling in all the fields")
    public void createMilestoneFillingInAllFieldsTest() {
        projectRepositorySteps.loginAndClickOnProject(driver,EMAIL, PASSWORD, PROJECT_TITLE)
                .clickOnMilestonesSubMenuOption()
                .clickOnCreateMilestoneButton()
                .createMilestoneFillingInAllFields(DATA_FOR_TEST_MILESTONE_2);
        Assert.assertTrue(verificationUtils.verifyMilestoneInputAndTextFields(DATA_FOR_TEST_MILESTONE_2));
    }
}
