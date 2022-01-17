package api.adapters;

import api.objects.testPlanObjects.*;

public class TestPlanAdapter extends BaseAdapter {

    public int createTestPlan(String projectCode, CreateTestPlan testPlan) {
        return post(String.format(TEST_PLAN_URI, projectCode), converter.toJson(testPlan, CreateTestPlan.class))
                .body().path("result.id");
    }

    public Result getSpecificTestPlan(String projectCode, int id) {
        String body = get(String.format(SPECIFIC_TEST_PLAN_URI, projectCode, id));
        Root root = converter.fromJson(body, Root.class);
        return root.getResult();
    }
}
