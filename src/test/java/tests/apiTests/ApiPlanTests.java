package tests.apiTests;

import api.adapters.TestPlanAdapter;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.apiTestData.ApiTestPlanData;

public class ApiPlanTests implements ApiTestPlanData {

    TestPlanAdapter testPlanAdapter = new TestPlanAdapter();

    @Test(groups = "Smoke", description = "The test creates a test plan using API")
    public void createTestPlan() {
        int planId = testPlanAdapter.createTestPlan(PROJECT_CODE, API_TEST_PLAN_DATA_1);
        String planTitle = testPlanAdapter.getSpecificTestPlan(PROJECT_CODE, planId).getTitle();
        Assert.assertEquals(planTitle, API_TEST_PLAN_DATA_1.getTitle());
    }
}
