package api.adapters;

import api.objects.CreateTestCase;

public class CaseAdapter extends BaseAdapter {

    public int createTestCase(String projectCode, CreateTestCase testCase) {
        return post(String.format(CASE_URI, projectCode), converter.toJson(testCase))
                .body().path("result.id");
    }

    public void getSpecificTestCase(String projectCode, int id) {
        get(String.format(SPECIFIC_CASE_URI, projectCode, id));
    }
}
