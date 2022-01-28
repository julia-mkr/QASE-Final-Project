package testData.apiTestData;

import api.objects.testPlanObjects.CreateTestPlan;

import java.util.ArrayList;
import java.util.Arrays;

public interface ApiTestPlanData extends ApiConstants {

    CreateTestPlan API_TEST_PLAN_DATA_1 = CreateTestPlan.builder()
            .title("Test Plan 5")
            .description("This is the description for Test Plan 5. It includes new test cases.")
            .cases(new ArrayList<>(Arrays.asList(38, 40, 328)))
            .build();
}
