package api.adapters;

import api.objects.testPlanObjects.*;
import io.restassured.response.Response;

public class TestPlanAdapter extends BaseAdapter {

    public int createTestPlan(String projectCode, CreateTestPlan testPlan) {
        return post(String.format(TEST_PLAN_URI, projectCode), converter.toJson(testPlan, CreateTestPlan.class))
                .body().path("result.id");
    }

    public Result getSpecificTestPlan(String projectCode, int id) {
        Response response = get(String.format(SPECIFIC_TEST_PLAN_URI, projectCode, id));
        return response.body().jsonPath().getObject("result", Result.class);
    }
}
