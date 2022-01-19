package api.adapters;

import api.objects.caseObjects.CreateTestCase;
import api.objects.caseObjects.Result;
import io.restassured.response.Response;

public class CaseAdapter extends BaseAdapter {

    public int createTestCase(String projectCode, CreateTestCase testCase) {
        return post(String.format(CASE_URI, projectCode), converter.toJson(testCase)).body().path("result.id");
    }

    public Result getSpecificTestCase(String projectCode, int id) {
        Response response = get(String.format(SPECIFIC_CASE_URI, projectCode, id));
        return response.body().jsonPath().getObject("result", Result.class);
    }

    public int createTestCaseAndUploadFileToIt(String projectCode, CreateTestCase testCase) {
        return post(String.format(CASE_URI, projectCode), gson.toJson(testCase)).body().path("result.id");
    }
}
