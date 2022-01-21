package api.adapters;

import api.objects.testPlanObjects.*;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class TestPlanAdapter extends BaseAdapter {

    @Step("Create a test plan with the plan title: '{testPlan.title}', the description: '{testPlan.description}' " +
            "using the project code: '{projectCode}")
    public int createTestPlan(String projectCode, CreateTestPlan testPlan) {
        return post(String.format(TEST_PLAN_URI, projectCode), converter.toJson(testPlan, CreateTestPlan.class))
                .body().path("result.id");
    }

    @Step("Get a specific test plan by id: '{id}' using the project code: '{projectCode}")
    public Result getSpecificTestPlan(String projectCode, int id) {
        Response response = get(String.format(SPECIFIC_TEST_PLAN_URI, projectCode, id));
        return response.body().jsonPath().getObject("result", Result.class);
    }
}
