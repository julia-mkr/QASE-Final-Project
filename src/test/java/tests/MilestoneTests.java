package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.MilestoneTestData;
import ui.utils.PropertyReader;

public class MilestoneTests extends BaseTest implements MilestoneTestData {

    @Test
    public void createMilestoneFillingInRequiredFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnMilestonesSubMenuOption()
                .clickOnCreateMilestoneButton()
                .createMilestoneFillingInRequiredFields(DATA_FOR_TEST_MILESTONE_1);
        Assert.assertTrue(verificationUtils.verifyMilestoneInputAndTextFields(DATA_FOR_TEST_MILESTONE_1));
    }

    @Test
    public void createMilestoneFillingInAllFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")))
                .clickOnProject(PROJECT_TITLE)
                .clickOnMilestonesSubMenuOption()
                .clickOnCreateMilestoneButton()
                .createMilestoneFillingInAllFields(DATA_FOR_TEST_MILESTONE_2);
        Assert.assertTrue(verificationUtils.verifyMilestoneInputAndTextFields(DATA_FOR_TEST_MILESTONE_2));
    }
}
