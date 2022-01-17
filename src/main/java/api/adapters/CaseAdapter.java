package api.adapters;

import api.objects.caseObjects.CreateTestCase;
import api.objects.caseObjects.Result;
import api.objects.caseObjects.Root;

public class CaseAdapter extends BaseAdapter {

    public int createTestCase(String projectCode, CreateTestCase testCase) {
        return post(String.format(CASE_URI, projectCode), converter.toJson(testCase)).body().path("result.id");
    }

    public Result getSpecificTestCase(String projectCode, int id) {
        String body = get(String.format(SPECIFIC_CASE_URI, projectCode, id));
        Root root = gson.fromJson(body, Root.class);
        return root.getResult();
    }

    public int createTestCaseAndUploadFileToIt(String projectCode, CreateTestCase testCase) {
        return post(String.format(CASE_URI, projectCode), gson.toJson(testCase)).body().path("result.id");
    }
}
